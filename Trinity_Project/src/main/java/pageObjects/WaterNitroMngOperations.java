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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class WaterNitroMngOperations extends BasePage {


    @FindBy(xpath = "//button[@class='btn mui-btn-color']/..//*[text()='Add product']")
    WebElement addProductButton;

    @FindBy(xpath = "//input[@id='productName']")
    WebElement productNameInput;

    @FindBy(xpath = "//div[contains(@class,'left-table')]//input[@aria-label='Select all rows']")
    WebElement dataPointCheckbox;

    @FindBy(xpath = "//div[@class='message']//p")
    WebElement warningMessage;

    String filterInput = "//div[text()='" + dynamicText + "']/..//input";
    String filterButton = "//div[text()='" + dynamicText + "']/..//div[@data-value]";
    String requiredDataInput = "//*[text()='" + dynamicText + "']/..//input";
    String button = "//button[text()='" + dynamicText + "']";
    String addedRequiredData = "(//div[contains(@data-field,'columns_group')]//parent::div[contains(@class,'MuiDataGrid-row')])[" + dynamicText + "]/div";
    String actionItem = "(//div[contains(@class,'MuiDataGrid-pinnedColumns--right')]/div)[" + dynamicText + "]//*[contains(@data-testid,'%s')]";
    String filterDropdownIndicator = "//div[@class='filters']//div[text()='"+dynamicText+"']/../../../..//div[contains(@class,'select__dropdown-indicator')]";
    String chooseDestinationFieldsCheckbox = "// p[text()='" + dynamicText + "']/..//*[@data-testid='CheckBoxOutlineBlankIcon']/preceding-sibling::input";
    String recordCategory = "//div[@class='flex-container-filter']/..//p[text()='"+dynamicText+"']";
    String warningType = "//div[@class='chips-message-container']//button[text()='"+dynamicText+"']";

    Logger log = BaseLib.getLog(this.getClass().getName());

    public WaterNitroMngOperations(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectFilterForOperations(String filter, String data) throws InterruptedException {
        WebElement input = prepareWebElementWithDynamicXpath(filterInput, filter);
        TestUtil.waitForElementClickable(driver, input, Duration.of(15, ChronoUnit.SECONDS));
        TestUtil.staticWait(4000);
        WebElement button = prepareWebElementWithDynamicXpath(filterButton, filter);
        javaScriptExecutorClick(button);
        TestUtil.staticWait(2000);
        WebElement input1 = prepareWebElementWithDynamicXpath(filterInput, filter);
        input1.sendKeys(data);
        TestUtil.staticWait(2000);
        input1.sendKeys(Keys.RETURN);

    }

    public void selectRequiredDataForOperations(String field, String data) throws InterruptedException {
        TestUtil.staticWait(5000);
        WebElement input = prepareWebElementWithDynamicXpath(requiredDataInput, field);
        TestUtil.waitForElementClickable(driver, input, Duration.of(10, ChronoUnit.SECONDS));
        input.click();
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(data);
        TestUtil.staticWait(1000);
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.RETURN);
    }

    public void addProduct(String productName) {
        addProductButton.click();
        productNameInput.sendKeys(productName);
        prepareWebElementWithDynamicXpath(button, "Ok").click();

    }

    public void setDate(String dateType, String year) throws InterruptedException {

        WebElement input = prepareWebElementWithDynamicXpath(requiredDataInput, dateType);
        LocalDate lastDayOfYear = LocalDate.of(Integer.parseInt(year), 12, 31);
        input.click();
        input.sendKeys(lastDayOfYear.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        TestUtil.staticWait(1000);
    }

    public boolean getRequiredOperationsData(String row, String value) throws InterruptedException {
        TestUtil.staticWait(5000);
        int rowCount = Integer.parseInt(row) + 1;
        String rowNum = String.valueOf(rowCount);
        List<WebElement> reqDataInRow = prepareListOfWebElementsWithDynamicXpath(addedRequiredData, rowNum);
        for (WebElement ele : reqDataInRow) {
            if (ele.getText().contains(value)) {
                return true;
            }
        }
        return false;
    }

    public void verifyRequiredOperationsData(String row, String value) throws InterruptedException {

        Assert.assertTrue(getRequiredOperationsData(row, value), value + " is not displayed");
    }

    public void clickActionItem(String row, String actionName) {
        int rowCount = Integer.parseInt(row) + 1;
        String rowNum = String.valueOf(rowCount);
        String actionRow = String.format(actionItem, actionName);
        WebElement element = prepareWebElementWithDynamicXpath(actionRow, rowNum);
        TestUtil.waitForElementClickable(driver, element, Duration.of(15, ChronoUnit.SECONDS));
        scrollFromElementFromGivenAmount(element);
        element.click();

    }

    public void checkDataPointCheckbox() {
        dataPointCheckbox.click();
    }

    public void chooseDestinationFieldsFilters(String fieldName, String value) throws InterruptedException {
        WebElement input = prepareWebElementWithDynamicXpath(filterInput, fieldName);
        TestUtil.waitForElementClickable(driver, input, Duration.of(15, ChronoUnit.SECONDS));
        TestUtil.staticWait(4000);
        WebElement button = prepareWebElementWithDynamicXpath(filterButton, fieldName);
        javaScriptExecutorClick(button);
        TestUtil.staticWait(2000);
        WebElement input1 = prepareWebElementWithDynamicXpath(filterInput, fieldName);
        input1.sendKeys(value);
        TestUtil.staticWait(2000);
        input1.sendKeys(Keys.RETURN);
        prepareWebElementWithDynamicXpath(filterDropdownIndicator, value).click();
    }

    public void selectDestinationFieldCheckbox(String checkboxName) throws InterruptedException {
        WebElement checkbox = prepareWebElementWithDynamicXpath(chooseDestinationFieldsCheckbox, checkboxName);
        TestUtil.staticWait(2000);
        javaScriptExecutorClick(checkbox);
    }

    public void clickCategoryToSeeRecordsByStatus(String categoryName) {
        prepareWebElementWithDynamicXpath(recordCategory, categoryName).click();
    }

    public void clickOnWarningType(String warningName) {
        prepareWebElementWithDynamicXpath(warningType, warningName).click();
    }

    public void assertWarningMessage(String message) {
        Assert.assertEquals(message, warningMessage.getText(), "Expected warning message is not displayed");
    }

}
