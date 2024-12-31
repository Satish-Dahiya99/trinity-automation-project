package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.ResidueManagement;
import utilities.Context;

import java.util.List;

public class ResidueManagementStep {

    Logger log = BaseLib.getLog(this.getClass().getName());
    Context context;
    ResidueManagement residueManagement;


    public ResidueManagementStep(Context context){
        this.context = context;
        this.residueManagement = context.getResidueManagement();
    }

    @And("select filter for on residue management page")
    public void SelectfilterwithdataOnResidueManagementPage(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        residueManagement.selectFilter(data.get(1).get(0), data.get(1).get(1));
        residueManagement.selectFilter(data.get(2).get(0), data.get(2).get(1));
        residueManagement.selectFilter(data.get(3).get(0), data.get(3).get(1));
        residueManagement.selectFilter(data.get(4).get(0), data.get(4).get(1));
        residueManagement.selectFilter(data.get(5).get(0), data.get(5).get(1));

    }

    @And("select required data for residual management for record {string}")
    public void selectRequiredDataForResidualManagement(String record, DataTable filterData ) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        residueManagement.selectRequiredDataToAddRecord(record, data.get(1).get(0), data.get(1).get(1));
        residueManagement.selectRequiredDataToAddRecord(record, data.get(2).get(0), data.get(2).get(1));
        residueManagement.addPercentageForRecord(record, data.get(3).get(1));
    }

    @Then("verify the residual data for row {string}")
    public void verifyTheResidualData(String row,  DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        residueManagement.verifyResidualData(row, data.get(0).get(0));
        residueManagement.verifyResidualData(row, data.get(1).get(0));
        residueManagement.verifyResidualData(row, data.get(2).get(0));
    }

    @And("click on Add another record button on Residue Management Page")
    public void clickAddAnotherRecordButton() throws InterruptedException {
        residueManagement.clickAddAnotherRecordButton();
    }

    @Then("click {string} button for row {string} data")
    public void clickButtonForRowData(String actionName, String row){
        residueManagement.clickActionButtonForResidualData(actionName, row);
    }

    @And("verify No row text is displayed")
    public void verifyNoRowTextDisplayed(){
        residueManagement.verifyNoRowText();
    }

    @Then("check the select all record checkbox")
    public void checkSelectAllRecordCheckbox(){
        residueManagement.checkTheSelectAllRecordCheckBox();
    }


}
