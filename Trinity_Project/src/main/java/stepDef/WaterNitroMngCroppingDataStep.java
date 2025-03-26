package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.WaterNitroMngCroppingData;
import utilities.Context;

import java.util.List;

public class WaterNitroMngCroppingDataStep {

    Logger log = BaseLib.getLog(this.getClass().getName());

    Context context;
    WaterNitroMngCroppingData waterNitroMngCroppingData;

    public WaterNitroMngCroppingDataStep(Context context) {
        this.context = context;
        waterNitroMngCroppingData = context.getWaterNitroMngCroppingData();
    }

    @And("Select filter with data for cropping data")
    public void selectFilterWithDataForCroppingData(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        waterNitroMngCroppingData.selectFilterForCroppingData(data.get(1).get(0), data.get(1).get(1));
        waterNitroMngCroppingData.selectFilterForCroppingData(data.get(2).get(0), data.get(2).get(1));
        waterNitroMngCroppingData.selectFilterForCroppingData(data.get(3).get(0), data.get(3).get(1));
    }

    @And("add required data for cropping data")
    public void addRequiredDataForCroppingData(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        waterNitroMngCroppingData.selectRequiredDataForCroppingData(data.get(1).get(0), data.get(1).get(1));
        waterNitroMngCroppingData.selectRequiredDataForCroppingData(data.get(2).get(0), data.get(2).get(1));
        waterNitroMngCroppingData.selectRequiredDataForCroppingData(data.get(3).get(0), data.get(3).get(1));
        waterNitroMngCroppingData.selectRequiredDataForCroppingData(data.get(4).get(0), data.get(4).get(1));
        waterNitroMngCroppingData.selectRequiredDataForCroppingData(data.get(5).get(0), data.get(5).get(1));
        waterNitroMngCroppingData.selectRequiredDataForCroppingData(data.get(6).get(0), data.get(6).get(1));
    }

    @Then("set {string} for year {string}")
    public void setDateForYear(String dateType, String year) {
        waterNitroMngCroppingData.setDate(dateType, year);
    }

    @And("verify the below cropping data in row {string}")
    public void verifyBelowCroppingData(String row, DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        waterNitroMngCroppingData.verifyRequiredLandUsesData(row, data.get(1).get(1));
        waterNitroMngCroppingData.verifyRequiredLandUsesData(row, data.get(2).get(1));
        waterNitroMngCroppingData.verifyRequiredLandUsesData(row, data.get(3).get(1));
    }

    @Then("for row {string} data click on {string} action button")
    public void forRowDataClickOnActionButton(String row, String actionName) {
        waterNitroMngCroppingData.clickActionItem(row, actionName);
    }

    @And("check the select all checkbox")
    public void checkTheSelectAllCheckbox() {
        waterNitroMngCroppingData.clickSelectAllCheckBox();
    }

    @Then("check the data point checkbox")
    public void selectDataPointCheckbox() {
        waterNitroMngCroppingData.selectDataPointCheckbox();
    }

    @And("select the destination fields")
    public void selectDestinationFields(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        waterNitroMngCroppingData.chooseDestinationFieldsFilters(data.get(1).get(0), data.get(1).get(1));
        waterNitroMngCroppingData.chooseDestinationFieldsFilters(data.get(2).get(0), data.get(2).get(1));
        waterNitroMngCroppingData.chooseDestinationFieldsFilters(data.get(3).get(0), data.get(3).get(1));
    }

    @Then("choose {string} checkbox for destination fields")
    public void chooseCheckboxForDestinationFields(String fieldName) throws InterruptedException {
        waterNitroMngCroppingData.selectDestinationFieldCheckbox(fieldName);
    }

    @Then("remove {string} value from filter")
    public void removeValueFromFilter(String value) throws InterruptedException {
        waterNitroMngCroppingData.setRemoveFilter(value);
    }

    @And("open {string} filter dropdown and select below values")
    public void openFilterDropdownAndSelectBelowValues(String filterName, DataTable dataTable) throws InterruptedException {
        waterNitroMngCroppingData.clickFilter(filterName);
        waterNitroMngCroppingData.selectDropDownFilterValue(dataTable);
    }

    @Then("choose data to edit for cropping data")
    public void chooseDataToEditForCroppingData(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        waterNitroMngCroppingData.selectRequiredDataForCroppingData(data.get(1).get(0), data.get(1).get(1));
        waterNitroMngCroppingData.selectRequiredDataForCroppingData(data.get(2).get(0), data.get(2).get(1));
        waterNitroMngCroppingData.selectRequiredDataForCroppingData(data.get(3).get(0), data.get(3).get(1));
        waterNitroMngCroppingData.selectRequiredDataForCroppingData(data.get(4).get(0), data.get(4).get(1));

    }

    @And("verify the success message displayed as {string}")
    public void verifySuccessMessageDisplayedAs(String message) {
        waterNitroMngCroppingData.verifySuccessMessage(message);
    }


}
