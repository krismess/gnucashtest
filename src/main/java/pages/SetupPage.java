package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class SetupPage extends GenericPage{

    public SetupPage (AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "org.gnucash.android:id/btn_save")
    private MobileElement nextButton;

    @AndroidFindBy(id = "android:id/title")
    private MobileElement title;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'Create default accounts']")
    private MobileElement defaultAccounts;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'Let me handle it']")
    private MobileElement customAccounts;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text = 'Disable crash reports']")
    private MobileElement disableFeedback;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement dismissButton;



    public MobileElement getNextButton() {
        return nextButton;
    }

    public MobileElement getTitle() {
        return title;
    }

    public MobileElement getAccountSettings(String accountType) {
        switch (accountType) {
            case "custom":
                return customAccounts;
            default:
                return defaultAccounts;
        }
    }

    public MobileElement getCurrency(String currency) {
        return (MobileElement) driver.findElement(By.xpath(String.format("//android.widget.CheckedTextView[@text = '%s']", currency)));
    }

    public MobileElement getDisableFeedback() {
        return disableFeedback;
    }

    public MobileElement getDismissButton() {
        return dismissButton;
    }


}
