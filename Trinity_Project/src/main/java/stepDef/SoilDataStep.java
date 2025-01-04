package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.SoilData;
import utilities.Context;

import java.util.List;

public class SoilDataStep {

    Logger log = BaseLib.getLog(this.getClass().getName());
    Context context;
    SoilData soilData;

    public SoilDataStep(Context context) {
        this.context = context;
        this.soilData = context.getSoilData();
    }

    @And("select filter on soil page")
    public void selectFilterOnSoilPage(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        soilData.selectFilter(data.get(1).get(0), data.get(1).get(1));
        soilData.selectFilter(data.get(2).get(0), data.get(2).get(1));
        soilData.removeYearFilter(data.get(3).get(1));
        soilData.selectFilter(data.get(4).get(0), data.get(4).get(1));
    }

    @Then("select required data to add soil")
    public void selectRequiredDataToAddSoil(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        soilData.selectValuesAfterClickingDropdownValues(data.get(1).get(0), data.get(1).get(1));
        soilData.selectRequiredDataToAddCrop(data.get(2).get(0), data.get(2).get(1));
        soilData.selectRequiredDataToAddCrop(data.get(3).get(0), data.get(3).get(1));
        soilData.selectRequiredDataToAddCrop(data.get(4).get(0), data.get(4).get(1));
        soilData.selectRequiredDataToAddCrop(data.get(5).get(0), data.get(5).get(1));
        soilData.selectRequiredDataToAddCrop(data.get(6).get(0), data.get(6).get(1));
        soilData.selectRequiredDataToAddCrop(data.get(7).get(0), data.get(7).get(1));
        soilData.setDate(data.get(8).get(0), data.get(8).get(1));
    }

    @And("verify the added required data in row {string} in soil data page")
    public void verifyAddedRequiredDataInRowInSoilDataPage(String row, DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        soilData.verifyRequiredData(row, data.get(1).get(1));
        soilData.verifyRequiredData(row, data.get(2).get(1));
    }

    @Then("click on {string} button for required data in row {string} in soil data page")
    public void clickOnActionButtonForRequiredDataInRow(String actionName, String row ) {
        soilData.clickActionButtonForAddedRequiredData(actionName, row);
    }

    @And("update required data to add soil")
    public void updateRequiredDataToAddSoil(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        soilData.selectValueInSoilTypeDropDown(data.get(0).get(1));
        soilData.selectRequiredDataToAddCrop(data.get(1).get(0), data.get(1).get(1));
    }

    @Then("verify after deleting all data No records are present text is displayed")
    public void verifyAfterDeletingAllData(){
        soilData.verifyTextAfterDeletingAllData();
    }

    @And("click on button on popup having name as {string}")
    public void clickOnButtonHavingNameAs(String button){
        soilData.clickButton(button);
    }


}
