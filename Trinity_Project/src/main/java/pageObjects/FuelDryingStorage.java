package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sun.security.mscapi.CPublicKey;
import utilities.TestUtil;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class FuelDryingStorage extends BasePage {


    String filterInput = "//div[text()='" + dynamicText + "']/..//input";
    String filterDropdownButton = "// div[text()='" + dynamicText + "']/../following-sibling::div";
    String onFarmCheckBox = "//label[text()='" + dynamicText + "']/../input";
    String reqDataInput = "//*[text()='" + dynamicText + "']/..//input";
    String addedRequiredData = "(//div[contains(@class,'col-md')]//div[contains(@class,' border-bottom')])[%s]/div";
    String actionButton = "//div[contains(@class,'col-md')]//div[contains(@class,' border-bottom')]//*[contains(@data-testid,'" + dynamicText + "')]";


    Logger log = BaseLib.getLog(this.getClass().getName());

    public FuelDryingStorage(WebDriver driver) {
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

    public void clickOnFarmTheCheckbox(String checkBoxName) {
        prepareWebElementWithDynamicXpath(onFarmCheckBox, checkBoxName).click();

    }

    public void selectRequiredData(String field, String data) throws InterruptedException {
        TestUtil.staticWait(3000);
        WebElement input = prepareWebElementWithDynamicXpath(reqDataInput, field);
        TestUtil.waitForElementClickable(driver, input, Duration.of(10, ChronoUnit.SECONDS));
        input.clear();
        input.sendKeys(data);
        TestUtil.staticWait(1000);
        input.sendKeys(Keys.RETURN);
    }

    public boolean getRequiredData(String row, String value) throws InterruptedException {
        TestUtil.staticWait(5000);
        List<WebElement> reqDataInRow = driver.findElements(By.xpath(String.format(addedRequiredData, row)));

        for (WebElement ele : reqDataInRow) {
            if (ele.getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void verifyRequiredData(String row, String value) throws InterruptedException {

        Assert.assertTrue(getRequiredData(row, value), value + " is not displayed");
    }

    public void clickActionButton(String actionName) {
        prepareWebElementWithDynamicXpath(actionButton, actionName).click();

    }


}
