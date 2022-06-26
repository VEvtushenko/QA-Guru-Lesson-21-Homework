package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static tests.browserstack.TestBase.configJson;

public class AndroidBrowserstackDriver {
    public static AndroidDriver<AndroidElement> initAndroidDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(
                new URL("http://" + configJson.get("username") + ":" + configJson.get("access_key") + "@" + configJson.get("server") + "/wd/hub"), capabilities);
        return driver;
    }
}
