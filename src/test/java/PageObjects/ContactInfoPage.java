package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement phoneField;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/h3")
    private WebElement contactInformationHeader;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[2]/button[2]")
    private WebElement nextButton;

    // Cream o metoda Constructor care initializeaza elementele din pagina testata
    public ContactInfoPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    // Cream o metoda care completeaza campul Phone
    public void fillPhoneField(String phone){this.phoneField.sendKeys(phone);}

    // Metoda care ne duce la butonul next
    public WebElement getNextButton() {return this.nextButton;}
    // Metoda care apasa butonul Next
    public void clickOnNextButton() {this.nextButton.click();}


    // Cream o metoda care returneaza textul "Contact information"
    public String getContactInformationHeader() {return this.contactInformationHeader.getText();}





}
