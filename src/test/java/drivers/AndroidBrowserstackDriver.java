package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import config.BrowserstackConnection;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidBrowserstackDriver {
    public static AndroidDriver<AndroidElement> initAndroidDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        return new AndroidDriver<>(
                new URL("http://" +
                        BrowserstackConnection.config.username() + ":" +
                        BrowserstackConnection.config.access_key() + "@" +
                        BrowserstackConnection.config.server() +
                        "/wd/hub"), capabilities);
    }
}
