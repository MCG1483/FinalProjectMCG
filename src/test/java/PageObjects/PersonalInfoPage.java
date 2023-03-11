package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {

// Scenariul 3
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    private WebElement firstNameField;
    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement lastNameField;
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement usernameField;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"cpassword\"]")
    private WebElement cpasswordField;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[1]/h3")
    private WebElement personalInformationHeader;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[1]/button")
    private WebElement nextButton;

    // Cream o metoda Constructor care initializeaza elementele din pagina testata
    public PersonalInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    // Cream o metoda care completeaza campurile First Name, Last Name e.t.c.
    public void fillFirstName(String firstName){this.firstNameField.sendKeys(firstName);}
    public void fillLastName (String lastName){this.lastNameField.sendKeys(lastName);}
    public void fillUsername (String username){this.usernameField.sendKeys(username);}
    public void fillPassword (String password){this.passwordField.sendKeys(password);}
    public void fillCpassword (String cPassword){this.cpasswordField.sendKeys(cPassword);}

    // Cream o metoda care apasa butonul Next
    public void clickOnNextButton() {
        this.nextButton.click();
    }

    // Cream o metoda care returneaza textul "Personal information"
    public String getPersonalInformationHeader() {
        return this.personalInformationHeader.getText();}

    public WebElement getNextButton() {
        return this.nextButton;
    }

    public void fillInPersonalInformation() {
        fillFirstName("Marius");
        fillLastName("Cristian");
        fillUsername("MCG1483");
        fillPassword("123456");
        fillCpassword("123456");
    }

}

