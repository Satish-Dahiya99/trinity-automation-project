package pageObjects;

import base.BaseLib;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.TestUtil;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class InputPage extends BasePage {


    @FindBy(xpath = "//table[contains(@class,'opration-grid')]//td[1]")
    List<WebElement> productNameInTable;

    @FindBy(xpath = "(//div[contains(@class,'pageInputBox')]//p[text()])[2]")
    List<WebElement> numberOfPages;

    @FindBy(xpath = "//div[contains(@class,'pageInputBox')]/following-sibling::div/button[2]")
    WebElement nextPageButton;

    String setUpButton = "//div[text()='"+dynamicText+"']/..//button";
    String inputYear = "//*[@class='nav-item']/ a[contains(text(),'"+dynamicText+"')]";
    String productEditButton = "//td[text()='"+dynamicText+"']/..//div";
    String productDetails = "//td[text()='"+dynamicText+"']/../td";
    String cropReqDataInput = "//*[text()='"+dynamicText+"']/..//input";



    Logger log = BaseLib.getLog(this.getClass().getName());

    public InputPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static int numbOfPages = 0;

    public void clickSetupButton(String inputFieldName){
        try{
            WebElement ele = prepareWebElementWithDynamicXpath(setUpButton, inputFieldName);
            TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
            scrollToElement(ele);
            ele.click();
        } catch (Exception e) {
            WebElement ele = prepareWebElementWithDynamicXpath(setUpButton, inputFieldName);
            TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
            javaScriptExecutorClick(ele);
        }
    }

    public void clickOperationalDataYear(String year) throws InterruptedException {
        WebElement ele = prepareWebElementWithDynamicXpath(inputYear, year);
        TestUtil.waitForElementClickable(driver, ele, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(2000);
        ele.click();
    }

    public String selectEditButtonForProduct(String productName){
        if (!numberOfPages.isEmpty()){
            String [] pagesNum = numberOfPages.get(0).getText().split(" ");
            numbOfPages = Integer.parseInt(pagesNum[1]);
        }else {
            numbOfPages =1;
        }
        for (int i =0; i< numbOfPages; i++){
            for (WebElement ele : productNameInTable){
                if (ele.getText().equals(productName)){
                    scrollFromElementFromGivenAmount(prepareWebElementWithDynamicXpath(productEditButton, productName));
                    javaScriptExecutorClick(prepareWebElementWithDynamicXpath(productEditButton, productName));
                    return productName+" Product Found";
                }
            }
            nextPageButton.click();
        }

        return productName+" Product not found";
    }

    public boolean getProductDetails(String productName, String value){
        List<WebElement> ele = prepareListOfWebElementsWithDynamicXpath(productDetails, productName);
        for (WebElement details : ele){
            if (details.getText().equals(value)){
                return true;
            }
        }
        return false;
    }

    public void verifyProductDetails(String productName, String value){
        Assert.assertTrue(getProductDetails(productName, value));
    }

    public void selectRequiredDataToAddCrop(String field, String data) throws InterruptedException {
        //TestUtil.waitForElementClickable(driver, selectField, Duration.of(10, ChronoUnit.SECONDS));
        TestUtil.staticWait(5000);
        //selectField.click();
        WebElement input = prepareWebElementWithDynamicXpath(cropReqDataInput, field);
        TestUtil.waitForElementClickable(driver, input, Duration.of(10, ChronoUnit.SECONDS));
        input.clear();
        input.sendKeys(data);
        TestUtil.staticWait(1000);
        input.sendKeys(Keys.RETURN);

    }
}
