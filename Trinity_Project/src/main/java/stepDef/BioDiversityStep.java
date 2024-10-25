package stepDef;

import base.BaseLib;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.BioDiversity;
import utilities.Context;

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
}
