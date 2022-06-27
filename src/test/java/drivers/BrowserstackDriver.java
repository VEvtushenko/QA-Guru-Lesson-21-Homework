package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConnection;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

//        mutableCapabilities.setCapability("browserstack.user", BrowserstackConnection.config.username());
//        mutableCapabilities.setCapability("browserstack.key", BrowserstackConnection.config.access_key());

        mutableCapabilities.setCapability("app", BrowserstackConnection.config.app());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", BrowserstackConnection.config.device());
        mutableCapabilities.setCapability("os_version", BrowserstackConnection.config.os_version());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", BrowserstackConnection.config.project());
        mutableCapabilities.setCapability("build", BrowserstackConnection.config.build());
        mutableCapabilities.setCapability("name", BrowserstackConnection.config.test_name());

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://" +
                    BrowserstackConnection.config.username() + ":" +
                    BrowserstackConnection.config.access_key() + "@" +
                    BrowserstackConnection.config.server() +
                    "/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
