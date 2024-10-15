package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import pageObjects.ActivateEachService;
import pageObjects.FarmSetup;
import utilities.Context;
import utilities.TestUtil;

import javax.swing.*;
import java.util.List;

public class FarmSetupStep {

    Logger log = BaseLib.getLog(this.getClass().getName());
    Context context;
    ActivateEachService activateEachService;
    FarmSetup farmSetup;

    public FarmSetupStep(Context context){
        this.context = context;
        activateEachService = context.getActivateEachService();
        farmSetup = context.getFarmSetup();
    }

    @When("user navigates to Farm setup page")
    public void usernavigatestoFarmsetuppage(){
        farmSetup.goToFarmSetupPage();
    }

    @And("user clicks on add farm")
    public void userclicksonaddfarm() throws InterruptedException {
        farmSetup.clickAddFarm();
    }

    @Then("enter the required data")
    public void entertherequireddata(DataTable selectData) throws InterruptedException {
        List<List<String>> data = selectData.asLists();
        farmSetup.enterFarmRequiredDetails(data.get(1).get(0), data.get(1).get(1));
    }

    @Then("user select Enterprises data as")
    public void userselectEnterprisesdataas(DataTable selectData){
        List<List<String>> data = selectData.asLists();
        farmSetup.selectEnterprise(data.get(1).get(0));
        farmSetup.selectEnterprise(data.get(2).get(0));
    }

    @Then("user enter farm name as {string}")
    public void userenterfarmname(String name){
        farmSetup.enterFarmName(name);

    }

    @And("user select coordinate as")
    public void userselectcoordinateas(DataTable selectData) throws InterruptedException {
        farmSetup.expandFarmCoordinates();
        List<List<String>> data = selectData.asLists();
        TestUtil.staticWait(3000);
        farmSetup.selectCordinates(data.get(0).get(1), data.get(1).get(1));
        TestUtil.staticWait(3000);
        farmSetup.selectCordinates(data.get(0).get(0), data.get(1).get(0));
        TestUtil.staticWait(2000);

    }

    @Then("{string} last {string} year data")
    public void addOrRemoveYear(String action, String year){
        farmSetup.addOrRemoveYear(action, year);
    }

    @And("{string} data for next year")
    public void addOrRemoveDataforNextYear(String action){
        farmSetup.addOrRemoveDataForNextYear(action);

    }

    @And("verify the success message as {string}")
    public void verifythesuccessmessage(String message){
        farmSetup.verifySuccessfulMessage(message);
    }

    @Then("edit the farm details for {string}")
    public void editthefarmdetails(String farmName) throws InterruptedException {
        farmSetup.clickEditButton(farmName);
    }

    @Then("delete the farm details for {string}")
    public void deletethefarmdetails(String farmName) throws InterruptedException {
        farmSetup.clickDeleteButton(farmName);
        activateEachService.yesDeleteButton();
    }

}
