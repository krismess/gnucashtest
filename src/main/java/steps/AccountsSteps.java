package steps;

import driver.Driver;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.AccountsPage;

public class AccountsSteps {

    private static AccountsPage page = new AccountsPage(Driver.getDriver());
    private static final String ACCOUNT_NAME = "Test account";
    private static final String ACCOUNT_DESCRIPTION = "My credit card account";
    private static final String TRANSACTION_NAME = "Test transaction";
    private static final String TRANSACTION_SUM = "100";
    private static final String TRANSACTION_DESCRIPTION = "My new transaction";
    private static final String TRANSFER_TO_ACCOUNT =  "Liabilities:Credit Card";

    @Step("Check accounts list is empty")
    public static void checkAccountsListIsEmpty() {
        Assertions.assertTrue(page.getEmptyAccountsPage().getText().contains("No accounts to display"));
    }

    @Step("Check accounts list is NOT empty")
    public static void checkDefaultAccountsList() {
        Assertions.assertTrue(page.getAccountName().getText().contains("Assets"));
    }

    @Step("Check accounts list has account")
    public static void checkAccountsList() {
        Assertions.assertTrue(page.getAccountName().getText().contains(ACCOUNT_NAME));
    }

    @Step("Click on create account button")
    public static void createAccountButton() {
        page.click(page.getCreateAccountButton(), "Click on create account button");
    }

    @Step("Input account name")
    public static void inputAccountName() {
        page.getInputAccountName().setValue(ACCOUNT_NAME);
        Driver.getDriver().hideKeyboard();
    }

    @Step("Choose account type")
    public static void chooseAccountType() {
        page.click(page.getAccountType(), "click on account type field");
        page.click(page.getCreditCardAccount(), "choose CREDIT CARD account");
    }

    @Step("Input account description")
    public static void inputAccountDescription() {
        page.getAccountDescription().setValue(ACCOUNT_DESCRIPTION);
        Driver.getDriver().hideKeyboard();
    }

    @Step("Check placeholder account cheackbox")
    public static void checkPlaceholderAccount() {
        page.click(page.getPlaceholderAccount(), "click in Placeholder account checkbox");
    }

    @Step("Save")
    public static void save() {
        page.click(page.getSaveButton(), "click on SAVE button");
    }

    @Step("Open Equity account")
    public static void openEquityAccount() {
        page.click(page.getEquityAccount(), "open equity account");
    }

    @Step("Create transaction button")
    public static void clickOnCreateTransactionButton() {
        page.click(page.getCreateTransactionButton(), "Click on create transaction Button");
    }

    @Step("Input transaction name")
    public static void inputTransactionName() {
        page.getInputTransactionName().setValue(TRANSACTION_NAME);
        Driver.getDriver().hideKeyboard();
    }

    @Step("Set transaction sum")
    public static void setTransactionSum() {
        page.getInputTransactionAmount().setValue(TRANSACTION_SUM);
    }

    @Step("Choose account type")
    public static void chooseAccountTransferTo() {
        page.click(page.getAccountToTransfer(), "click on trasfer account field");
        page.scrollToElementByText(TRANSFER_TO_ACCOUNT);
        page.click(page.getLiabilitiesCreditCard(), "choose Liabilities credit card account");
    }

    @Step("Input transaction description")
    public static void inputTransactionDescription() {
        page.getTransactionDescription().setValue(TRANSACTION_DESCRIPTION);
        Driver.getDriver().hideKeyboard();
    }

    @Step("Check transaction")
    public static void checkTransaction() {
        page.goBack();
        Assertions.assertTrue(page.getEquityAccountSum().getText().equals("-$100.00"));
        Assertions.assertTrue(page.getLiabilitiesAccountSum().getText().equals("$100.00"));



    }


}
