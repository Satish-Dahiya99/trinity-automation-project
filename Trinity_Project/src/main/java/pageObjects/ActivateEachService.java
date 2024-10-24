package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestUtil;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ActivateEachService extends BasePage{

    @FindBy(xpath = "//*[@id='SANDYSETUP']//a[contains(text(),' Activate each')]")
    WebElement activateEachSearch;

    @FindBy(xpath = "//div[text()='Carbon']/..//button")
    WebElement carbonManageData;

    @FindBy(xpath = "//div[text()='Cropping Data']/..//button")
    WebElement croppingManageData;

    @FindBy(xpath = "(//*[@id='commonTable']//button)[2]")
    WebElement addCrop;

    @FindBy(id = "selectField")
    WebElement selectField;

    @FindBy(xpath = "(//div[contains(@class,'selectall-td selectcolumn row')]//div)[10]/*")
    WebElement editButton;

    @FindBy(xpath = "(//div[contains(@class,'selectall-td selectcolumn row')]//div)[9]/*")
    WebElement deleteButton;

    @FindBy(xpath = "(//*[@class='modal-footer']//button)[2]")
    WebElement yesDelete;

    @FindBy(xpath = "(//*[@class='modal-footer']//button)[2]")
    WebElement noDelete;



    String filterSelection = "//div[contains(@class,'"+dynamicText+"')]//div[contains(@id,'react-select')]";
    //String filterInput = "//div[contains(@class,'"+dynamicText+"')]//input";
    String filterInput = "//div[text()='"+dynamicText+"']/..//input";
    String removeFilter = "(//div[text()='"+dynamicText+"']/../../../following-sibling::div/div)[1]";
    String cropReqDataInput = "//*[text()='"+dynamicText+"']/..//input";
    String footerSaveOrCancel = "//div[contains(@class,'modal-footer')]//button[text()='"+dynamicText+"']";
    String successfulMessage = "//*[text()='Data "+dynamicText+" successfully']";
    String tillageType = "//div[contains(@class,'selectall-td selectcolumn row')]//div[text()='"+dynamicText+"']";
    String selectAllButton = "//*[text()='"+dynamicText+"']/../..//button";



    Logger log = BaseLib.getLog(this.getClass().getName());

    public ActivateEachService(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToActivateEachSearch(){
        activateEachSearch.click();
    }

    public void clickCarbonManageData() throws InterruptedException {
        TestUtil.waitForElementClickable(driver, carbonManageData, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(4000);
        carbonManageData.click();
    }

    public void clickCroppingManageData(){
        TestUtil.waitForElementClickable(driver, croppingManageData, Duration.of(10, ChronoUnit.SECONDS));
        scrollFromElementFromGivenAmount(croppingManageData);
        javaScriptExecutorClick(croppingManageData);
    }

    public void selectFilter(String filter, String data) throws InterruptedException {
        WebElement input = prepareWebElementWithDynamicXpath(filterInput, filter);
        try{
            TestUtil.staticWait(8000);
            input.sendKeys(data);
        }catch (Exception e){
            TestUtil.staticWait(2000);
            javaScriptToEnterText(input, data);
        }
        input.sendKeys(Keys.RETURN);
    }

    public void removeFilter(String filterData){
        WebElement filterRemoval = prepareWebElementWithDynamicXpath(removeFilter, filterData);
        TestUtil.waitForElementClickable(driver, filterRemoval, Duration.of(10, ChronoUnit.SECONDS));
        filterRemoval.click();
    }

    public void clickAddCropButton() throws InterruptedException {
        TestUtil.waitForElementClickable(driver, addCrop, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(5000);
        javaScriptExecutorClick(addCrop);
    }

    public void selectRequiredDataToAddCrop(String field, String data) throws InterruptedException {
        //TestUtil.waitForElementClickable(driver, selectField, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(5000);
        //selectField.click();
        WebElement input = prepareWebElementWithDynamicXpath(cropReqDataInput, field);
        TestUtil.waitForElementClickable(driver, input, Duration.of(10, ChronoUnit.SECONDS));
        input.sendKeys(data);
        TestUtil.staticWait(1000);
        input.sendKeys(Keys.RETURN);

    }

    public void setDate(String dateField, String priorDays){

        WebElement input = prepareWebElementWithDynamicXpath(cropReqDataInput, dateField);
        input.sendKeys(setPastDate(priorDays));
    }

    public void saveOrCancleButton(String button){
        WebElement buttonName = prepareWebElementWithDynamicXpath(footerSaveOrCancel, button);
        javaScriptExecutorClick(buttonName);
    }

    public void verifyCropDataSuccessfulMessage(String message){
        WebElement msg = prepareWebElementWithDynamicXpath(successfulMessage, message.toLowerCase());
        TestUtil.waitForElementVisible(driver, msg, Duration.of(10, ChronoUnit.SECONDS));
        String successMsg = msg.getText();
        Assert.assertTrue(successMsg.contains(message));
    }

    public void verifyTillageType(String text){
        WebElement ele = prepareWebElementWithDynamicXpath(tillageType, text);
        TestUtil.waitForElementVisible(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        Assert.assertTrue(ele.isDisplayed());
    }

    public void clickEditButton() throws InterruptedException {
        TestUtil.waitForElementClickable(driver, editButton, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(8000);
        editButton.click();
    }

    public void clickDeleteButton() throws InterruptedException {
        TestUtil.waitForElementClickable(driver, deleteButton, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(8000);
        deleteButton.click();
        TestUtil.waitForElementClickable(driver, yesDelete, Duration.of(10, ChronoUnit.SECONDS));
        yesDelete.click();
    }

    public void yesDeleteButton(){
        TestUtil.waitForElementClickable(driver, yesDelete, Duration.of(10, ChronoUnit.SECONDS));
        yesDelete.click();
    }

    public void selectAllButtonOnReplicateRecordsPage(String buttonName) throws InterruptedException {
        WebElement ele = prepareWebElementWithDynamicXpath(selectAllButton, buttonName);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(5000);
        ele.click();

    }

    public void clickButtonOnDeletePopUp(String buttonName){
        if (buttonName.equalsIgnoreCase("Yes")){
            yesDelete.click();
        }else{
            noDelete.click();
        }

    }




}
