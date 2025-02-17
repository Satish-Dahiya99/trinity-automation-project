package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.TestUtil;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FuelMachinery extends BasePage {


    String recordLevel = "//div[@class='form-check']//label[contains(text(),'" + dynamicText + "')]";
    String filterInput = "//div[text()='" + dynamicText + "']/..//input";
    String filterDropdownButton = "// div[text()='" + dynamicText + "']/../following-sibling::div";

    String exactMethodDropdownDataRecord = "//p[contains(text(),'Exact Method')]/ancestor::div[contains(@id,'method-header')]/..//input[@placeholder='" + dynamicText + "']";
    String exactMethodTextDataRecord = "//p[contains(text(),'Exact Method')]/ancestor::div[contains(@id,'method-header')]/..//label[text()='" + dynamicText + "']/../div/input";

    String estimatedMethodDropdownDataRecord = "//p[contains(text(),'Estimate Method')]/ancestor::div[contains(@id,'method-header')]/..//input[@placeholder='" + dynamicText + "']";
    String estimatedMethodTextDataRecord = "//p[contains(text(),'Estimate Method')]/ancestor::div[contains(@id,'method-header')]/..//label[text()='" + dynamicText + "']/../div/input";
    String generalInformationData = "//div[text()='%s']/../../div";
    String actionButtonForMethods = "//div[text()='%s']/../../div//*[contains(@data-testid,'%s')]";
    String methodLastColumn = "//div[text()='%s']/../../div[6]";
    String exactMethodRecordclearButton = "// p[contains(text(),'Exact Method')]/ ancestor::div[contains(@id,'method-header')]/..//input[@placeholder='%s']/..//button[@title='Clear']";
    String estimateMethodRecordclearButton = "// p[contains(text(),'Exact Method')]/ ancestor::div[contains(@id,'method-header')]/..//input[@placeholder='%s']/..//button[@title='Clear']";
    String reqDataInput = "//*[text()='" + dynamicText + "']/..//input";
    String requiredDataInputTextField = "//input[@placeholder='%s']";
    String addedRequiredData = "(//div[contains(@class,'col-md-')]/div[contains(@class,'border-bottom')])[" + dynamicText + "]/div";
    String actionOnRequiredData = "(//div[contains(@class,'col-md-')]/div[contains(@class,'border-bottom')])[%s]//*[contains(@data-testid,'%s')]";
    String editRequiredEncouragedDataDropdownButton = "(//p[contains(text(),'Please provide the information below')]/..//div[contains(@class,'d-flex')])[%s]/div[%s]//div[contains(@class,'-indicatorContainer')]";
    String editRequiredEncouragedDataInputField = "(//p[contains(text(),'Please provide the information below')]/..//div[contains(@class,'d-flex')])[%s]/div[%s]//input";
    String successMessage = "//div[@class='modal-content']//div[text()='" + dynamicText + "']";
    String dropdownValues = "//*[text()='%s']";


    @FindBy(xpath = "//input[@placeholder='Select crop variety']")
    WebElement selectCropVariety;

    @FindBy(xpath = "//input[@aria-label='Select all rows']")
    WebElement selectAllRows;

    @FindBy(xpath = "//div[text()='Exact']/../../div[1]")
    WebElement firstCoulmn;

    @FindBy(xpath = "(//div[contains(@class,'year_class')]//div[contains(@class,'indicatorContainer')])[1]")
    WebElement removeSelectedYear;


    Logger log = BaseLib.getLog(this.getClass().getName());

    public FuelMachinery(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectLevel(String level) {
        prepareWebElementWithDynamicXpath(recordLevel, level).click();
    }

    public void selectFilter(String filter, String data) throws InterruptedException {

        try {
            WebElement dropDownButton = prepareWebElementWithDynamicXpath(filterDropdownButton, filter);
            WebElement input = prepareWebElementWithDynamicXpath(filterInput, filter);
            TestUtil.staticWait(4000);
            dropDownButton.click();
            TestUtil.staticWait(2000);
            input.sendKeys(data);
            TestUtil.staticWait(2000);
            input.sendKeys(Keys.RETURN);
        } catch (Exception e) {
            WebElement dropDownButton1 = prepareWebElementWithDynamicXpath(filterDropdownButton, filter);
            WebElement input1 = prepareWebElementWithDynamicXpath(filterInput, filter);
            dropDownButton1.click();
            TestUtil.staticWait(3000);
            input1.sendKeys(data);
            TestUtil.staticWait(2000);
            input1.sendKeys(Keys.RETURN);
        }
    }

    public void setSelectCropVariety(String cropVariety) throws InterruptedException {
        TestUtil.waitForElementClickable(driver, selectCropVariety, Duration.of(10, ChronoUnit.SECONDS));
        selectCropVariety.sendKeys(cropVariety);
        TestUtil.staticWait(1000);
        selectCropVariety.sendKeys(Keys.ARROW_DOWN);
        selectCropVariety.sendKeys(Keys.RETURN);
    }

    public void selectExactMethodDropdownRecord(String fieldName, String data) throws InterruptedException {
        WebElement encouragedMethodRecord = prepareWebElementWithDynamicXpath(exactMethodDropdownDataRecord, fieldName);
        TestUtil.waitForElementClickable(driver, encouragedMethodRecord, Duration.of(10, ChronoUnit.SECONDS));
        encouragedMethodRecord.sendKeys(data);
        TestUtil.staticWait(1000);
        encouragedMethodRecord.sendKeys(Keys.ARROW_DOWN);
        encouragedMethodRecord.sendKeys(Keys.RETURN);

    }

    public void enterExactMethodTextRecord(String fieldName, String data) throws InterruptedException {
        WebElement encouragedMethodRecord = prepareWebElementWithDynamicXpath(exactMethodTextDataRecord, fieldName);
        TestUtil.waitForElementClickable(driver, encouragedMethodRecord, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(1000);
        javaScriptExecutorClick(encouragedMethodRecord);
        encouragedMethodRecord.sendKeys(data);

    }

    public void selectEstimatedMethodDropdownRecord(String fieldName, String data) throws InterruptedException {
        WebElement encouragedMethodRecord = prepareWebElementWithDynamicXpath(estimatedMethodDropdownDataRecord, fieldName);
        TestUtil.waitForElementClickable(driver, encouragedMethodRecord, Duration.of(10, ChronoUnit.SECONDS));
        encouragedMethodRecord.sendKeys(data);
        TestUtil.staticWait(1000);
        encouragedMethodRecord.sendKeys(Keys.ARROW_DOWN);
        encouragedMethodRecord.sendKeys(Keys.RETURN);

    }

    public void enterEstimatedMethodTextRecord(String fieldName, String data) throws InterruptedException {
        WebElement encouragedMethodRecord = prepareWebElementWithDynamicXpath(estimatedMethodTextDataRecord, fieldName);
        TestUtil.waitForElementClickable(driver, encouragedMethodRecord, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(1000);
        javaScriptExecutorClick(encouragedMethodRecord);
        encouragedMethodRecord.clear();
        encouragedMethodRecord.sendKeys(data);

    }

    public boolean getRequiredData(String methodName, String value) throws InterruptedException {
        TestUtil.staticWait(5000);
        List<WebElement> reqDataInRow = driver.findElements(By.xpath(String.format(generalInformationData, methodName)));

        for (WebElement ele : reqDataInRow) {
            if (ele.getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void verifyRequiredData(String methodName, String value) throws InterruptedException {

        Assert.assertTrue(getRequiredData(methodName, value), value + " is not displayed");
    }

    public void clickActionButtonForMethods(String methodName, String actionName) {
        WebElement methodLastData = driver.findElement(By.xpath(String.format(methodLastColumn, methodName)));
        scrollToElement(methodLastData);
        WebElement action = driver.findElement(By.xpath(String.format(actionButtonForMethods, methodName, actionName)));
        TestUtil.waitForElementClickable(driver, action, Duration.of(10, ChronoUnit.SECONDS));
        action.click();
    }

    public void editExactMethodDropdownRecord(String fieldName, String data) throws InterruptedException {
        WebElement encouragedMethodRecord = prepareWebElementWithDynamicXpath(exactMethodDropdownDataRecord, fieldName);
        TestUtil.waitForElementClickable(driver, encouragedMethodRecord, Duration.of(10, ChronoUnit.SECONDS));
        encouragedMethodRecord.click();
        driver.findElement(By.xpath(String.format(exactMethodRecordclearButton, fieldName))).click();
        encouragedMethodRecord.sendKeys(data);
        TestUtil.staticWait(1000);
        encouragedMethodRecord.sendKeys(Keys.ARROW_DOWN);
        encouragedMethodRecord.sendKeys(Keys.RETURN);

    }


    public void editEstimatedMethodDropdownRecord(String fieldName, String data) throws InterruptedException {

        WebElement encouragedMethodRecord = prepareWebElementWithDynamicXpath(estimatedMethodDropdownDataRecord, fieldName);
        TestUtil.waitForElementClickable(driver, encouragedMethodRecord, Duration.of(10, ChronoUnit.SECONDS));
        encouragedMethodRecord.click();
        driver.findElement(By.xpath(String.format(estimateMethodRecordclearButton, fieldName))).click();
        encouragedMethodRecord.sendKeys(data);
        TestUtil.staticWait(1000);
        encouragedMethodRecord.sendKeys(Keys.ARROW_DOWN);
        encouragedMethodRecord.sendKeys(Keys.RETURN);

    }

    public void selectAllRowsCheckbox() throws InterruptedException {
        TestUtil.staticWait(2000);
        scrollToElement(firstCoulmn);
        javaScriptExecutorClick(selectAllRows);
    }

    public void removeAndSelectYearFilter(String filter, String data) throws InterruptedException {
        TestUtil.staticWait(3000);
        removeSelectedYear.click();
        try {
            WebElement dropDownButton = prepareWebElementWithDynamicXpath(filterDropdownButton, filter);
            WebElement input = prepareWebElementWithDynamicXpath(filterInput, filter);
            TestUtil.staticWait(4000);
            dropDownButton.click();
            input.sendKeys(data);
            TestUtil.staticWait(2000);
            input.sendKeys(Keys.RETURN);
        } catch (Exception e) {
            WebElement dropDownButton1 = prepareWebElementWithDynamicXpath(filterDropdownButton, filter);
            WebElement input1 = prepareWebElementWithDynamicXpath(filterInput, filter);
            dropDownButton1.click();
            TestUtil.staticWait(3000);
            input1.sendKeys(data);
            TestUtil.staticWait(2000);
            input1.sendKeys(Keys.RETURN);
        }
    }

    public void addRequiredData(String field, String data) throws InterruptedException {
        TestUtil.staticWait(3000);
        WebElement input = prepareWebElementWithDynamicXpath(reqDataInput, field);
        TestUtil.waitForElementClickable(driver, input, Duration.of(10, ChronoUnit.SECONDS));
        input.clear();
        input.sendKeys(data);
        TestUtil.staticWait(1000);
        input.sendKeys(Keys.RETURN);
    }

    public void enterRequiredDataInInputTextField(String field, String data) {
        WebElement reqDataTextField = driver.findElement(By.xpath(String.format(requiredDataInputTextField, field)));
        reqDataTextField.clear();
        reqDataTextField.sendKeys(data);
    }

    public boolean getRequiredFarmLevelData(String row, String value) throws InterruptedException {
        TestUtil.staticWait(5000);
        List<WebElement> reqDataInRow = prepareListOfWebElementsWithDynamicXpath(addedRequiredData, row);
        for (WebElement ele : reqDataInRow) {
            if (ele.getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void verifyRequiredFarmLevelData(String row, String value) throws InterruptedException {

        Assert.assertTrue(getRequiredFarmLevelData(row, value), value + " is not displayed");
    }

    public void clickOnActionButtonForAddedRequiredData(String row, String actionName) {
        driver.findElement(By.xpath(String.format(actionOnRequiredData, row, actionName))).click();
    }

    public int getValueAccordingToRequiredData(String input) {
        switch (input) {
            case "Fuel type":
                return 1;
            case "Amount":
                return 2;
            case "Unit":
                return 3;
            default:
                return -1;
        }
    }

    public void editRequiredEncouragedData(String row, String dataType, String value) throws InterruptedException {
        String getDataTypeValue = String.valueOf(getValueAccordingToRequiredData(dataType));
        TestUtil.staticWait(2000);
        if (!driver.findElements(By.xpath(String.format(editRequiredEncouragedDataDropdownButton, row, getDataTypeValue))).isEmpty()) {
            driver.findElement(By.xpath(String.format(editRequiredEncouragedDataDropdownButton, row, getDataTypeValue))).click();
        }
        TestUtil.staticWait(2000);
        driver.findElement(By.xpath(String.format(editRequiredEncouragedDataInputField, row, getDataTypeValue))).clear();
        driver.findElement(By.xpath(String.format(editRequiredEncouragedDataInputField, row, getDataTypeValue))).sendKeys(Keys.DELETE);
        driver.findElement(By.xpath(String.format(editRequiredEncouragedDataInputField, row, getDataTypeValue))).sendKeys(value);
        TestUtil.staticWait(2000);
        if (!driver.findElements(By.xpath(String.format(dropdownValues, value))).isEmpty()) {
            driver.findElement(By.xpath(String.format(dropdownValues, value))).click();
        }
        driver.findElement(By.xpath(String.format(editRequiredEncouragedDataInputField, row, getDataTypeValue))).sendKeys(Keys.RETURN);

    }

    public void verifySuccessfulMessage(String message) {
        WebElement successfullMsg = prepareWebElementWithDynamicXpath(successMessage, message);
        TestUtil.waitForElementVisible(driver, successfullMsg, Duration.of(10, ChronoUnit.SECONDS));
        Assert.assertTrue(successfullMsg.isDisplayed());
    }


}
