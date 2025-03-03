package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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

public class LandUses extends BasePage {

    String landUseYear = "//*[@class='nav-item']/a[contains(@id,'" + dynamicText + "')]";
    String filterInput = "//div[text()='" + dynamicText + "']/..//input";
    String filterButton = "//div[text()='" + dynamicText + "']/..//div[@data-value]";
    String encouragedDataInput = "//*[text()='" + dynamicText + "']/..//input";
    String addedRequiredData = "(//div[contains(@class,'col-md-')]/div[contains(@class,'border-bottom')])[" + dynamicText + "]/div";
    String actionOnRequiredData = "(//div[contains(@class,'col-md-')]/div[contains(@class,'border-bottom')])[%s]//*[contains(@data-testid,'%s')]";
    String selectAllButton = "//*[text()='" + dynamicText + "']/../..//button";
    String yearForSelectedField = "//div[contains(@class,' accordion-item')]//div[text()='%s']";
    String yearCheckBox = "//div[contains(@class,'-new form-check')]/label[text()='%s']";
    String footerSaveOrCancel = "//div[contains(@class,'modal-footer')]//button[text()='" + dynamicText + "']";

    @FindBy(xpath = "//span[text()='Actions']")
    WebElement actionText;

    Logger log = BaseLib.getLog(this.getClass().getName());

    public LandUses(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickLandUseYear(String year) {
        WebElement ele = prepareWebElementWithDynamicXpath(landUseYear, year);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        ele.click();
    }

    public void selectFilterForLandUselData(String filter, String data) throws InterruptedException {
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

    public void selectRequiredDataToAddLandUse(String field, String data) throws InterruptedException {
        TestUtil.staticWait(5000);
        WebElement input = prepareWebElementWithDynamicXpath(encouragedDataInput, field);
        TestUtil.waitForElementClickable(driver, input, Duration.of(10, ChronoUnit.SECONDS));
        input.sendKeys(data);
        TestUtil.staticWait(1000);
        input.sendKeys(Keys.RETURN);
    }

    public boolean getRequiredLandUsesData(String row, String value) throws InterruptedException {
        TestUtil.staticWait(5000);
        List<WebElement> reqDataInRow = prepareListOfWebElementsWithDynamicXpath(addedRequiredData, row);
        for (WebElement ele : reqDataInRow) {
            if (ele.getText().contains(value)) {
                return true;
            }
        }
        return false;
    }

    public void verifyRequiredLandUsesData(String row, String value) throws InterruptedException {

        Assert.assertTrue(getRequiredLandUsesData(row, value), value + " is not displayed");
    }

    public void clickOnActionButtonForAddedRequiredData(String row, String actionName) {
        actionText.click();
        driver.findElement(By.xpath(String.format(actionOnRequiredData, row, actionName))).click();
    }

    public void selectAllButtonOnReplicateRecordsPage(String buttonName) throws InterruptedException {
        WebElement ele = prepareWebElementWithDynamicXpath(selectAllButton, buttonName);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(5000);
        ele.click();

    }

    public void selectFilterOnReplicateRecordPage(String filter, String data) throws InterruptedException {
        WebElement input = prepareWebElementWithDynamicXpath(filterInput, filter);
        try {
            TestUtil.staticWait(8000);
            input.sendKeys(data);
        } catch (Exception e) {
            TestUtil.staticWait(2000);
            javaScriptToEnterText(input, data);
        }
        input.sendKeys(Keys.RETURN);
    }

    public void expandFieldOnReplicatePage(String fieldName) {
        String element = String.format(yearForSelectedField, fieldName);
        driver.findElement(By.xpath(element)).click();
    }

    public void selectYearForSelectedFieldOnReplicatePage(String year) {
        driver.findElement(By.xpath(String.format(yearCheckBox, year))).click();
    }

    public void saveOrCancleButton(String button) {
        WebElement buttonName = prepareWebElementWithDynamicXpath(footerSaveOrCancel, button);
        javaScriptExecutorClick(buttonName);
    }

}
