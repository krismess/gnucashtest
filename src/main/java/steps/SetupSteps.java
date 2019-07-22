package steps;

import driver.Driver;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.SetupPage;

import static driver.Driver.getDriver;

public class SetupSteps {
    private Driver driver = new Driver();
    private static SetupPage page = new SetupPage(getDriver());

    @Step("Check welcome page")
    public static void checkWelcomePage() {
        Assertions.assertTrue(page.getTitle().getText().contains("Welcome"));
        goToNextPage();
    }

    @Step("Go to the next page")
    public static void goToNextPage() {
        page.click(page.getNextButton(), "Click on 'Next' button");
    }

    @Step("Choose currence {0}")
    public static void chooseCurrency(String currency) {
        page.click(page.getCurrency(currency), "Choose currency " + currency);
        goToNextPage();
    }

    @Step("Choose account setup = {0}")
    public static void chooseAccountSetup(String accountType) {
        page.click(page.getAccountSettings(accountType), "Choose account setup " + accountType);
        goToNextPage();
    }

    @Step("Disable crash reports")
    public static void disableFeedback() {
        page.click(page.getDisableFeedback(),"Disable crash reports");
        goToNextPage();
    }

    @Step("Close message")
    public static void closeMessage() {
        page.click(page.getDismissButton(), "Close update message");
    }





}
