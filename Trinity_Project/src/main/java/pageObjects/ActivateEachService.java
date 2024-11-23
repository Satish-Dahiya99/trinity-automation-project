package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestUtil;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

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

    @FindBy(xpath = "//div[text()='Biodiversity']/..//button")
    WebElement biodiversityManageData;

    @FindBy(xpath = "//div[@data-id=1]//div[@title]")
    List<WebElement> bioDiversityCropNameGenInfo;

    @FindBy(xpath = "//div[@role='presentation']//div[text()='No rows']")
    WebElement noRows;

    @FindBy(css = "button#demo-customized-button")
    WebElement bulkEditButton;

    @FindBy(xpath = "//div[text()='Value']")
    WebElement valueText;

    @FindBy(xpath = "(//div[@class='filter-records']//input[@type='checkbox'])[1]")
    WebElement selectAllCheckboxforField;

    @FindBy(xpath = "//div[@data-id=2]//div[@title]")
    List<WebElement> replicatedData;

    @FindBy(xpath = "//div[contains(@data-id,'auto-generated-row-basicInfo')]//input/..")
    WebElement generalInfoSelectAllCheckbox;


    String manageDataButton = "//div[text()='"+dynamicText+"']/..//button";
    String filterSelection = "//div[contains(@class,'"+dynamicText+"')]//div[contains(@id,'react-select')]";
    //String filterInput = "//div[contains(@class,'"+dynamicText+"')]//input";
    String filterInput = "//div[text()='"+dynamicText+"']/..//input";
    String removeFilter = "(//div[text()='"+dynamicText+"']/../../../following-sibling::div/div)[1]";
    String cropReqDataInput = "//*[text()='"+dynamicText+"']/..//input";
    String footerSaveOrCancel = "//div[contains(@class,'modal-footer')]//button[text()='"+dynamicText+"']";
    String successfulMessage = "//*[text()='Data "+dynamicText+" successfully']";
    String tillageType = "//div[contains(@class,'selectall-td selectcolumn row')]//div[text()='"+dynamicText+"']";
    String selectAllButton = "//*[text()='"+dynamicText+"']/../..//button";
    String filterButton = "//div[text()='"+dynamicText+"']/..//div[@data-value]";
    String bioDiversityGeneralInfo = "//div[contains(@class,'MuiBox-root')]//p[text()='"+dynamicText+"']/following-sibling::p";
    String biodiversityActionButton = "//div[@data-field='actions']//*[contains(@data-testid,'"+dynamicText+"')]";
    String button = "//*[text()='"+dynamicText+"']";
    //String generalInfoData = "//div[@data-id="+dynamicText+"]//div[@title]";



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

    public void clickManageDataButton(String buttonname){
        WebElement ele = prepareWebElementWithDynamicXpath(manageDataButton, buttonname);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        ele.click();
    }

    public void addFilterDataForBiodiversity(String field, String data) throws InterruptedException {
        WebElement fieldInput = prepareWebElementWithDynamicXpath(cropReqDataInput, field);
        TestUtil.waitForElementClickable(driver, fieldInput, Duration.of(10, ChronoUnit.SECONDS));
        fieldInput.sendKeys(data);
        TestUtil.staticWait(1000);
        fieldInput.sendKeys(Keys.DOWN);
        TestUtil.staticWait(1000);
        fieldInput.sendKeys(Keys.RETURN);
        TestUtil.staticWait(1000);
    }

    public void addCroppingDetailsForBiodiversity(String field, String data) throws InterruptedException {

        WebElement input = prepareWebElementWithDynamicXpath(cropReqDataInput, field);
        TestUtil.waitForElementClickable(driver, input, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(2000);
        input.click();
        input.sendKeys(Keys.BACK_SPACE);
        TestUtil.staticWait(2000);
        input.sendKeys(data);
        TestUtil.staticWait(1000);
        input.sendKeys(Keys.DOWN);
        TestUtil.staticWait(1000);
        input.sendKeys(Keys.RETURN);
        TestUtil.staticWait(1000);

    }

    public void selectFilterForBiodiversity(String filter, String data) throws InterruptedException {
        WebElement input = prepareWebElementWithDynamicXpath(filterInput, filter);
        TestUtil.waitForElementClickable(driver, input, Duration.of(15, ChronoUnit.SECONDS));
        TestUtil.staticWait(4000);
        WebElement button = prepareWebElementWithDynamicXpath(filterButton, filter);
        button.click();
        TestUtil.staticWait(2000);

            WebElement input1 = prepareWebElementWithDynamicXpath(filterInput, filter);
            input1.sendKeys(data);
            TestUtil.staticWait(2000);
            input1.sendKeys(Keys.RETURN);

    }

    public void verifyGeneralInformationForBioDiversity(String fieldName, String data){
        WebElement ele = prepareWebElementWithDynamicXpath(bioDiversityGeneralInfo, fieldName);
        Assert.assertTrue(data.equalsIgnoreCase(ele.getText()));
    }

    public boolean verifyCropNameVarietyAndWorkingAreaInFirstRow(String value){

            for (WebElement ele : bioDiversityCropNameGenInfo){
                System.out.println(ele.getText()+"first row *******");
                if (ele.getText().equalsIgnoreCase(value)){

                    return true;
                }
            }
            return false;
    }

    public void verifyValueOfCropNameVarietyAndWorkingAreaInFirstRow(String data){
        Assert.assertTrue(verifyCropNameVarietyAndWorkingAreaInFirstRow(data), data+" is not displayed");
    }

    public void performActionOnBiodiversityGeneralInformation(String actionName){
        WebElement ele = prepareWebElementWithDynamicXpath(biodiversityActionButton, actionName);
        ele.click();
    }

    public void verifyNowRorsAreDisplayed(){
        Assert.assertTrue(noRows.isDisplayed());
    }

    public void clickBulkEditButton(){
        javaScriptExecutorClick(bulkEditButton);
    }

    public void selectFilterOnReplicateRecordsPage(String filter, String data) throws InterruptedException {

        try{

            WebElement input = prepareWebElementWithDynamicXpath(filterInput, filter);
            TestUtil.staticWait(3000);
            input.sendKeys(data);
            input.sendKeys(Keys.RETURN);
            TestUtil.staticWait(1000);
        }catch (Exception e){

            WebElement input1 = prepareWebElementWithDynamicXpath(filterInput, filter);
            input1.click();
            javaScriptToEnterText(input1, data);
            input1.sendKeys(Keys.RETURN);
            TestUtil.staticWait(1000);
        }

        valueText.click();

    }

    public void setSelectAllCheckboxforFieldOnReplicatePage(){
        selectAllCheckboxforField.click();
    }

    public void clickOnButton(String buttonName){
        WebElement ele = prepareWebElementWithDynamicXpath(button, buttonName);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        ele.click();
    }

//    public void verifyReplicatedData(String data){
//        Assert.assertTrue(replicatedData.getText().equalsIgnoreCase(data), data+" is not displayed");
//    }

    public void clickGeneralInformationSelectAllCheckBox() throws InterruptedException {
        TestUtil.waitForElementClickable(driver, generalInfoSelectAllCheckbox, Duration.of(10, ChronoUnit.SECONDS));
        scrollToElement(generalInfoSelectAllCheckbox);
        TestUtil.staticWait(5000);
        javaScriptExecutorClick(generalInfoSelectAllCheckbox);
        //generalInfoSelectAllCheckbox.click();
    }

    public boolean verifyCropNameVarietyAndWorkingAreaInSecondRow(String value){

        for (WebElement ele : replicatedData){
            System.out.println(ele.getText()+" second row *******");
            if (ele.getText().equalsIgnoreCase(value)){

                return true;
            }
        }
        return false;
    }

    public void verifyValueOfCropNameVarietyAndWorkingAreaInSecondRow(String data){
        Assert.assertTrue(verifyCropNameVarietyAndWorkingAreaInSecondRow(data), data+" is not displayed");
    }





}
