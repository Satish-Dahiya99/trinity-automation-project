package utilities;

import base.BaseLib;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class Context extends BaseLib {

    private LoginPage loginPage;
    private HomePage homePage;
    private ActivateEachService activateEachService;
    private FarmSetup farmSetup;
    private EnterpriseData enterpriseData;
    private BioDiversity bioDiversity;
    private InputPage inputPage;
    private ResidueManagement residueManagement;
    private SoilData soilData;
    private FuelDryingStorage fuelDryingStorage;

    public Context() {
        setUp(FileReaderClass.readData("chromeBrowser"));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public ActivateEachService getActivateEachService() {
        if (activateEachService == null) {
            activateEachService = new ActivateEachService(driver);
        }
        return activateEachService;
    }

    public FarmSetup getFarmSetup() {
        if (farmSetup == null) {
            farmSetup = new FarmSetup(driver);
        }
        return farmSetup;
    }

    public EnterpriseData getEnterpriseData() {
        if (enterpriseData == null) {
            enterpriseData = new EnterpriseData(driver);
        }
        return enterpriseData;
    }

    public BioDiversity getBioDiversity() {
        if (bioDiversity == null) {
            bioDiversity = new BioDiversity(driver);
        }
        return bioDiversity;
    }

    public InputPage getInputPage() {
        if (inputPage == null) {
            inputPage = new InputPage(driver);
        }

        return inputPage;
    }

    public ResidueManagement getResidueManagement() {
        if (residueManagement == null) {
            residueManagement = new ResidueManagement(driver);
        }

        return residueManagement;
    }

    public SoilData getSoilData() {
        if (soilData == null) {
            soilData = new SoilData(driver);
        }

        return soilData;
    }

    public FuelDryingStorage getFuelDryingStorage() {
        if (fuelDryingStorage == null) {
            fuelDryingStorage = new FuelDryingStorage(driver);
        }
        return fuelDryingStorage;
    }
}
