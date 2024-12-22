package stepDef;

import base.BaseLib;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Logger;
import pageObjects.ActivateEachService;
import pageObjects.InputPage;
import utilities.Context;

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

}
