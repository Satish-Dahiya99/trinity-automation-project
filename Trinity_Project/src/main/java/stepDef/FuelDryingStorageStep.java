package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.FuelDryingStorage;
import utilities.Context;

import java.util.List;

public class FuelDryingStorageStep {

    Logger log = BaseLib.getLog(this.getClass().getName());
    Context context;
    FuelDryingStorage fuelDryingStorage;

    public FuelDryingStorageStep(Context context) {
        this.context = context;
        this.fuelDryingStorage = context.getFuelDryingStorage();
    }

    @And("select filter on Fuel Drying and Storage page")
    public void selectFilterOnFuelDryingAndStoragePage(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        fuelDryingStorage.selectFilter(data.get(1).get(0), data.get(1).get(1));
        fuelDryingStorage.selectFilter(data.get(2).get(0), data.get(2).get(1));
    }

    @Then("select the {string} checkbox")
    public void selectOnFarmCheckbox(String checkBoxName) {
        fuelDryingStorage.clickOnFarmTheCheckbox(checkBoxName);
    }

    @And("select required data")
    public void selectRequiredData(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        fuelDryingStorage.selectRequiredData(data.get(1).get(0), data.get(1).get(1));
        fuelDryingStorage.selectRequiredData(data.get(2).get(0), data.get(2).get(1));
        fuelDryingStorage.selectRequiredData(data.get(3).get(0), data.get(3).get(1));
    }

    @Then("verify the following fuel type on fuel drying and storage page in row {string}")
    public void verifyFuelTypeOnFuelDryingAndStoragePageInRow(String row, DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        fuelDryingStorage.verifyRequiredData(row, data.get(0).get(0));
        fuelDryingStorage.verifyRequiredData(row, data.get(1).get(0));
    }

    @And("click on {string} button for fuel dry and storage data")
    public void clickActionbuttonForFuleDryStorageData(String actionName) {
        fuelDryingStorage.clickActionButton(actionName);

    }

    @Then("edit below required data")
    public void editBelowRequiredData(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        fuelDryingStorage.selectRequiredData(data.get(1).get(0), data.get(1).get(1));
        fuelDryingStorage.selectRequiredData(data.get(2).get(0), data.get(2).get(1));
        fuelDryingStorage.selectRequiredData(data.get(3).get(0), data.get(3).get(1));
        fuelDryingStorage.selectRequiredData(data.get(4).get(0), data.get(4).get(1));
    }

}
