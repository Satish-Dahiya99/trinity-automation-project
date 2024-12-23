package stepDef;

import base.BaseLib;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.ActivateEachService;
import pageObjects.InputPage;
import utilities.Context;

import java.util.List;

public class InputPageStep {

    Logger log = BaseLib.getLog(this.getClass().getName());
    Context context;
    InputPage inputPage;
    ActivateEachService activateEachService;

    public InputPageStep(Context context){
        this.context = context;
        inputPage = this.context.getInputPage();
        activateEachService = this.context.getActivateEachService();
    }

    @And("click on setup button for {string}")
    public void clickOnSetupButtonFor(String inputFieldName){
        inputPage.clickSetupButton(inputFieldName);
    }

    @Then("select the year as {string}")
    public void selectTheYearAs (String yearInput) throws InterruptedException {
        inputPage.clickOperationalDataYear(yearInput);
    }

    @And("click edit button for product {string}")
    public void clickEditButtonForProduct(String productName){
        inputPage.selectEditButtonForProduct(productName);
    }

    @Then("add required data for field {string} as {string} for crop protection")
    public void addRequiredDataForFieldForCropProtection(String fieldName, String value) throws InterruptedException {
        inputPage.selectRequiredDataToAddCrop(fieldName, value);
    }

    @And("verify the crop protection product details for product {string} as value {string}")
    public void verifyCropProtectionProductDetails(String productName, String value){
        inputPage.verifyProductDetails(productName, value);
    }

    @Then("add data for form of fertilizer")
    public void addDataForFormOfFertilizer(DataTable selectData) throws InterruptedException {
        List<List<String>> data = selectData.asLists();
        inputPage.selectRequiredDataToAddCrop(data.get(1).get(0), data.get(1).get(1));
        inputPage.selectRequiredDataToAddCrop(data.get(2).get(0), data.get(2).get(1));
        inputPage.selectRequiredDataToAddCrop(data.get(3).get(0), data.get(3).get(1));
        inputPage.selectRequiredDataToAddCrop(data.get(4).get(0), data.get(4).get(1));
    }

    @And("verify the form of fertilizer data in product details page")
    public void theFormOfFertilizerDataInProductDetailsPage(DataTable selectData){
        List<List<String>> data = selectData.asLists();
        inputPage.verifyProductDetails(data.get(1).get(0), data.get(1).get(1));
        inputPage.verifyProductDetails(data.get(2).get(0), data.get(2).get(1));
        inputPage.verifyProductDetails(data.get(3).get(0), data.get(3).get(1));
        inputPage.verifyProductDetails(data.get(4).get(0), data.get(4).get(1));
    }

    @Then("add data for organic fertilizer")
    public void adDataForOrganicFertilizer(DataTable selectData) throws InterruptedException {
        List<List<String>> data = selectData.asLists();
        inputPage.selectRequiredDataToAddCrop(data.get(1).get(0), data.get(1).get(1));
        inputPage.selectRequiredDataToAddCrop(data.get(2).get(0), data.get(2).get(1));
    }

    @And("verify the Nutrition Organic fertilizer data in product details page")
    public void verifyTheNutritionOrganicFertilizerDataInProductDetailsPage(DataTable selectData){
        List<List<String>> data = selectData.asLists();
        inputPage.verifyProductDetails(data.get(1).get(0), data.get(1).get(1));
        inputPage.verifyProductDetails(data.get(2).get(0), data.get(2).get(1));
    }


}
