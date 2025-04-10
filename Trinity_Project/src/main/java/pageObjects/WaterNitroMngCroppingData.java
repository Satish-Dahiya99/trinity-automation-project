package pageObjects;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
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

public class WaterNitroMngCroppingData extends BasePage {

    @FindBy(xpath = "//input[@aria-label='Select all rows']")
    WebElement selectAllCheckbox;

    @FindBy(xpath = "//div[contains(@class,'left-table')]//input[@aria-label='Select all rows']")
    WebElement dataPointCheckbox;


    String filterInput = "//div[text()='" + dynamicText + "']/..//input";
    String filterButton = "//div[text()='" + dynamicText + "']/..//div[@data-value]";
    String encouragedDataInput = "//*[text()='" + dynamicText + "']/..//input";
    String addedRequiredData = "(//div[contains(@data-field,'columns_group')]//parent::div[contains(@class,'MuiDataGrid-row')])[" + dynamicText + "]/div";
    String actionItem = "(//div[contains(@class,'MuiDataGrid-pinnedColumns--right')]/div)[" + dynamicText + "]//*[contains(@data-testid,'%s')]";
    String filterDropdownIndicator = "//div[@class='filters']//div[text()='" + dynamicText + "']/../../../following-sibling::div/div[contains(@class,'select__dropdown-indicator')]";
    String chooseDestinationFieldsCheckbox = "// p[text()='" + dynamicText + "']/..//*[@data-testid='CheckBoxOutlineBlankIcon']/preceding-sibling::input";
    String removeFilter = "//div[text()='" + dynamicText + "']/..//div[@aria-label='Remove Test_Field']";
    String dropDownIntems = "//div[contains(@class,'select__menu')]//*[text()='" + dynamicText + "']";
    String successMessage = "//span[text()='"+dynamicText+"']";


    Logger log = BaseLib.getLog(this.getClass().getName());

    public WaterNitroMngCroppingData(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectFilterForCroppingData(String filter, String data) throws InterruptedException {
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

    public void selectRequiredDataForCroppingData(String field, String data) throws InterruptedException {
        TestUtil.staticWait(5000);
        WebElement input = prepareWebElementWithDynamicXpath(encouragedDataInput, field);
        TestUtil.waitForElementClickable(driver, input, Duration.of(10, ChronoUnit.SECONDS));
        input.click();
        input.sendKeys(Keys.BACK_SPACE);
        input.sendKeys(data);
        TestUtil.staticWait(1000);
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.RETURN);
    }

    public void setDate(String dateType, String year) {
        if (dateType.equalsIgnoreCase("Planting date")) {
            WebElement input = prepareWebElementWithDynamicXpath(encouragedDataInput, dateType);
            if (Integer.parseInt(year) == LocalDate.now().getYear()) {
                LocalDate priorDate = LocalDate.now().minusDays(7);
                input.click();
                input.sendKeys(priorDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            } else {
                LocalDate lastDayOfYear = LocalDate.of(Integer.parseInt(year), 12, 31).minusDays(7);
                input.click();
                input.sendKeys(lastDayOfYear.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        } else if (dateType.equalsIgnoreCase("Harvest date")) {
            WebElement input = prepareWebElementWithDynamicXpath(encouragedDataInput, dateType);
            if (Integer.parseInt(year) == LocalDate.now().getYear()) {
                LocalDate priorDate = LocalDate.now();
                input.click();
                input.sendKeys(priorDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            } else {
                LocalDate lastDayOfYear = LocalDate.of(Integer.parseInt(year), 12, 31);
                input.click();
                input.sendKeys(lastDayOfYear.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        }
    }

    public boolean getRequiredCroppingData(String row, String value) throws InterruptedException {
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

    public void verifyRequiredCroppingData(String row, String value) throws InterruptedException {

        Assert.assertTrue(getRequiredCroppingData(row, value), value + " is not displayed");
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

    public void clickSelectAllCheckBox() {
        scrollFromElementFromGivenAmount(selectAllCheckbox);
        selectAllCheckbox.click();
    }

    public void selectDataPointCheckbox() {
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

    public void setRemoveFilter(String filterName) throws InterruptedException {
        TestUtil.staticWait(3000);
        WebElement removeFil = prepareWebElementWithDynamicXpath(removeFilter, filterName);
        TestUtil.waitForElementClickable(driver, removeFil, Duration.of(15, ChronoUnit.SECONDS));
        javaScriptExecutorClick(removeFil);
    }

    public void clickFilter(String filterName) {
        WebElement button = prepareWebElementWithDynamicXpath(filterButton, filterName);
        button.click();

    }

    public void selectDropDownFilterValue(DataTable dataTable) throws InterruptedException {
        List<String> data = dataTable.asList();
        for (int i = 1; i < data.size(); i++) {
            prepareWebElementWithDynamicXpath(dropDownIntems, data.get(i)).click();
        }
    }

    public void verifySuccessMessage(String message) {

        Assert.assertTrue(prepareWebElementWithDynamicXpath(successMessage, message).isDisplayed());
    }

}
