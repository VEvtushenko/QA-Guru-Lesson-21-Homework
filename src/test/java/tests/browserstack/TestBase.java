package tests.browserstack;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

import static drivers.AndroidBrowserstackDriver.initAndroidDriver;
import static helpers.DriverSettings.setCapabilities;

public class TestBase {

    // Initialise the remote Webdriver using BrowserStack remote URL
    // and desired capabilities defined above
    static AndroidDriver<AndroidElement> driver;

    @BeforeEach
    void startDriver() throws MalformedURLException {
        driver = initAndroidDriver(setCapabilities());
    }

    @AfterEach
    void closeDriver() {
        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}
