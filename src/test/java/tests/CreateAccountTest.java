package tests;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static steps.AccountsSteps.*;

public class CreateAccountTest  extends Driver{
    private AppiumDriver driver;

    public CreateAccountTest() {
        this.driver = Driver.getDriver();
    }

    @Test
    @DisplayName("Create accounts from scratch")
    @Feature("Gnucash app for Android")
    @Story("Create new account")
    public void createAccount(){
        SetupTest setup = new SetupTest();
        setup.setUpGnucash();
        createAccountButton();
        inputAccountName();
        chooseAccountType();
        inputAccountDescription();
        checkPlaceholderAccount();
        save();
        checkAccountsList();
    }

    @Test
    @DisplayName("Create transaction")
    @Feature("Gnucash app for Android")
    @Story("Create new transaction")
    public void createTransaction(){
        SetupTest setup = new SetupTest();
        setup.setUpGnucashDefault();
        openEquityAccount();
        clickOnCreateTransactionButton();
        inputTransactionName();
        setTransactionSum();
        chooseAccountTransferTo();
        inputTransactionDescription();
        save();
        checkTransaction();


    }
}
