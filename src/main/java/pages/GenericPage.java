package pages;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Attachment;

import java.util.Arrays;

public class GenericPage extends AbstractPage {

    public GenericPage (AppiumDriver driver) {
        super(driver);
    }

    public void click(WebElement element, String... title) {
        StringBuilder sb = new StringBuilder();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Driver.DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
            makeScreenshot(Arrays.toString(title));
        } catch (WebDriverException e) {
            sb.append("'").append(Arrays.toString(title)).append("' ").append("STEP FAILURE");
            throw new WebDriverException(sb.toString() + "\n" + e.toString());
        }
    }

    public void clickWithoutScreenShot(WebElement element, String... title) {
        StringBuilder sb = new StringBuilder();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Driver.DEFAULT_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (WebDriverException e) {
            sb.append("'").append(Arrays.toString(title)).append("' ").append("STEP FAILURE");
            throw new WebDriverException(sb.toString() + "\n" + e.toString());
        }
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] makeScreenshot(String name) {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public void scrollToElementByText(String element) {
        try {
            ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                    ".scrollIntoView(new UiSelector().text(\"" + element + "\").instance(0))");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goBack() {
        ((AndroidDriver) driver).navigate().back();
        makeScreenshot("Go back");
    }
}
