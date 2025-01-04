package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestUtil;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class FarmSetup extends BasePage {

    @FindBy(xpath = "//*[@id='SANDYSETUP']//a[contains(text(),'Farm setup')]")
    WebElement farmSetup;

    @FindBy(xpath = "//*[text()='Add your farm']/../following-sibling::div//button")
    WebElement addFarm;

    @FindBy(id = "formBasicPassword")
    WebElement farmName;

    @FindBy(xpath = "//button[contains(@class,'accordion-button')]//*[text()='Farm address']")
    WebElement farmAddressRadioButton;

    @FindBy(xpath = "//button[contains(@class,'accordion-button')]//*[text()='Farm coordinates']")
    WebElement farmCordinatesRadioButton;

    @FindBy(xpath = "//*[text()='Select address']/..//input")
    WebElement selectAddress;

    @FindBy(xpath = "(//*[contains(text(),'Transport')])/../span")
    WebElement transport;

    @FindBy(xpath = "(//*[contains(text(),'Arable ')])/../span")
    WebElement aribleAndHorticulture;

    @FindBy(xpath = "(//*[@class='cursor'])[2]")
    WebElement addYear;

    @FindBy(xpath = "(//*[@class='cursor'])[1]")
    WebElement removeYear;

    @FindBy(id = "custom-switch")
    WebElement addRemoveNextYearToggleButton;

    String coordinates = "//*[@id='txtFarm"+dynamicText+"']";
    String successMessage = "//div[@class='modal-content']//div[text()='"+dynamicText+"']";
    String editButton = "//*[text()='"+dynamicText+"']/../..//*[@data-testid='EditOutlinedIcon']";
    String deleteButton = "//*[text()='"+dynamicText+"']/../..//*[@data-testid='DeleteOutlineIcon']";


    Logger log = BaseLib.getLog(this.getClass().getName());

    public FarmSetup(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToFarmSetupPage(){
        farmSetup.click();
    }

    public void clickAddFarm() throws InterruptedException {
        TestUtil.waitForElementClickable(driver, addFarm, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(3000);
        addFarm.click();
    }

    public void enterFarmRequiredDetails(String farm_Name, String farmAddress) throws InterruptedException {
        farmAddressRadioButton.click();
        TestUtil.waitForElementClickable(driver, selectAddress, Duration.of(10, ChronoUnit.SECONDS));
        selectAddress.sendKeys(farmAddress);
        TestUtil.staticWait(3000);
        selectAddress.sendKeys(Keys.RETURN);
    }

    public void selectEnterprise(String enterpriseName){
        if (enterpriseName.equalsIgnoreCase("Arable & Horticulture")){
            TestUtil.waitForElementClickable(driver, aribleAndHorticulture, Duration.of(10, ChronoUnit.SECONDS));
            aribleAndHorticulture.click();
        } else if (enterpriseName.equalsIgnoreCase("Transport")) {
            TestUtil.waitForElementClickable(driver, transport, Duration.of(6, ChronoUnit.SECONDS));
            transport.click();
        }
    }

    public void expandFarmCoordinates(){
        farmCordinatesRadioButton.click();

    }

    public void selectCordinates(String text, String data){
      WebElement ele =  prepareWebElementWithDynamicXpath(coordinates, text);
      ele.sendKeys(data);

    }

    public void enterFarmName(String farm_Name){
        TestUtil.waitForElementClickable(driver, farmName, Duration.of(10, ChronoUnit.SECONDS));
        farmName.clear();
        farmName.sendKeys(farm_Name);
    }

    public void addOrRemoveYear(String action, String noOfyear){
        int num = Integer.parseInt(noOfyear);
        if (action.equalsIgnoreCase("add")){
            for (int i=0; i<num; i++){
                addYear.click();
            }
        } else if (action.equalsIgnoreCase("remove")) {
            for (int i=0;i<num; i++){
                removeYear.click();
            }
        }
    }

    public void addOrRemoveDataForNextYear(String action){
        if (action.equalsIgnoreCase("add")){
            addRemoveNextYearToggleButton.click();
        }
    }

    public void verifySuccessfulMessage(String message){
        WebElement successfullMsg = prepareWebElementWithDynamicXpath(successMessage, message);
        TestUtil.waitForElementVisible(driver, successfullMsg, Duration.of(10, ChronoUnit.SECONDS) );
        Assert.assertTrue(successfullMsg.isDisplayed());
        TestUtil.waitForElementToDisappear(driver, successfullMsg, Duration.of(10, ChronoUnit.SECONDS));
    }

    public void clickEditButton(String farmName) throws InterruptedException {
        WebElement ele = prepareWebElementWithDynamicXpath(editButton, farmName);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(5000);
        ele.click();
    }

    public void clickDeleteButton(String farmName) throws InterruptedException {
        WebElement ele = prepareWebElementWithDynamicXpath(deleteButton, farmName);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(4000);
        ele.click();

    }




}
