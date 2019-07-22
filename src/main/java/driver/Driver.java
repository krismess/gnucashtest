package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Driver {
    public static AppiumDriver driver;
    private static AppiumDriverLocalService service;
    public final static int DEFAULT_TIMEOUT = 30;

    @BeforeEach
    public void setUp() throws Exception {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException(
                    "An appium server node is not started!");
        }
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../../../Github Projects/GnucashAndroid");
        File app = new File(appDir.getCanonicalPath(), "GnucashAndroid.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "org.gnucash.android");
        capabilities.setCapability("appActivity", "org.gnucash.android.ui.account.AccountsActivity");
        driver = new AndroidDriver(service.getUrl(), capabilities);
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }

    public static AppiumDriver getDriver()
    {
        return driver;
    }

}
