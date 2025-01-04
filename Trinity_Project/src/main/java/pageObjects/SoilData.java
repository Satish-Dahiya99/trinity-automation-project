package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sun.security.mscapi.CPublicKey;
import utilities.TestUtil;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class SoilData extends BasePage {


    @FindBy(xpath = "//div[text()='No records are present']")
    WebElement noRecordsPresent;

    @FindBy(xpath = "//*[text()='Soil type']/..//div[@id='soilType']")
    WebElement soilTypeDropDownButton;

    String filterInput = "//div[text()='" + dynamicText + "']/..//input";
    String filterDropdownButton = "// div[text()='" + dynamicText + "']/../following-sibling::div";
    String removeYearFilterButton = "//div[@aria-label='Remove " + dynamicText + "']";
    String soilReqDataInput = "//*[text()='" + dynamicText + "']/..//input";
    String selectDropdownButton = "//*[text()='" + dynamicText + "']/..//div[contains(@class,'-indicatorContainer')]";
    String dropdownValues = "//*[text()='" + dynamicText + "']";
    String addedRequiredData = "(//div[contains(@class,'selectall-td selectcolumn row')])[" + dynamicText + "]/div";
    String action = "(//div[contains(@class,'selectall-td selectcolumn row')])[%s]//*[contains(@data-testid,'"+dynamicText+"')]";
    String buttonName = "//div[@class='modal-footer']//*[text()='"+dynamicText+"']";

    Logger log = BaseLib.getLog(this.getClass().getName());

    public SoilData(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectFilter(String filter, String data) throws InterruptedException {

        try {
            WebElement dropDownButton = prepareWebElementWithDynamicXpath(filterDropdownButton, filter);
            WebElement input = prepareWebElementWithDynamicXpath(filterInput, filter);
            TestUtil.staticWait(4000);
            dropDownButton.click();
            input.sendKeys(data);
            input.sendKeys(Keys.RETURN);
        } catch (Exception e) {
            WebElement dropDownButton1 = prepareWebElementWithDynamicXpath(filterDropdownButton, filter);
            WebElement input1 = prepareWebElementWithDynamicXpath(filterInput, filter);
            dropDownButton1.click();
            TestUtil.staticWait(2000);
            input1.sendKeys(data);
            input1.sendKeys(Keys.RETURN);
        }


    }

    public void removeYearFilter(String yearCloseButton) throws InterruptedException {
        TestUtil.staticWait(3000);
        WebElement removeYear = prepareWebElementWithDynamicXpath(removeYearFilterButton, yearCloseButton);
        removeYear.click();
    }

    public void selectRequiredDataToAddCrop(String field, String data) throws InterruptedException {
        TestUtil.staticWait(3000);
        WebElement input = prepareWebElementWithDynamicXpath(soilReqDataInput, field);
        TestUtil.waitForElementClickable(driver, input, Duration.of(10, ChronoUnit.SECONDS));
        input.clear();
        input.sendKeys(data);
        TestUtil.staticWait(1000);
        input.sendKeys(Keys.RETURN);
    }

    public void selectValuesAfterClickingDropdownValues(String fieldName, String value) throws InterruptedException {
        try {
            TestUtil.staticWait(3000);
            prepareWebElementWithDynamicXpath(selectDropdownButton, fieldName).click();
            TestUtil.staticWait(1000);
            prepareWebElementWithDynamicXpath(dropdownValues, value).click();
        } catch (Exception e) {
            TestUtil.staticWait(2000);
            prepareWebElementWithDynamicXpath(selectDropdownButton, fieldName).click();
            prepareWebElementWithDynamicXpath(dropdownValues, value).click();
        }


    }

    public void setDate(String dateField, String priorDays) {

        WebElement input = prepareWebElementWithDynamicXpath(soilReqDataInput, dateField);
        input.sendKeys(setPastDate(priorDays));
    }

    public boolean getRequiredData(String row, String value) throws InterruptedException {
        TestUtil.staticWait(5000);
        List<WebElement> reqDataInRow = prepareListOfWebElementsWithDynamicXpath(addedRequiredData, row);

        for (WebElement ele : reqDataInRow) {
            if (ele.getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void verifyRequiredData(String row, String value) throws InterruptedException {

        Assert.assertTrue(getRequiredData(row, value), value+" is not displayed");
    }

    public void clickActionButtonForAddedRequiredData(String actionName, String row){
        String getRow = String.format(action, row);
        prepareWebElementWithDynamicXpath(getRow, actionName).click();

    }

    public void verifyTextAfterDeletingAllData(){
        TestUtil.waitForElementVisible(driver, noRecordsPresent, Duration.of(10, ChronoUnit.SECONDS));
        Assert.assertEquals(noRecordsPresent.getText(), "No records are present");
    }

    public void selectValueInSoilTypeDropDown(String value) throws InterruptedException {
        TestUtil.staticWait(4000);
        soilTypeDropDownButton.click();
        TestUtil.staticWait(1000);
        prepareWebElementWithDynamicXpath(dropdownValues, value).click();

    }

    public void clickButton(String button){
        TestUtil.waitForElementClickable(driver, prepareWebElementWithDynamicXpath(buttonName, button), Duration.of(10, ChronoUnit.SECONDS));
        prepareWebElementWithDynamicXpath(buttonName, button).click();

    }




}
