package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.FuelMachinery;
import utilities.Context;

import javax.xml.crypto.Data;
import java.util.List;

public class FuelMachineryStep {

    Logger log = BaseLib.getLog(this.getClass().getName());
    Context context;
    FuelMachinery fuelMachinery;

    public FuelMachineryStep(Context context) {
        this.context = context;
        this.fuelMachinery = context.getFuelMachinery();
    }

    @And("select level as {string} to record machinery fuel data")
    public void selectLevelToRecordMachineryFuelData(String level) {
        fuelMachinery.selectLevel(level);
    }

    @Then("select filter on field level page")
    public void selectFilterOnFieldLevelPage(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        fuelMachinery.selectFilter(data.get(1).get(0), data.get(1).get(1));
        fuelMachinery.selectFilter(data.get(2).get(0), data.get(2).get(1));
        fuelMachinery.selectFilter(data.get(3).get(0), data.get(3).get(1));
        fuelMachinery.selectFilter(data.get(4).get(0), data.get(4).get(1));
    }

    @And("select the crop variety as {string}")
    public void selectCropVarietyAs(String cropVariety) throws InterruptedException {
        fuelMachinery.setSelectCropVariety(cropVariety);
    }

    @Then("select Encouraged Data for Exact Method")
    public void selectEncouragedDataForExactMethod(DataTable value) throws InterruptedException {
        List<List<String>> data = value.asLists();
        fuelMachinery.selectExactMethodDropdownRecord(data.get(1).get(0), data.get(1).get(1));
        fuelMachinery.enterExactMethodTextRecord(data.get(2).get(0), data.get(2).get(1));
        fuelMachinery.selectExactMethodDropdownRecord(data.get(3).get(0), data.get(3).get(1));
        fuelMachinery.selectExactMethodDropdownRecord(data.get(4).get(0), data.get(4).get(1));

    }

    @Then("select Encouraged Data for Estimated Method")
    public void selectEncouragedDataForEstimatedMethod(DataTable value) throws InterruptedException {
        List<List<String>> data = value.asLists();
        fuelMachinery.selectEstimatedMethodDropdownRecord(data.get(1).get(0), data.get(1).get(1));
        fuelMachinery.selectEstimatedMethodDropdownRecord(data.get(2).get(0), data.get(2).get(1));
        fuelMachinery.enterEstimatedMethodTextRecord(data.get(3).get(0), data.get(3).get(1));
        fuelMachinery.selectEstimatedMethodDropdownRecord(data.get(4).get(0), data.get(4).get(1));

    }

    @And("verify data for {string} method")
    public void verifyDataForMethod(String methodName, DataTable value) throws InterruptedException {
        List<List<String>> data = value.asLists();
        fuelMachinery.verifyRequiredData(methodName, data.get(0).get(1));
        fuelMachinery.verifyRequiredData(methodName, data.get(1).get(1));
    }

    @Then("for {string} method click on {string} action button")
    public void clickOnActionButtonForMethod(String methodName, String actionName) {
        fuelMachinery.clickActionButtonForMethods(methodName, actionName);
    }

    @Then("edit Encouraged Data for Exact Method")
    public void editEncouragedDataForExactMethod(DataTable value) throws InterruptedException {
        List<List<String>> data = value.asLists();
        fuelMachinery.editExactMethodDropdownRecord(data.get(1).get(0), data.get(1).get(1));
        fuelMachinery.enterExactMethodTextRecord(data.get(2).get(0), data.get(2).get(1));
        fuelMachinery.editExactMethodDropdownRecord(data.get(3).get(0), data.get(3).get(1));
        fuelMachinery.editExactMethodDropdownRecord(data.get(4).get(0), data.get(4).get(1));

    }

    @Then("edit Encouraged Data for Estimated Method")
    public void editEncouragedDataForEstimatedMethod(DataTable value) throws InterruptedException {
        List<List<String>> data = value.asLists();
        fuelMachinery.editEstimatedMethodDropdownRecord(data.get(1).get(0), data.get(1).get(1));
        fuelMachinery.editEstimatedMethodDropdownRecord(data.get(2).get(0), data.get(2).get(1));
        fuelMachinery.enterEstimatedMethodTextRecord(data.get(3).get(0), data.get(3).get(1));
        fuelMachinery.editEstimatedMethodDropdownRecord(data.get(4).get(0), data.get(4).get(1));

    }

    @And("click on select all rows checkbox")
    public void clickOnSelectAllRowsCheckbox() throws InterruptedException {
        fuelMachinery.selectAllRowsCheckbox();
    }

    @Then("select filter on crop level page")
    public void selectFilterOnCropLevelPage(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        fuelMachinery.removeAndSelectYearFilter(data.get(1).get(0), data.get(1).get(1));
        fuelMachinery.selectFilter(data.get(2).get(0), data.get(2).get(1));
        fuelMachinery.selectFilter(data.get(3).get(0), data.get(3).get(1));
    }

    @And("add required data for Carbon Field")
    public void addRequiredDataForCarbonField(DataTable dataValue) throws InterruptedException {
        List<List<String>> data = dataValue.asLists();
        fuelMachinery.addRequiredData(data.get(1).get(0), data.get(1).get(1));
        fuelMachinery.enterRequiredDataInInputTextField(data.get(2).get(0), data.get(2).get(1));
    }

    @Then("select filter on farm level page")
    public void selectFilterOnFarmLevelPage(DataTable dataValue) throws InterruptedException {
        List<List<String>> data = dataValue.asLists();
        fuelMachinery.removeAndSelectYearFilter(data.get(1).get(0), data.get(1).get(1));
        fuelMachinery.selectFilter(data.get(2).get(0), data.get(2).get(1));
    }

    @And("verify the added farm level data in row {string}")
    public void verifyTheAddedFarmLevelDataInRow(String row, DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        fuelMachinery.verifyRequiredFarmLevelData(row, data.get(1).get(1));
        fuelMachinery.verifyRequiredFarmLevelData(row, data.get(2).get(1));
    }

    @Then("for row {string} data click on {string} button")
    public void forRowDataClickOnActionButton(String row, String actionName) {
        fuelMachinery.clickOnActionButtonForAddedRequiredData(row, actionName);

    }

    @And("edit the row {string} data for the below fields")
    public void editTheRowDataForTheBelowFields(String row, DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        fuelMachinery.editRequiredEncouragedData(row, data.get(1).get(0), data.get(1).get(1));
        fuelMachinery.editRequiredEncouragedData(row, data.get(2).get(0), data.get(2).get(1));
    }

    @And("verify the success message {string}")
    public void verifySuccessMessage(String successMessage) {
        fuelMachinery.verifySuccessfulMessage(successMessage);
    }
}
