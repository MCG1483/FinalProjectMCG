package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInfoPage {
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[4]/h3")
    private WebElement paymentInfoHeader;
    public PaymentInfoPage(WebDriver driver) {PageFactory.initElements(driver, this);}
    public String getPaymentInfoHeader () {return this.paymentInfoHeader.getText();}

}
