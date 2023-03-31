package org.example;

import PageObjects.*;
import io.cucumber.java.After;
import io.cucumber.java.en.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepDefinitions {
    // Initializaeaza Driverul (Chrome)
    private final WebDriver driver = new ChromeDriver();
    // Cream obiectele (Ex. mainPage, personalInfoPage, contactInfoPage)
    private MainPage mainPage;
    private PersonalInfoPage personalInfoPage;
    private ContactInfoPage contactInfoPage;
    private VirtualPage virtualPage;
    private CourseOptionsPage courseOptionsPage;
    private PaymentInfoPage paymentInfoPage;

    private FundamentalsPage fundamentalsPage;


    // Cream o metoda Constructor
    public StepDefinitions() {
        //Mareste Browser-ul
        driver.manage().window().maximize();
        //Initializeaza obiectele
        mainPage = new MainPage(driver);
        personalInfoPage = new PersonalInfoPage(driver);
        contactInfoPage = new ContactInfoPage(driver);
        virtualPage = new VirtualPage(driver);
        courseOptionsPage = new CourseOptionsPage(driver);
        paymentInfoPage = new PaymentInfoPage(driver);
        fundamentalsPage = new FundamentalsPage(driver);

    }

    // Scenariile 1,2
    @Given("I am on the main page")
    public void iAmOnTheMainPage() {
        // Deschide driver-ul
        driver.get("file:///C:/Users/MARIUS/Desktop/Descarcari%20GitHub/Testing-Env/index.html");
    }

    @When("I write the email address of {string}")
    public void i_write_the_email_address_of(String string) {mainPage.writeEmailToEmailField(string);}

    @When("I click the submit button")
    public void i_click_the_submit_button() {mainPage.clickOnSubmitButton();}

    @Then("the confirmation pop-up appears")
    public void theConfirmationPopUpAppears() {driver.switchTo().alert().accept();}

    // Scenariul 3
    @Given("I am on the personal information page")
    public void PersonalInfoPage() {
        driver.get("file:///C:/Users/MARIUS/Desktop/Descarcari%20GitHub/Testing-Env/routes/enrollment.html");
    }

    @When("I fill only the first name as {string}")
    public void iFillFirstName(String string) {personalInfoPage.fillFirstName(string);}

    @When("I click the next button")
    public void i_click_the_next_button() {
        // Ne duce la butonul next
        Utils.scrollToElement(driver, personalInfoPage.getNextButton());
        // Apasa butonul next
        personalInfoPage.clickOnNextButton();
    }

    @Then("the system keeps me on the same page") // Intotdeauna scriem rezultatul asteptat, nu cel afisat
    public void theSystemKeepsMeOnTheSamePage() {
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(personalInfoPage.getPersonalInformationHeader(), "Personal information");
    }

    // Scenariul 4
    @When("I click the Questions button")
    // Metoda fara parametri care apeleaza obiectul mainPage care apeleaza metoda click...
    public void iClickTheQuestionButton() {mainPage.clickOnQuestionsButton(); }

    @Then("the page goes down to the FAQ section")
    public void thePageGoesDownToFaq() {
        Assert.assertEquals(mainPage.getFaqHeader(), "Frequently Asked Questions");
    }

    // Scenariul 5
    @Given("I am on the contact information page")
    public void iAmOnTheContactInfoPage() {
        driver.get("file:///C:/Users/MARIUS/Desktop/Descarcari%20GitHub/Testing-Env/routes/enrollment.html");
        personalInfoPage.fillInPersonalInformation();
        Utils.scrollToElement(driver, personalInfoPage.getNextButton());
        personalInfoPage.clickOnNextButton();
        }
    @When("I fill the email field of {string}")
    public void iFillEmailField(String string) {contactInfoPage.fillEmail(string);}
    @When("I fill the phone field with letters of {string}")
    public void iFillPhoneField(String string) {contactInfoPage.fillPhone(string);}
    @When("I fill the country field of {string}")
    public void iFillCountryField(String string) {contactInfoPage.fillCountry(string);}
    @When("I fill the City field of {string}")
    public void iFillCityField(String string) {contactInfoPage.fillCity(string);}
    @When("I fill the post code field of {string}")
    public void iFillPostCodeField(String string) {contactInfoPage.fillPostCode(string);}
    @When("I click the next button from contact info page")
    public void iClickTheNextButtonFromContactInfoPage(){
        Utils.scrollToElement(driver, contactInfoPage.getNextButton());
        contactInfoPage.clickOnNextButton();}
    @Then("the system keeps me on the contact information page")
    public void theSystemKeepsMeOnTheContactInfopage() {
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(courseOptionsPage.getCourseOptionsHeader(), "Course options");}

    // Scenariul 6
    @When("I click the Read More button from Virtual section")
    public void iClickTheVirtualReadMoreButton() {
        Utils.scrollToElement(driver, mainPage.getEmailField());
        mainPage.clickVirtualReadMoreButton(); }
    @Then("a new page opens")
    public void aNewPageOpens() {Assert.assertEquals(virtualPage.getVirtualHeader(), "Virtual");}

    // Scenariul 7

    @When("I click the Instructors button")
    public void iClickTheInstructorsButton() {mainPage.clickInstructorsButton(); }
    @Then("the page goes down to the Our Instructors section")
    public void thePageGoesDownTo() {Assert.assertEquals(mainPage.getInstructorsHeader(), "Our Instructors");
    }
    // Scenariul 8
    @When("I click the Blue Arrow from the right corner of the end page")
    public void iClickArrowButton (){
        Utils.scrollToElement(driver, mainPage.getContactInfo());
        mainPage.clickArrowUpButton();}
    @Then("the page move back to the top")
    public void thePageMoveToTheTop(){
        Utils.scrollToElement(driver, mainPage.getTheTopOfPage());
    }

    // Scenariul 9
     @Given("I am on the course options page")
     public void iAmOnCourseOptionsPage (){
         driver.get("file:///C:/Users/MARIUS/Desktop/Descarcari%20GitHub/Testing-Env/routes/enrollment.html");
         personalInfoPage.fillInPersonalInformation();
         Utils.scrollToElement(driver, personalInfoPage.getNextButton());
         personalInfoPage.clickOnNextButton();
         contactInfoPage.fillInContactInformation();
         Utils.scrollToElement(driver, contactInfoPage.getNextButton());
         contactInfoPage.clickOnNextButton();}

    @When("I select the manual tester option")
    public void iSelectManualTesterOption (){courseOptionsPage.clickOnManualTesterButton(); }

    @When("I click the next button from the course options page")
    public void iClickTheNextButtonFromCourseOptions () {
        Utils.scrollToElement(driver, courseOptionsPage.getNextButton());
        courseOptionsPage.clickOnNextButton();}

    @Then("a payment information page opens")
    public void paymentInfoPageOpens (){
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(paymentInfoPage.getPaymentInfoHeader(), "Payment information");}

    // Scenariul 10
     @When("I click the Read More button from Learn Selenium section")
     public void iClickLearnSeleniumReadMoreButton  () {
             Utils.scrollToElement(driver, mainPage.getLearnSeleniumHeader());
        mainPage.clickSeleniumReadMoreButton(); }
    @Then("a new page will open")
    public void aNewPageWillOpens() {
        Utils.waitForElementToLoad(2);
        Assert.assertEquals(fundamentalsPage.getFundamentalsHeader(),
            "Fundamentals page");}



    // Inchide Browser-ul cand se termina testarea. Se foloseste o singura data.

        @After
        public void cleanUp () {driver.quit();}


    }
