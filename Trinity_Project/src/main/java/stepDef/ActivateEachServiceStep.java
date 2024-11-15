package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import pageObjects.ActivateEachService;
import utilities.Context;
import utilities.TestUtil;

import java.util.List;

public class ActivateEachServiceStep {

    Logger log = BaseLib.getLog(this.getClass().getName());
    Context context;
    ActivateEachService activateEachService;

    public ActivateEachServiceStep(Context context){
        this.context = context;
        activateEachService = context.getActivateEachService();
    }

    @When("user navigates to activate each service")
    public void usernavigatestoactivateeachservice(){
        activateEachService.goToActivateEachSearch();
    }

    @And("click on carbon manage data")
    public void clickoncarbonmanagedata() throws InterruptedException {
        activateEachService.clickCarbonManageData();
    }

    @Then("click on Manage data for cropping")
    public void clickonManagedataforcropping(){
        activateEachService.clickCroppingManageData();
    }

    @And("Select filter with data")
    public void Selectfilterwithdatatoaddcrop(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        activateEachService.selectFilter(data.get(1).get(0), data.get(1).get(1));
        activateEachService.selectFilter(data.get(2).get(0), data.get(2).get(1));
        activateEachService.removeFilter(data.get(4).get(1));
        activateEachService.selectFilter(data.get(3).get(0), data.get(3).get(1));
    }

    @And("remove data {string} for pre-selected filter")
    public void removedataforpreselectedfilter(String filterData){
        activateEachService.removeFilter(filterData);
    }

    @Then("click on add crop button")
    public void clickonaddcropbutton() throws InterruptedException {
        activateEachService.clickAddCropButton();
    }

    @And("add required data for crop")
    public void addrequireddataforcrop(DataTable selectData) throws InterruptedException {
        List<List<String>> data = selectData.asLists();
        activateEachService.selectRequiredDataToAddCrop(data.get(1).get(0), data.get(1).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(2).get(0), data.get(2).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(3).get(0), data.get(3).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(4).get(0), data.get(4).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(5).get(0), data.get(5).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(6).get(0), data.get(6).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(7).get(0), data.get(7).get(1));
    }

    @Then("set date to add crop")
    public void setdatetoaddcrop(DataTable selectData) throws InterruptedException {
        List<List<String>> data = selectData.asLists();
        activateEachService.setDate(data.get(1).get(0), data.get(1).get(1));
        activateEachService.setDate(data.get(2).get(0), data.get(2).get(1));
    }

    @And("user {string} the added data")
    public void userSaveOrCancleDataForCrop(String button) throws InterruptedException {
        activateEachService. saveOrCancleButton(button);
    }

    @Then("verify the data {string} message")
    public void verifydataSuccessMessage(String message)  {
        activateEachService.verifyCropDataSuccessfulMessage(message);
    }

    @And("verify tillage type as {string} is displayed")
    public void verifytillagetypeasisdisplayed(String text) {
        activateEachService.verifyTillageType(text);
    }

    @When("user clicks on edit button")
    public void userclicksoneditbutton() throws InterruptedException {
        activateEachService.clickEditButton();
    }

    @And("Edit single required data for crop")
    public void Editsinglerequireddataforcrop(DataTable selectData) throws InterruptedException {
        List<List<String>> data = selectData.asLists();
        activateEachService.selectRequiredDataToAddCrop(data.get(1).get(0), data.get(1).get(1));
    }

    @When("user clicks on delete button")
    public void userclicksondeletebutton() throws InterruptedException {
        activateEachService.clickDeleteButton();
    }

    @Then("click select all button for {string} field on Replicate records page")
    public void clickselectallbuttonforonReplicaterecordspage(String butttonName) throws InterruptedException {
        activateEachService.selectAllButtonOnReplicateRecordsPage(butttonName);

    }

    @And("user clicks on {string} delete button")
    public void userclicksoNdeletebutton(String buttonName){
        activateEachService.clickButtonOnDeletePopUp(buttonName);
    }

    @And("replicate filters for farm and fields")
    public void replicatefiltersforfarmandfields(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        activateEachService.selectFilter(data.get(1).get(0), data.get(1).get(1));
        activateEachService.selectFilter(data.get(2).get(0), data.get(2).get(1));

    }

    @Then("click manage data button for {string}")
    public void clickManageData(String buttonName){
        activateEachService.clickManageDataButton(buttonName);
    }

    @Then("click on add records button")
    public void clickonaddrecordsbutton() throws InterruptedException {
        activateEachService.clickAddCropButton();
    }

    @And("enter cropped area details to calculate the impact of productive land")
    public void entercroppedareadetailstocalculatetheimpactofproductiveland(DataTable fieldData) throws InterruptedException {
        List<List<String>> data = fieldData.asLists();
        activateEachService.addFilterDataForBiodiversity(data.get(1).get(0), data.get(1).get(1));
        activateEachService.addFilterDataForBiodiversity(data.get(2).get(0), data.get(2).get(1));
        activateEachService.addFilterDataForBiodiversity(data.get(3).get(0), data.get(3).get(1));
        activateEachService.addCroppingDetailsForBiodiversity(data.get(4).get(0), data.get(4).get(1));
        activateEachService.addCroppingDetailsForBiodiversity(data.get(5).get(0), data.get(5).get(1));
        activateEachService.addCroppingDetailsForBiodiversity(data.get(6).get(0), data.get(6).get(1));
    }

    @Then("Select filter with data for biodiversity")
    public void Selectfilterwithdataforbiodiversity(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        TestUtil.staticWait(8000);
        activateEachService.selectFilterForBiodiversity(data.get(1).get(0), data.get(1).get(1));
        activateEachService.selectFilterForBiodiversity(data.get(2).get(0), data.get(2).get(1));
        activateEachService.selectFilterForBiodiversity(data.get(3).get(0), data.get(3).get(1));
        activateEachService.selectFilterForBiodiversity(data.get(4).get(0), data.get(4).get(1));

    }

    @Then("verify {string} as {string} is displayed in general information")
    public void verifyFarmDetailsingeneralinformation(String farmType, String farmName ){
        activateEachService.verifyGeneralInformationForBioDiversity(farmType, farmName);
    }

    @And("verify below Crop name and crop variety and working area are displayed")
    public void verifybelowCropnameandcropvarietyandworkingareaaredisplayed(DataTable dataTable){
        List<List<String>> list = dataTable.asLists();
        activateEachService.verifyValueOfCropNameVarietyAndWorkingArea(list.get(0).get(1));
        activateEachService.verifyValueOfCropNameVarietyAndWorkingArea(list.get(1).get(1));
        activateEachService.verifyValueOfCropNameVarietyAndWorkingArea(list.get(2).get(1));
    }

    @Then("{string} the data on general information section")
    public void performActionongeneralinformationsection(String actionName){
        activateEachService.performActionOnBiodiversityGeneralInformation(actionName);
    }

    @And("update the fields with below data")
    public void updatethefieldswithrequireddata(DataTable fieldData) throws InterruptedException {
        List<List<String>> data = fieldData.asLists();
        activateEachService.addCroppingDetailsForBiodiversity(data.get(0).get(0), data.get(0).get(1));
        activateEachService.addCroppingDetailsForBiodiversity(data.get(1).get(0), data.get(1).get(1));
        activateEachService.addCroppingDetailsForBiodiversity(data.get(2).get(0), data.get(2).get(1));
    }

    @Then("no rows are displayed in general information")
    public void norowsaredisplayedingeneralinformation(){
        activateEachService.verifyNowRorsAreDisplayed();
    }





    }
