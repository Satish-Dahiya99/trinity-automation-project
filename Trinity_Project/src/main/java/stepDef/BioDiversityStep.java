package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.BioDiversity;
import utilities.Context;

import java.util.List;

public class BioDiversityStep {

    Logger log = BaseLib.getLog(this.getClass().getName());
    Context context;
    BioDiversity bioDiversity;

    public BioDiversityStep(Context context){
        this.context = context;
        this.bioDiversity = context.getBioDiversity();
    }

    @Then("user navigates to {string}")
    public void usernavigatesto(String button){
        bioDiversity.clickOnBioDiversityMenu(button);
    }

    @And("verify year selected as {string}")
    public void verifyyearselectedas(String year){
        bioDiversity.verifyYearFilterData(year);
    }

    @Then("verify biodiversity score is {string}")
    public void verifybiodiversityscore(String score){
        bioDiversity.verifyBioDiversityScore(score);
    }

    @Then("user creates a report with name {string}")
    public void usercreatesareport(String reportName){
        bioDiversity.enterReportNameAndCreateReport(reportName);
    }

    @And("verify report {string} is displayed on reports page")
    public void verifyReportOnReportsPage(String reportName) throws InterruptedException {
        bioDiversity.verifyReportNameOnReportPage(reportName);
    }

    @Then(("delete the report {string}"))
    public void deletethereport(String reportName){
        bioDiversity.deleteTheCreatedReport(reportName);
    }

    @And("verify report {string} is deleted")
    public void verifyreportisdeleted(String reportName) throws InterruptedException {
        bioDiversity.verifyReportNameOnReportPageNotDisplayed(reportName);
    }

    @Then("click on button menu {string}")
    public void clickMenuButton(String buttonName){
        bioDiversity.clickButtonMenu(buttonName);
    }

    @And("verify Historic performance comparison dropdown values")
    public void verifyHistoricperformancecomparisondropdownvalues(DataTable selectData){
        bioDiversity.clickHistoricDropdown();
        List<List<String>> list = selectData.asLists();
        bioDiversity.verifyHistoricperformancecomparisonDropdownValues(list.get(1).get(0));
        bioDiversity.verifyHistoricperformancecomparisonDropdownValues(list.get(2).get(0));
        bioDiversity.verifyHistoricperformancecomparisonDropdownValues(list.get(3).get(0));
        bioDiversity.verifyHistoricperformancecomparisonDropdownValues(list.get(4).get(0));
        bioDiversity.verifyHistoricperformancecomparisonDropdownValues(list.get(5).get(0));
        bioDiversity.verifyHistoricperformancecomparisonDropdownValues(list.get(6).get(0));
        }

    @And("verify the filters in Detailed performance analysis is same as Biodiversity dashboard filters")
    public void verifythefiltersinDetailedperformanceanalysisissameasBiodiversitydashboardfilters(){
        bioDiversity.verifyPerformanceAnalysisFiltersSameAsBioDiversityFilters();
    }

    @Then("capture the values of biodiversity performance filters")
    public void capturevaluesofbiodiversityperformancefilters(){
        bioDiversity.captureTheValueOfBiodiversityPerfFilters();
    }

    @And("click on improve biodiversity score button")
    public void clickonimprovebiodiversityscorebutton(){
        bioDiversity.clickImproveScoreButton();
    }

    @Then("verify recommendations filters  is same as Biodiversity performance filters")
    public void verifyrecommendationsfilterssameasBiodiversityperformancefilters(){
        bioDiversity.verifyRecommendationFilterSameAsBiodiversityPerfFilters();
    }

    @And("capture first farm and field name from performance analysis table")
    public void capturefirstfarmandfieldnamefromperformanceanalysistable(){
        bioDiversity.capturePerformanceFieldAndFarmName();
    }

    @Then("click on the rocket icon for the first farm name")
    public void clickontherocketiconforthefirstfarmname(){
        bioDiversity.clickOnRocketIconForTheFram();
    }

    @And("verify the filters farm name and field name displayed same as performance analysis table")
    public void verifyfiltersfarmnameandfieldnamedisplayedsameasperformanceanalysistable(){
        bioDiversity.verifyReccomendationFarmAndFieldNameSameAsPerformanceFarmAndFieldName();
    }

    @Then("expand on {string} management practices")
    public void expandmanagementpractices(String practicesName){
        bioDiversity.expandManagementPrractices(practicesName);
    }

    @And("uncheck all the field names for {string} management practices")
    public void uncheckallfieldnamesformanagementpractices(String practiceName){
        bioDiversity.uncheckFieldNamesforManagementPractice(practiceName);
//        if (action.equalsIgnoreCase("uncheck")){
//            bioDiversity.uncheckFieldNamesforManagementPractice(practiceName);
//        } else if (action.equalsIgnoreCase("check")) {
//            bioDiversity.checkFieldNamesforManagementPractice(practiceName);
//        }

    }

    @Then("click {string} banner button")
    public void clickbannerbutton(String button){
        bioDiversity.clickBannerButton(button);
    }

    @And("verify the text on the banner as {string}")
    public void verifythetextonthebanner(String text) throws InterruptedException {
        bioDiversity.captureAndVerifyTextOnBanner(text);
    }

    @Then("user search for {} report")
    public void usersearchforreport(String reportName){
        bioDiversity.userSearchForReport(reportName);
    }

    @And("click on view report button {string} report")
    public void clickonviewreportbuttonreport(String reportName){
        bioDiversity.clickOnViewReportButton(reportName);
    }

    @Then("verify the report name as {string} and current created date")
    public void verifythereportnameasandcurrentcreateddate(String reportName){
        bioDiversity.verifyReportTitleAndCreateDate(reportName);
    }

    @And("click arrow back button")
    public void clickarrowbackbutton(){
        bioDiversity.clickReportBackButton();
    }
}
