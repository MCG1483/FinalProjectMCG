package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneField;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElement countryField;
    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityField;
    @FindBy(xpath = "//*[@id=\"postCode\"]")
    private WebElement postCodeField;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/h3")
    private WebElement contactInformationHeader;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/button[2]")
    private WebElement nextButton;

    // Cream o metoda Constructor care initializeaza elementele din pagina testata
    public ContactInfoPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    // Cream o metoda care completeaza campurile Phone, email, country e.t.c.
    public void fillEmail(String email){this.emailField.sendKeys(email);}
    public void fillPhone(String phone){this.phoneField.sendKeys(phone);}
    public void fillCountry(String email){this.countryField.sendKeys(email);}
    public void fillCity(String email){this.cityField.sendKeys(email);}
    public void fillPostCode(String email){this.postCodeField.sendKeys(email);}


    // Metoda care returneaza elementul web "Butonul Next"
    public WebElement getNextButton() {return this.nextButton;}
    // Metoda care apasa butonul Next
    public void clickOnNextButton() {this.nextButton.click();}


    // Cream o metoda care returneaza textul "Contact information"
    public String getContactInformationHeader() {return this.contactInformationHeader.getText();}

    public void fillInContactInformation() {
        fillPhone("abcdef");
        fillEmail("mariusghe@14yahoo.com");
        fillCountry("Romania");
        fillCity("Bran");
        fillPostCode("507025");
    }





}
