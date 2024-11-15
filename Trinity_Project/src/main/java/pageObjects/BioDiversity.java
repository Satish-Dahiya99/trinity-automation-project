package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.TestUtil;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BioDiversity extends BasePage{

    @FindBy(xpath = "//div[@class='step-one']//div[contains(@class,'-singleValue')]")
    WebElement yearFilter;

    @FindBy(xpath = "//*[contains(@class,'MuiCircularProgress-root MuiCircularProgress-indeterminate MuiCircularProgress-colorPrimary css-oooamk')]")
    WebElement loader;

    @FindBy(xpath = "//*[@id='modal-description']//following-sibling::div//input")
    WebElement enterReportName;

    @FindBy(xpath = "//*[@id='modal-description']/../..//button[text()='Create report']")
    WebElement createReportButton;

    @FindBy(xpath = "(//div[@role='rowgroup'])[2]/div/div[2]")
    List<WebElement> reportName;

    @FindBy(xpath = "//div[contains(@class,'select__menu-list select__')]//div[text()]")
    List<WebElement> historicDropDownValues;

    @FindBy(xpath = "//div[@class='header']//div[contains(@class,'select__dropdown-indicator')]")
    WebElement historicDropdown;

    @FindBy(xpath = "//div[@id='heading-container']/following-sibling::div[2]//div[@class='extra_selected_items']")
    List<WebElement> biodiversityFilters;

    @FindBy(xpath = "//div[@class='detailed-header']/following-sibling::div//div[@class='extra_selected_items']")
    List<WebElement> performanceAnalysisFilters;

    @FindBy(xpath = "//div[@class='content']//button")
    WebElement improveBiodiversityScore;

    @FindBy(xpath = "((//button[contains(@class,'MuiButtonBase-root')])[17]/../../..//p)[1]")
    WebElement performanceFarmName;

    @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root')])[17]/../..//p")
    WebElement performanceFieldmName;

    @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root')])[17]")
    WebElement rocketButton;

    @FindBy(xpath = "//div[@id='heading-container']/following-sibling::div[2]//div[contains(@class,'select__multi-value__l')]")
    WebElement recommendationFramFilter;

    @FindBy(xpath = "(//div[@id='heading-container']/following-sibling::div[2]//div[@class='extra_selected_items'])[2]")
    WebElement recommendationFieldFilter;

    @FindBy(xpath = "//div[@class='banner-container-bottom']//p")
    WebElement bannerText;

    @FindBy(xpath = "//input[@placeholder='Search reports']")
    WebElement searchReport;

    @FindBy(xpath = "//div[@class='frame']//*[@class='title']")
    WebElement reportTitle;

    @FindBy(xpath = "//div[@class='frame']//p[text()='Created on']/following-sibling::p")
    WebElement reportCreatedDate;

    @FindBy(xpath = "//*[@data-testid='ArrowBackIcon']")
    WebElement reportBackButton;

    String biodiversityMenu = "//*[@id='BIODIVERSITY']//a[contains(text(),'"+dynamicText+"')]";
    String biodiversityScore = "(//*[text()='"+dynamicText+"'])[1]";
    String basicButton = "//p[text()='"+dynamicText+"']/../../div[8]//div[@id='basic-button']";
    String deleteReportButton = "//*[@aria-labelledby]//li[text()='"+dynamicText+"']";
    String menuButton = "//span[text()='"+dynamicText+"']";
    String managementPractices = "//div[contains(@class,'MuiAccordionSummary-content')]//p[text()='"+dynamicText+"']";
    String fieldNameCheckBox = "(//p[text()='"+dynamicText+"']/../../../../..//input)[1]";
    String bannerButton = "//div[@class='banner-container-bottom']//button[text()='"+dynamicText+"']";
    String viewReportButton = "//p[text()='"+dynamicText+"']/../../div[8]//a";

    static ArrayList<String> biodiversity_Filters = new ArrayList<>();
    private static String getPerformanceFarmName;
    private static String getPerformanceFieldName;


    Logger log = BaseLib.getLog(this.getClass().getName());
    public BioDiversity(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnBioDiversityMenu(String menu){
        WebElement ele = prepareWebElementWithDynamicXpath(biodiversityMenu, menu);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        ele.click();
        TestUtil.waitForElementToDisappear(driver, loader, Duration.of(15, ChronoUnit.SECONDS));
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

    public boolean verifyHistoricperformancecomparisonDropdown(String values){
          for (int i =0; i< historicDropDownValues.size(); i++){
              System.out.println(historicDropDownValues.get(i).getText()+"**********");
              if (historicDropDownValues.get(i).getText().equalsIgnoreCase(values)){
                  return true;
              }
          }
        return false;
    }

    public void verifyHistoricperformancecomparisonDropdownValues(String values){
        Assert.assertTrue(verifyHistoricperformancecomparisonDropdown(values), values+" not found");
    }

    public void clickHistoricDropdown(){
        scrollToElement(historicDropdown);
        historicDropdown.click();
    }

    public void verifyPerformanceAnalysisFiltersSameAsBioDiversityFilters(){
        for (int i=0;i< performanceAnalysisFilters.size();i++){
            Assert.assertTrue(performanceAnalysisFilters.get(i).getText().equalsIgnoreCase(biodiversityFilters.get(i).getText()));
        }
    }

    public void clickImproveScoreButton(){
        scrollToElement(improveBiodiversityScore);
        //improveBiodiversityScore.click();
        javaScriptExecutorClick(improveBiodiversityScore);
    }

    public void captureTheValueOfBiodiversityPerfFilters(){
        for (WebElement ele : biodiversityFilters){
            biodiversity_Filters.add(ele.getText());
        }
    }

    public void verifyRecommendationFilterSameAsBiodiversityPerfFilters(){
        for (int i=0; i<biodiversityFilters.size();i++){
            Assert.assertTrue(biodiversity_Filters.get(i).equalsIgnoreCase(biodiversityFilters.get(i).getText()));
        }
    }

    public void capturePerformanceFieldAndFarmName(){
        getPerformanceFarmName = performanceFarmName.getText();
        getPerformanceFieldName = performanceFieldmName.getText();
    }

    public void clickOnRocketIconForTheFram(){
        scrollToElement(rocketButton);
        rocketButton.click();
    }

    public void verifyReccomendationFarmAndFieldNameSameAsPerformanceFarmAndFieldName(){
        Assert.assertTrue(getPerformanceFarmName.equalsIgnoreCase(recommendationFramFilter.getText()));
        Assert.assertTrue(getPerformanceFieldName.equalsIgnoreCase(recommendationFieldFilter.getText()));
    }

    public void expandManagementPrractices(String button){
        WebElement ele = prepareWebElementWithDynamicXpath(managementPractices, button);
        scrollToElement(ele);
        ele.click();
    }

    public void uncheckFieldNamesforManagementPractice(String managementPractices) {
        WebElement ele = prepareWebElementWithDynamicXpath(fieldNameCheckBox, managementPractices);
        if (ele.getAttribute("aria-label").equalsIgnoreCase("Unselect all rows")) {
            scrollToElement(ele);
            ele.click();
        }
    }

    public void checkFieldNamesforManagementPractice(String managementPractices){
        WebElement ele = prepareWebElementWithDynamicXpath(fieldNameCheckBox, managementPractices);
        if (ele.getAttribute("aria-label").equalsIgnoreCase("Select all rows")){
            scrollToElement(ele);
            ele.click();
        }
    }

    public void clickBannerButton(String buttonName){
        WebElement ele = prepareWebElementWithDynamicXpath(bannerButton, buttonName);
        scrollToElement(ele);
        ele.click();
    }

    public void captureAndVerifyTextOnBanner(String text) throws InterruptedException {
        TestUtil.waitForElementVisible(driver, bannerText, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(6000);
        Assert.assertTrue(bannerText.getText().contains(text));
    }

    public void userSearchForReport(String reportName){
        searchReport.sendKeys(reportName);
    }

    public void clickOnViewReportButton(String reportName){
        WebElement ele = prepareWebElementWithDynamicXpath(viewReportButton, reportName);
        ele.click();

    }

    public void verifyReportTitleAndCreateDate(String reportName){
        Assert.assertTrue(reportTitle.getText().equalsIgnoreCase(reportName));
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("d MMMMMM yyyy");
        String formattedDate = formatter.format(date);
        Assert.assertTrue(formattedDate.equalsIgnoreCase(reportCreatedDate.getText()), formattedDate+" formatDate and locator date "+reportCreatedDate.getText());
    }

    public void clickReportBackButton(){
        reportBackButton.click();
    }












}
