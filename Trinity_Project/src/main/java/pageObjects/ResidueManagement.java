package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.TestUtil;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ResidueManagement extends BasePage {


    @FindBy(xpath = "//*[@data-testid='AddOutlinedIcon']")
    WebElement addAnotherRecordButton;

    @FindBy(xpath = "//div[contains(@class,'MuiDataGrid-virtualScroller')]//div[text()='No rows']")
    WebElement noRowText;

    @FindBy(xpath = "(//div[contains(@data-field,'__check__')]//span//span)[1]")
    WebElement selectAllCheckBox;

    String filterInput = "//div[text()='" + dynamicText + "']/..//input";
    String filterDropdownButton = "// div[text()='" + dynamicText + "']/../following-sibling::div";
    String cropReqDataInput = "//*[text()='" + dynamicText + "']/..//input";
    String addRecordInputDropdownField = "//p[text()='%s']/../../following-sibling::div//label[text()='" + dynamicText + "']/..// input";
    String addRecordAddPercentageTextField = "(//p[text()='" + dynamicText + "']/../../following-sibling::div//input)[3]";
    String residualDataRow = "//div[contains(@class,'MuiDataGrid-virtualScrollerRenderZone')]/div[" + dynamicText + "]//div[@title]";
    String actionButtonForDataInRow = "//div[contains(@class,'MuiDataGrid-virtualScrollerRenderZone')]/div[%s]//*[contains(@data-testid,'" + dynamicText + "')]";


    Logger log = BaseLib.getLog(this.getClass().getName());

    public ResidueManagement(WebDriver driver) {
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

    public void selectRequiredDataToAddRecord(String record, String field, String data) throws InterruptedException {
        TestUtil.staticWait(4000);
        String selectRecordDropdownInputField = String.format(addRecordInputDropdownField, record);
        WebElement dropDownInput = prepareWebElementWithDynamicXpath(selectRecordDropdownInputField, field);
        TestUtil.waitForElementClickable(driver, dropDownInput, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(1000);
        dropDownInput.click();
        TestUtil.staticWait(1000);
        dropDownInput.sendKeys(Keys.BACK_SPACE);
        TestUtil.staticWait(1000);
        dropDownInput.sendKeys(data);
        TestUtil.staticWait(1000);
        dropDownInput.sendKeys(Keys.ARROW_DOWN);
        dropDownInput.sendKeys(Keys.RETURN);
    }

    public void addPercentageForRecord(String record, String data) {
        WebElement ele = prepareWebElementWithDynamicXpath(addRecordAddPercentageTextField, record);
        ele.clear();
        ele.sendKeys(data);
    }

    public boolean residualDataVerifivation(String row, String residualData) throws InterruptedException {
        int inputRow = 0;

        inputRow = Integer.parseInt(row) + 1;
        String actualRow = String.valueOf(inputRow);
        TestUtil.staticWait(4000);
        List<WebElement> rowData = prepareListOfWebElementsWithDynamicXpath(residualDataRow, actualRow);
        for (WebElement ele : rowData) {
            if (ele.getText().contains(residualData)) {
                return true;
            }
        }
        return false;
    }

    public void verifyResidualData(String row, String residualData) throws InterruptedException {
        Assert.assertTrue(residualDataVerifivation(row, residualData), residualData + " is not displayed");
    }

    public void clickAddAnotherRecordButton() throws InterruptedException {
        TestUtil.waitForElementClickable(driver, addAnotherRecordButton, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(4000);
        addAnotherRecordButton.click();

    }

    public void clickActionButtonForResidualData(String actionButton, String row) {
        int inputRow = Integer.parseInt(row) + 1;
        String actualRow = String.valueOf(inputRow);
        String rowSelection = String.format(actionButtonForDataInRow, actualRow);
        WebElement action = prepareWebElementWithDynamicXpath(rowSelection, actionButton);
        TestUtil.waitForElementClickable(driver, action, Duration.of(10, ChronoUnit.SECONDS));
        action.click();
    }

    public void verifyNoRowText() {
        Assert.assertTrue(noRowText.isDisplayed(), noRowText.getText() + " is not displayed");
    }

    public void checkTheSelectAllRecordCheckBox(){

        TestUtil.waitForElementClickable(driver, selectAllCheckBox, Duration.of(10, ChronoUnit.SECONDS));
        javaScriptExecutorClick(selectAllCheckBox);
    }


}
