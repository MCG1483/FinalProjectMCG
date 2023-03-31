package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    // Scenariul 1,2
    @FindBy(xpath = "/html/body/section[2]/div/div/div/input")
    private WebElement emailField;
    @FindBy(xpath = "/html/body/section[2]/div/div/div/button")
    private WebElement submitButton;

    // Scenariul 4
    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[2]/a")
    private WebElement questionButton;
    @FindBy(xpath = "//*[@id=\"questions\"]/div/h2")
    private WebElement faqHeader;

    // Scenaiul 6
    @FindBy(xpath = "/html/body/section[3]/div/div/div[1]/div/div/a")
    private WebElement virtualReadMoreButton;
    // Scenariul 7
    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[3]/a")
    private WebElement instructorsButton;
    @FindBy(xpath = "//*[@id=\"instructors\"]/div/h2")
    private WebElement instructorsHeader;
    // Scenariul 8
    @FindBy(xpath = "/html/body/footer/div/a/i")
    private WebElement arrowUpButton;
    @FindBy(xpath = "/html/body/nav/div/a")
    private WebElement topOfPage;
    @FindBy(xpath="/html/body/section[8]/div/div/div[1]/h2")
    private WebElement contactInfo;
    //Scenariul 10
    @FindBy(xpath = "//*[@id=\"learn-selenium\"]/div/div/div[1]/a")
    private WebElement seleniumReadMoreButton;
    @FindBy (xpath = "//*[@id=\"learn-selenium\"]/div/div/div[1]/h2")
    private WebElement learnSeleniumHeader;


    public MainPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    // Scenariul 1,2
    // Cream o metoda care apasa butonul "Submit"
    public void clickOnSubmitButton() {this.submitButton.click();}
    // Cream o metoda care completeaza campul Email
    public void writeEmailToEmailField(String email) {this.emailField.sendKeys(email);}

    // Scenariul 4
    // Cream o metoda care returneaza textul "Frequently Asked Questions"
    public String getFaqHeader(){return this.faqHeader.getText();}
    // Cream o metoda care apasa butonul "Questions"
    public void clickOnQuestionsButton(){this.questionButton.click();}

    // Scenariul 6
    public void clickVirtualReadMoreButton(){this.virtualReadMoreButton.click();}
    public WebElement getEmailField() {return this.emailField;}

    // Scenariul 7
    public void clickInstructorsButton(){this.instructorsButton.click();}
    public String getInstructorsHeader(){return this.instructorsHeader.getText();}

    // Scenariul 8
    public void clickArrowUpButton() {this.arrowUpButton.click();}
    public WebElement getTheTopOfPage (){return topOfPage;}
    public WebElement getContactInfo(){return contactInfo;}

    // Scenariul 10
    public void clickSeleniumReadMoreButton (){this.seleniumReadMoreButton.click();}
    public WebElement getLearnSeleniumHeader(){return learnSeleniumHeader;}


}