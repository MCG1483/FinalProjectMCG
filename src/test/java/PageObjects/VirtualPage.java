package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VirtualPage {
    @FindBy(xpath = "/html/body/h1")
    private WebElement virtualHeader;
    public VirtualPage (WebDriver driver) {PageFactory.initElements(driver, this);}
    public String getVirtualHeader () {return this.virtualHeader.getText();}
}
