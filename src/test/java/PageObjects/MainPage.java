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

    public MainPage(WebDriver driver) {PageFactory.initElements(driver, this);}
// Scenariul 1,2
    // Cream o metoda care apasa butonul "Submit"
    public void clickOnSubmitButton() {
        this.submitButton.click();
    }
    // Cream o metoda care completeaza campul Email
    public void writeEmailToEmailField(String email) {
        this.emailField.sendKeys(email);
    }

// Scenariul 4
    // Cream o metoda care returneaza textul "Frequently Asked Questions"
    public String getFaqHeader(){return this.faqHeader.getText();}
    // Cream o metoda care apasa butonul "Questions"
    public void clickOnQuestionsButton(){this.questionButton.click();}

}