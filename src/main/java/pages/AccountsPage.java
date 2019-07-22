package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccountsPage extends GenericPage {

    public AccountsPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "org.gnucash.android:id/empty_view")
    private MobileElement emptyAccountsPage;

    @AndroidFindBy(id = "org.gnucash.android:id/primary_text")
    private MobileElement accountName;

    @AndroidFindBy(id = "org.gnucash.android:id/fab_create_account")
    private MobileElement createAccountButton;

    @AndroidFindBy(id = "org.gnucash.android:id/input_account_name")
    private MobileElement inputAccountName;

    @AndroidFindBy(id = "org.gnucash.android:id/input_account_type_spinner")
    private MobileElement accountType;

    @AndroidFindBy(id = "org.gnucash.android:id/input_color_picker")
    private MobileElement accountColor;

    @AndroidFindBy(id = "org.gnucash.android:id/input_account_description")
    private MobileElement accountDescription;

    @AndroidFindBy(id = "org.gnucash.android:id/checkbox_placeholder_account")
    private MobileElement placeholderAccount;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'CREDIT CARD']")
    private MobileElement creditCardAccount;

    @AndroidFindBy(id = "org.gnucash.android:id/menu_save")
    private MobileElement saveButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Liabilities']/../..")
    private MobileElement liabilitiesAccount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Liabilities']/../../android.widget.TextView")
    private MobileElement liabilitiesAccountSum;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Equity']/../..")
    private MobileElement equityAccount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Equity']/../../android.widget.TextView")
    private MobileElement equityAccountSum;

    @AndroidFindBy(id = "org.gnucash.android:id/create_transaction")
    private MobileElement createTransactionButton;

    @AndroidFindBy(id = "org.gnucash.android:id/input_transaction_name")
    private MobileElement inputTransactionName;

    @AndroidFindBy(id = "org.gnucash.android:id/input_transaction_amount")
    private MobileElement inputTransactionAmount;

    @AndroidFindBy(id = "org.gnucash.android:id/input_transfer_account_spinner")
    private MobileElement accountToTransfer;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'Liabilities:Credit Card']")
    private MobileElement liabilitiesCreditCard;

    @AndroidFindBy(id = "org.gnucash.android:id/input_description")
    private MobileElement transactionDescription;


    public MobileElement getEmptyAccountsPage() {
        return emptyAccountsPage;
    }

    public MobileElement getAccountName() {
        return accountName;
    }

    public MobileElement getCreateAccountButton() {
        return createAccountButton;
    }

    public MobileElement getInputAccountName() {
        return inputAccountName;
    }

    public MobileElement getAccountType() {
        return accountType;
    }

    public MobileElement getAccountColor() {
        return accountColor;
    }

    public MobileElement getAccountDescription() {
        return accountDescription;
    }

    public MobileElement getPlaceholderAccount() {
        return placeholderAccount;
    }

    public MobileElement getCreditCardAccount() {
        return creditCardAccount;
    }

    public MobileElement getSaveButton(){
        return saveButton;
    }

    public MobileElement getLiabilitiesAccount(){
        return liabilitiesAccount;
    }

    public MobileElement getLiabilitiesAccountSum() {
        return liabilitiesAccountSum;
    }

    public MobileElement getEquityAccount() {
        return equityAccount;
    }

    public MobileElement getEquityAccountSum() {
        return equityAccountSum;
    }

    public MobileElement getCreateTransactionButton() {
        return createTransactionButton;
    }

    public MobileElement getInputTransactionName() {
        return inputTransactionName;
    }

    public MobileElement getInputTransactionAmount() {
        return inputTransactionAmount;
    }

    public MobileElement getAccountToTransfer() {
        return accountToTransfer;
    }

    public MobileElement getLiabilitiesCreditCard() {
        return liabilitiesCreditCard;
    }

    public MobileElement getTransactionDescription() {
        return transactionDescription;
    }
}
