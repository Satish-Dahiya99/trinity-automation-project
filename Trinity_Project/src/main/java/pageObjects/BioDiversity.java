package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.TestUtil;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BioDiversity extends BasePage{

    @FindBy(xpath = "//div[@class='step-one']//div[contains(@class,'-singleValue')]")
    WebElement yearFilter;

    @FindBy(xpath = "//*[contains(@class,'MuiCircularProgress-root MuiCircularProgress-indeterminate MuiCircularProgress-colorPrimary css-oooamk')]")
    WebElement loader;

    @FindBy(xpath = "//*[@id='modal-description']//following-sibling::div//input")
    WebElement enterReportName;

    @FindBy(xpath = "//*[@id='modal-description']/../..//button[text()='Create report']")
    WebElement createReportButton;

    @FindBy(xpath = "(//div[@role='rowgroup'])[2]/div/div[2]/div")
    List<WebElement> reportName;


    String biodiversityMenu = "//*[@id='BIODIVERSITY']//a[contains(text(),'"+dynamicText+"')]";
    String biodiversityScore = "(//*[text()='"+dynamicText+"'])[1]";
    String basicButton = "//div[text()='"+dynamicText+"']/../../div[8]//div[@id='basic-button']";
    String deleteReportButton = "//*[@aria-labelledby]//li[text()='"+dynamicText+"']";
    String menuButton = "//span[text()='"+dynamicText+"']";





    Logger log = BaseLib.getLog(this.getClass().getName());
    public BioDiversity(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnBioDiversityMenu(String menu){
        WebElement ele = prepareWebElementWithDynamicXpath(biodiversityMenu, menu);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        ele.click();
    }

    public void verifyYearFilterData(String yearData){
        TestUtil.waitForElementClickable(driver, yearFilter, Duration.of(10, ChronoUnit.SECONDS));
        Assert.assertTrue(yearFilter.getText().equalsIgnoreCase(yearData));

    }

    public void verifyBioDiversityScore(String score){
        TestUtil.waitForElementToDisappear(driver, loader, Duration.of(20, ChronoUnit.SECONDS));
        Assert.assertTrue(prepareWebElementWithDynamicXpath(biodiversityScore, score).isDisplayed());
    }

    public void enterReportNameAndCreateReport(String reportName){
        enterReportName.sendKeys(reportName);
        createReportButton.click();
        TestUtil.waitForElementToDisappear(driver, loader, Duration.of(120, ChronoUnit.SECONDS));


    }

    public boolean reportNameOnReportPage(String report) throws InterruptedException {
        TestUtil.waitForElementToDisappear(driver, loader, Duration.of(60, ChronoUnit.SECONDS));
        for (WebElement ele : reportName){
            if (ele.getText().equalsIgnoreCase(report)){
                return true;
            }
        }
        return false;
    }

    public void verifyReportNameOnReportPage(String report) throws InterruptedException {
        Assert.assertTrue(reportNameOnReportPage(report));
    }

    public void clickDeleteTheReportButton(String buttonName){
        WebElement ele = prepareWebElementWithDynamicXpath(deleteReportButton, buttonName);
        ele.click();
    }

    public void deleteTheCreatedReport(String reportName){
        WebElement ele = prepareWebElementWithDynamicXpath(basicButton, reportName);
        ele.click();
        clickDeleteTheReportButton("Delete");
        TestUtil.waitForElementToDisappear(driver, loader, Duration.of(15, ChronoUnit.SECONDS));
    }

    public void verifyReportNameOnReportPageNotDisplayed(String report) throws InterruptedException {
        Assert.assertFalse(reportNameOnReportPage(report));
    }

    public void clickButtonMenu(String buttonName){
        WebElement ele = prepareWebElementWithDynamicXpath(menuButton, buttonName);
        ele.click();
    }









}
