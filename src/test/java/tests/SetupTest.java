package tests;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static steps.AccountsSteps.checkAccountsListIsEmpty;
import static steps.AccountsSteps.checkDefaultAccountsList;
import static steps.SetupSteps.*;

public class SetupTest extends Driver{

    private AppiumDriver driver;

    public SetupTest() {
        this.driver = Driver.getDriver();
    }


    @Test
    @DisplayName("Test for setting up Gnucash app without default accounts")
    @Feature("Gnucash app for Android")
    @Story("Setup Gnucash without default accounts")
    public void setUpGnucash() {
        checkWelcomePage();
        chooseCurrency("EUR");
        chooseAccountSetup("custom");
        disableFeedback();
        goToNextPage();
        closeMessage();
        checkAccountsListIsEmpty();
    }

    @Test
    @DisplayName("Test for setting up Gnucash app with default accounts")
    @Feature("Gnucash app for Android")
    @Story("Setup Gnucash with default accounts")
    public void setUpGnucashDefault() {
        checkWelcomePage();
        chooseCurrency("USD");
        chooseAccountSetup("default");
        disableFeedback();
        goToNextPage();
        closeMessage();
        checkDefaultAccountsList();
    }


}
