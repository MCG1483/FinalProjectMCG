package org.example;

import PageObjects.ContactInfoPage;
import PageObjects.PersonalInfoPage;
import PageObjects.MainPage;
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

    // Cream o metoda Constructor
    public StepDefinitions() {
        //Mareste Browser-ul
        driver.manage().window().maximize();
        //Initializeaza obiectele
        mainPage = new MainPage(driver);
        personalInfoPage = new PersonalInfoPage(driver);
        contactInfoPage = new ContactInfoPage(driver);
    }

    // Scenariile 1,2
    @Given("I am on the main page")
    public void iAmOnTheMainPage() {
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

    @When("I fill the first name field with numbers or special characters of {string}")
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
        Assert.assertEquals(personalInfoPage.getPersonalInformationHeader(), "Personal information");
    }

    // Scenariul 4
    @When("I click the Questions button")
    public void iClickTheQuestionButton() {mainPage.clickOnQuestionsButton(); }

    @Then("the page goes down to the FAQ section")
    public void thePageGoesDownToFaq() {
        Assert.assertEquals(mainPage.getFaqHeader(), "Frequently Asked Questions");
    }

    // Scenariul 5
    @Given("I am on the contact information page")
    public void iAmOnTheContactInfoPage() {
        driver.get("file:///C:/Users/MARIUS/Desktop/Descarcari%20GitHub/Testing-Env/routes/enrollment.html");
        // Completez campurile din Personal information si apas next ca sa ne transfere pe pagina ContactInfo
        personalInfoPage.fillInPersonalInformation();
        Utils.scrollToElement(driver, personalInfoPage.getNextButton());
        personalInfoPage.clickOnNextButton();
    }

    @When("I fill the phone field with letters of {string}")
    public void iFillPhoneField(String string) {contactInfoPage.fillPhoneField(string);}

    @When("I click the next button from contact info page")
    public void iClickTheNextButtonFromContactInfoPage(){
        Utils.scrollToElement(driver, contactInfoPage.getNextButton());
        contactInfoPage.clickOnNextButton();}

    @Then("the system keeps me on the contact information page")
    public void the_system_keeps_me_on_the_contact_information_page() {
        Assert.assertEquals(contactInfoPage.getContactInformationHeader(), "Contact information");}



    // Inchide Browser-ul cand se termina testarea. Se foloseste o singura data.

        @After
        public void cleanUp () {
            driver.quit();
        }


    }
