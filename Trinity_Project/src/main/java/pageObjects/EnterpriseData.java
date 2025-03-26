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

public class EnterpriseData extends BasePage{

    @FindBy(xpath = "//*[@id='SANDYSETUP']//a[contains(text(),'Enterprise data')]")
    WebElement enterpriseData;

    @FindBy(xpath = "(//div[@id='commonTable']//button)[1]")
    WebElement addField;

    @FindBy(xpath = "(//div[@id='commonTable']//button)[2]")
    WebElement editMultiple;

    @FindBy(xpath = "//*[contains(@class,'MuiCircularProgress-root MuiCircularProgress-indeterminate MuiCircularProgress-colorPrimary css-oooamk')]")
    WebElement loader;



    String manageDataButton = "//div[text()='"+dynamicText+"']/..//button";
    String fieldName = "//*[contains(text(),'"+dynamicText+"')]/..//input";
    String fieldData = "//*[text()='"+dynamicText+"']/../div[text()]";
    String button = "//button[text()='"+dynamicText+"']";




    Logger log = BaseLib.getLog(this.getClass().getName());

    public EnterpriseData(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToEnterpriseDataPage(){
        enterpriseData.click();
    }

    public void clickManageData(String field){
        WebElement ele = prepareWebElementWithDynamicXpath(manageDataButton, field);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        ele.click();
    }

    public void clickAddField() throws InterruptedException {
        TestUtil.waitForElementClickable(driver, addField, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(4000);
        addField.click();
    }

    public void addRequiredData(String field, String data) throws InterruptedException {
        WebElement input = prepareWebElementWithDynamicXpath(fieldName, field);
        TestUtil.waitForElementClickable(driver, input, Duration.of(10, ChronoUnit.SECONDS));
        input.clear();
        input.sendKeys(data);
        input.sendKeys(Keys.RETURN);
        TestUtil.staticWait(1000);
    }

    public boolean verifyFieldRequiredData(String fieldName, String data){
        List<WebElement> ele = prepareListOfWebElementsWithDynamicXpath(fieldData, fieldName);
        TestUtil.waitForElementsVisible(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        for (int i=0; i< ele.size();i++){
            if (ele.get(i).getText().equalsIgnoreCase(data)){
                return true;
            }
        }
        return false;
    }

    public void verifydataOfField(String fieldName, String data){
        Assert.assertTrue(verifyFieldRequiredData(fieldName, data));
    }

    public void editTheField(String fieldName) throws InterruptedException {
        TestUtil.staticWait(6000);
        driver.findElement(By.xpath("//*[@data-testid='EditOutlinedIcon']")).click();

    }

    public void deleteTheField(String fieldName) throws InterruptedException {
        try{
            TestUtil.staticWait(8000);
            driver.findElement(By.xpath("//*[@data-testid='DeleteOutlineIcon']")).click();
        } catch (Exception e) {
            TestUtil.waitForElementToDisappear(driver, loader, Duration.of(20, ChronoUnit.SECONDS));
            TestUtil.staticWait(4000);
            WebElement ele = driver.findElement(By.xpath("//*[@data-testid='DeleteOutlineIcon']"));
            ele.click();
        }


    }

    public void clickButton(String buttonName) throws InterruptedException {
        WebElement ele = prepareWebElementWithDynamicXpath(button, buttonName);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(2000);
        try{
            javaScriptExecutorClick(ele);
        } catch (Exception e) {
            TestUtil.staticWait(2000);
            WebElement ele1 = prepareWebElementWithDynamicXpath(button, buttonName);
            ele1.click();
        }
    }
}
