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

    @Then("click on add crop buttonn")
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

    @Then("click on add records buttonn")
    public void clickonaddrecordsbuttonn() throws InterruptedException {
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
       // activateEachService.selectFilterForBiodiversity(data.get(4).get(0), data.get(4).get(1));

    }

    @Then("verify {string} as {string} is displayed in general information")
    public void verifyFarmDetailsingeneralinformation(String farmType, String farmName ){
        activateEachService.verifyGeneralInformationForBioDiversity(farmType, farmName);
    }

    @And("verify below Crop name and crop variety and working area are displayed in first row")
    public void verifybelowCropnameandcropvarietyandworkingareaaredisplayed(DataTable dataTable) throws InterruptedException {
        TestUtil.staticWait(4000);
            List<List<String>> list = dataTable.asLists();
            activateEachService.verifyValueOfCropNameVarietyAndWorkingAreaInFirstRow(list.get(0).get(1));
            activateEachService.verifyValueOfCropNameVarietyAndWorkingAreaInFirstRow(list.get(1).get(1));
            activateEachService.verifyValueOfCropNameVarietyAndWorkingAreaInFirstRow(list.get(2).get(1));
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

    @And("click bulk edit button")
    public void clickbulkeditbutton(){
        activateEachService.clickBulkEditButton();
    }

    @Then("select the filters of the records on replicate page")
    public void selectthefiltersoftherecordsonreplicatepage(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        activateEachService.selectFilterOnReplicateRecordsPage(data.get(0).get(0), data.get(0).get(1));
        activateEachService.selectFilterOnReplicateRecordsPage(data.get(1).get(0), data.get(1).get(1));
        activateEachService.selectFilterOnReplicateRecordsPage(data.get(2).get(0), data.get(2).get(1));
    }

    @And("select all checkbox for field")
    public void selectallcheckboxforfield(){
        activateEachService.setSelectAllCheckboxforFieldOnReplicatePage();
    }

    @Then("click on {} button")
    public void clickbutton(String button) throws InterruptedException {
        activateEachService.clickOnButton(button);
    }

    @Then("select all checkbox for general information")
    public void selectallcheckboxforgeneralinformation() throws InterruptedException {
        activateEachService.clickGeneralInformationSelectAllCheckBox();
    }

    @And("enter required cropping data for edit multiple")
    public void enterrequiredcroppingdataforeditmultiple(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        activateEachService.addCroppingDetailsForBiodiversity(data.get(0).get(0), data.get(0).get(1));
        activateEachService.addCroppingDetailsForBiodiversity(data.get(1).get(0), data.get(1).get(1));
        activateEachService.addCroppingDetailsForBiodiversity(data.get(2).get(0), data.get(2).get(1));

    }

    @And("verify below Crop name and crop variety and working area are displayed in second row")
    public void verifybelowCropnameandcropvarietyandworkingareaaredisplayedInSecondRow(DataTable dataTable) throws InterruptedException {
        try{
            TestUtil.staticWait(4000);
            List<List<String>> list = dataTable.asLists();
            activateEachService.verifyValueOfCropNameVarietyAndWorkingAreaInSecondRow(list.get(0).get(1));
            activateEachService.verifyValueOfCropNameVarietyAndWorkingAreaInSecondRow(list.get(1).get(1));
            activateEachService.verifyValueOfCropNameVarietyAndWorkingAreaInSecondRow(list.get(2).get(1));
        } catch (Exception e) {
            TestUtil.staticWait(4000);
            List<List<String>> list = dataTable.asLists();
            activateEachService.verifyValueOfCropNameVarietyAndWorkingAreaInSecondRow(list.get(0).get(1));
        }

    }

    @Then("Select filter with data for Management practices")
    public void SelectfilterwithdataforManagementPractices(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        TestUtil.staticWait(5000);
        activateEachService.selectFilterForBiodiversity(data.get(0).get(0), data.get(0).get(1));
        activateEachService.selectFilterForBiodiversity(data.get(1).get(0), data.get(1).get(1));
        activateEachService.selectFilterForBiodiversity(data.get(2).get(0), data.get(2).get(1));
    }

    @And("click management practice {string} action button")
    public void clickmanagementpracticeactionbutton(String buttonName){
        activateEachService.clickOnManagementPracticeActionButton(buttonName);
    }

    @Then("select Apply to filter")
    public void selectApplytofilter(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        activateEachService.addFilterDataForBiodiversity(data.get(0).get(0), data.get(0).get(1));
        activateEachService.addFilterDataForBiodiversity(data.get(1).get(0), data.get(1).get(1));
        activateEachService.addFilterDataForBiodiversity(data.get(2).get(0), data.get(2).get(1));

    }

    @And("Select filter with data for Operational data")
    public void SelectfilterwithdatatoaddcropForOperationalData(DataTable filterData) throws InterruptedException {
        List<List<String>> data = filterData.asLists();
        activateEachService.selectFilterForOperationalData(data.get(1).get(0), data.get(1).get(1));
        activateEachService.selectFilterForOperationalData(data.get(2).get(0), data.get(2).get(1));

    }

    @Then("select operational data year as {string}")
    public void selectoperationaldatayear(String year){
        activateEachService.clickOperationalDataYear(year);
    }

    @And("add required field for Operational Data")
    public void addrequiredfieldforOperationalData(DataTable selectData) throws InterruptedException {
        List<List<String>> data = selectData.asLists();
        activateEachService.selectRequiredDataToAddCrop(data.get(1).get(0), data.get(1).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(2).get(0), data.get(2).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(3).get(0), data.get(3).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(4).get(0), data.get(4).get(1));
        activateEachService.addProductforOperationalFlow(data.get(5).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(6).get(0), data.get(6).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(7).get(0), data.get(7).get(1));
        activateEachService.setDate(data.get(8).get(0), data.get(8).get(1));
    }

    @Then("verify the product name displayed as {string}")
    public void verifyproductnamedisplayed(String prodName){
        activateEachService.verifyOperationDataProductName(prodName);
    }

    @And("add product in required data section")
    public void addproductinrequireddatasection(DataTable dataTable){
        List<List<String>> list = dataTable.asLists();
        activateEachService.addProductforOperationalFlow(list.get(0).get(1));

    }

    @And("add required field for Operational Data for Crop level")
    public void addrequiredfieldforOperationalDataForCropLevel(DataTable selectData) throws InterruptedException {
        List<List<String>> data = selectData.asLists();
        activateEachService.selectRequiredDataToAddCrop(data.get(1).get(0), data.get(1).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(2).get(0), data.get(2).get(1));
        activateEachService.addProductforOperationalFlow(data.get(3).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(4).get(0), data.get(4).get(1));
        activateEachService.selectRequiredDataToAddCrop(data.get(5).get(0), data.get(5).get(1));
        activateEachService.setDate(data.get(6).get(0), data.get(6).get(1));
    }

    @And("select {string} checkbox to replicate records")
    public void selectcheckboxtoreplicaterecords(String dataField) throws InterruptedException {
        activateEachService.selectDataToReplicate(dataField);
    }

    @Then("select first crop to replicate records")
    public void selectfirstcroptoreplicaterecords(){
        activateEachService.selectCropYearToReplicateCropLevelData();
    }





    }
