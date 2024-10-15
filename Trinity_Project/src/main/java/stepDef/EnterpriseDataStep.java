package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import pageObjects.ActivateEachService;
import pageObjects.EnterpriseData;
import utilities.Context;
import utilities.TestUtil;

import java.util.List;

public class EnterpriseDataStep {

    Logger log = BaseLib.getLog(this.getClass().getName());
    Context context;
    ActivateEachService activateEachService;
    EnterpriseData enterpriseData;

    public EnterpriseDataStep(Context context){
        this.context = context;
        activateEachService = context.getActivateEachService();
        enterpriseData = context.getEnterpriseData();
    }

    @Then("user navigates to enterprise data page")
    public void usernavigatestoenterprisedatapage(){
        enterpriseData.goToEnterpriseDataPage();
    }

    @And("user clicks on manage data for field {string}")
    public void userclicksonmanagedataforfield(String fieldName){
        enterpriseData.clickManageData(fieldName);
    }

    @Then("user clicks on add field button")
    public void userclicksonaddfieldbutton() throws InterruptedException {
        enterpriseData.clickAddField();
    }

    @And("enter the required data for Field")
    public void entertherequireddataforField(DataTable selectData) throws InterruptedException {
        List<List<String>> list = selectData.asLists();
        enterpriseData.addRequiredData(list.get(1).get(0), list.get(1).get(1));
        enterpriseData.addRequiredData(list.get(2).get(0), list.get(2).get(1));
        enterpriseData.addRequiredData(list.get(3).get(0), list.get(3).get(1));
        enterpriseData.addRequiredData(list.get(4).get(0), list.get(4).get(1));
        enterpriseData.addRequiredData(list.get(5).get(0), list.get(5).get(1));
        TestUtil.staticWait(2000);
        enterpriseData.addRequiredData(list.get(6).get(0), list.get(6).get(1));
        TestUtil.staticWait(2000);
    }

    @And("user set required data field {string} as {string}")
    public void usersetrequireddatafield(String field, String data) throws InterruptedException {
        enterpriseData.addRequiredData(field, data);
    }

    @Then("verify the field {string} is having value as {string}")
    public void verifyTheFieldWithData(String fieldName, String data){
        enterpriseData.verifydataOfField(fieldName, data);
    }

    @Then("edit the field {string}")
    public void editTheField(String fieldName) throws InterruptedException {
        enterpriseData.editTheField(fieldName);
    }

    @Then("delete the field {string}")
    public void deleteTheField(String fieldName) throws InterruptedException {
        enterpriseData.deleteTheField(fieldName);
        activateEachService.yesDeleteButton();
    }

    @Then("click on button {string}")
    public void clickOnButton(String buttonName) throws InterruptedException {
        enterpriseData.clickButton(buttonName);
    }
}
