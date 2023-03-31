package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseOptionsPage {

    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/button[2]")
    private WebElement nextButton;
    @FindBy(xpath = "//*[@id=\"flexRadioButton1\"]")
    private WebElement manualTesterButton;
    @FindBy(xpath = "/html/body/div/div/section/div/form/div[3]/h3")
    private WebElement courseOptionsHeader;
    public CourseOptionsPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    public WebElement getNextButton() {return this.nextButton;}
    // Metoda care apasa butonul Next
    public void clickOnNextButton() {this.nextButton.click();}


    public void clickOnManualTesterButton(){this.manualTesterButton.click();}

    public String getCourseOptionsHeader () {return this.courseOptionsHeader.getText();}

}
