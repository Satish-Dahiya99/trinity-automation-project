package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.LandUses;
import utilities.Context;

import java.util.List;

public class LandUsesStep {

    Logger log = BaseLib.getLog(this.getClass().getName());
    Context context;
    LandUses landUses;

    public LandUsesStep(Context context) {
        this.context = context;
        this.landUses = context.getLandUses();
    }

    @And("select land use data year as {string}")
    public void selectLandUseDataYear(String year) {
        landUses.clickLandUseYear(year);
    }

    @Then("Select filter with data for land use")
    public void SelectFilterWithDataForLandUse(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        landUses.selectFilterForLandUselData(data.get(1).get(0), data.get(1).get(1));
        landUses.selectFilterForLandUselData(data.get(2).get(0), data.get(2).get(1));
    }

    @And("add required encouraged data for land use")
    public void addRequiredEncouragedDataForLandUse(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        landUses.selectRequiredDataToAddLandUse(data.get(1).get(0), data.get(1).get(1));
        landUses.selectRequiredDataToAddLandUse(data.get(2).get(0), data.get(2).get(1));
        landUses.selectRequiredDataToAddLandUse(data.get(3).get(0), data.get(3).get(1));
        landUses.selectRequiredDataToAddLandUse(data.get(4).get(0), data.get(4).get(1));

    }

    @Then("verify the below land uses data in row {string}")
    public void verifyTheBelowLandUsesDataInRow(String row, DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        landUses.verifyRequiredLandUsesData(row, data.get(1).get(1));
        landUses.verifyRequiredLandUsesData(row, data.get(2).get(1));
    }

    @And("for row {string} data for land uses click on {string} button")
    public void forRowDataForLandUsesClickOnButton(String row, String action) {
        landUses.clickOnActionButtonForAddedRequiredData(row, action);
    }

    @Then("click on select all button for {string} field on Replicate records page")
    public void clickOnSelectAllButtonOnReplicateRecordsPage(String buttonName) throws InterruptedException {
        landUses.selectAllButtonOnReplicateRecordsPage(buttonName);
    }

    @And("select filters on replicate records page")
    public void selectFiltersOnReplicateRecordsPage(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        landUses.selectFilterOnReplicateRecordPage(data.get(1).get(0), data.get(1).get(1));
        landUses.selectFilterOnReplicateRecordPage(data.get(2).get(0), data.get(2).get(1));
        landUses.selectFilterOnReplicateRecordPage(data.get(3).get(0), data.get(3).get(1));
    }

    @Then("expand the {string} field on replicate records to select year {string}")
    public void expandFieldOnReplicateRecordsToSelectYear(String fieldName, String year) {
        landUses.expandFieldOnReplicatePage(fieldName);
        landUses.selectYearForSelectedFieldOnReplicatePage(year);
    }

    @And("user clicks on {string} button on replicate page")
    public void userClicksOnActionButtonOnReplicatePage(String actionButton) {
        landUses.saveOrCancleButton(actionButton);
    }

    @Then("Select filter with data for land use Farm Level Enterprise")
    public void selectFilterWithDataForLandUseFarmLevelEnterprise(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        landUses.selectFilterForLandUselData(data.get(1).get(0), data.get(1).get(1));
    }

    @And("add required encouraged data for land use Farm Level Enterprise")
    public void addRequiredEncouragedDataForLandUseFarmLevel(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        landUses.selectRequiredDataToAddLandUse(data.get(1).get(0), data.get(1).get(1));
        landUses.selectRequiredDataToAddLandUse(data.get(2).get(0), data.get(2).get(1));
        landUses.selectRequiredDataToAddLandUse(data.get(3).get(0), data.get(3).get(1));
        landUses.selectRequiredDataToAddLandUse(data.get(4).get(0), data.get(4).get(1));
        landUses.selectRequiredDataToAddLandUse(data.get(5).get(0), data.get(5).get(1));

    }

    @And("select filters on replicate records page for Farm Level")
    public void selectFiltersOnReplicateRecordsPageForFarmLevel(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        landUses.selectFilterOnReplicateRecordPage(data.get(1).get(0), data.get(1).get(1));
    }

    @Then("expand the {string} farm on replicate records to select year {string}")
    public void expandFarmOnReplicateRecordsToSelectYear(String fieldName, String year) {
        landUses.expandFieldOnReplicatePage(fieldName);
        landUses.selectYearForSelectedFieldOnReplicatePage(year);
    }
}
