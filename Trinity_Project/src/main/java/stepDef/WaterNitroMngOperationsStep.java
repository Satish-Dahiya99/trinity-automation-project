package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.WaterNitroMngOperations;
import utilities.Context;

import java.util.List;

public class WaterNitroMngOperationsStep {

    Logger log = BaseLib.getLog(this.getClass().getName());

    Context context;
    WaterNitroMngOperations waterNitroMngOperations;

    public WaterNitroMngOperationsStep(Context context) {
        this.context = context;
        waterNitroMngOperations = context.getWaterNitroMngOperations();
    }

    @And("Select filter with data for operations")
    public void selectFilterWithDataForOperations(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        waterNitroMngOperations.selectFilterForOperations(data.get(1).get(0), data.get(1).get(1));
        waterNitroMngOperations.selectFilterForOperations(data.get(2).get(0), data.get(2).get(1));
        waterNitroMngOperations.selectFilterForOperations(data.get(3).get(0), data.get(3).get(1));
        waterNitroMngOperations.selectFilterForOperations(data.get(4).get(0), data.get(4).get(1));
        waterNitroMngOperations.selectFilterForOperations(data.get(5).get(0), data.get(5).get(1));

    }

    @Then("add required data for operations")
    public void addRequiredDataForOperations(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(1).get(0), data.get(1).get(1));
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(2).get(0), data.get(2).get(1));
        waterNitroMngOperations.addProduct(data.get(3).get(1));
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(4).get(0), data.get(4).get(1));
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(5).get(0), data.get(5).get(1));
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(6).get(0), data.get(6).get(1));
        waterNitroMngOperations.setDate(data.get(7).get(0), data.get(7).get(1));
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(8).get(0), data.get(8).get(1));

    }

    @And("verify the below operations data in row {string}")
    public void verifyBelowOperationsData(String row, DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        waterNitroMngOperations.verifyRequiredOperationsData(row, data.get(1).get(1));
        waterNitroMngOperations.verifyRequiredOperationsData(row, data.get(2).get(1));
        waterNitroMngOperations.verifyRequiredOperationsData(row, data.get(3).get(1));
    }

    @Then("for row {string} operations data click on {string} action button")
    public void forRowOperationsDataClickActionButton(String row, String actionName) {
        waterNitroMngOperations.clickActionItem(row, actionName);
    }

    @And("edit required data for operations")
    public void editRequiredDataForOperations(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(1).get(0), data.get(1).get(1));
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(2).get(0), data.get(2).get(1));
        waterNitroMngOperations.addProduct(data.get(3).get(1));
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(4).get(0), data.get(4).get(1));
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(5).get(0), data.get(5).get(1));
    }

    @Then("check the data point checkbox for operations")
    public void checkDataPointCheckboxForOperations() {
        waterNitroMngOperations.checkDataPointCheckbox();
    }

    @And("choose the destination fields for operations")
    public void chooseDestinationFieldsForOperations(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        waterNitroMngOperations.chooseDestinationFieldsFilters(data.get(1).get(0), data.get(1).get(1));
        waterNitroMngOperations.chooseDestinationFieldsFilters(data.get(2).get(0), data.get(2).get(1));
        waterNitroMngOperations.chooseDestinationFieldsFilters(data.get(3).get(0), data.get(3).get(1));
        waterNitroMngOperations.chooseDestinationFieldsFilters(data.get(4).get(0), data.get(4).get(1));
        waterNitroMngOperations.chooseDestinationFieldsFilters(data.get(5).get(0), data.get(5).get(1));

    }

    @And("choose {string} checkbox for destination fields for operations")
    public void chooseCheckboxForDestinationFieldsForOperations(String checkBoxName) throws InterruptedException {
        waterNitroMngOperations.selectDestinationFieldCheckbox(checkBoxName);
    }

    @Then("click on {string} category to see records by their status")
    public void clickOnCategoryToSeeRecordsByTheirStatus(String categoryName) {
        waterNitroMngOperations.clickCategoryToSeeRecordsByStatus(categoryName);
    }

    @And("click on {string} warning type")
    public void clickOnWarningType(String warningTypeName) {
        waterNitroMngOperations.clickOnWarningType(warningTypeName);
    }

    @Then("verify the warning message displayed as {string}")
    public void verifyWarningMessageDisplayedAs(String warningMessage) {
        waterNitroMngOperations.assertWarningMessage(warningMessage);
    }

    @And("choose data to edit for operations data")
    public void chooseDataToEditForOperationsData(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(1).get(0), data.get(1).get(1));
        waterNitroMngOperations.selectRequiredDataForOperations(data.get(2).get(0), data.get(2).get(1));
        waterNitroMngOperations.addProduct(data.get(3).get(1));
    }
}
