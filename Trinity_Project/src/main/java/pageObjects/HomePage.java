package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestUtil;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class HomePage extends BasePage{

    @FindBy(xpath = "//*[text()='SANDY SETUP']/.")
    WebElement snadySetup;

    @FindBy(xpath = "//*[text()='BIODIVERSITY']/.")
    WebElement bioDiversity;


    Logger log = BaseLib.getLog(this.getClass().getName());

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToSandySetup(){
        snadySetup.click();
    }

    public void navigateToBioDiversity(){
        TestUtil.waitForElementClickable(driver, bioDiversity, Duration.of(10, ChronoUnit.SECONDS));
        bioDiversity.click();

    }
}
