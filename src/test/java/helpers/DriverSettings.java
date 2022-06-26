package helpers;

import config.BrowserstackConnection;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {


    public static DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("app", BrowserstackConnection.config.app());

        // Specify device and os_version for testing
        capabilities.setCapability("device", BrowserstackConnection.config.device());
        capabilities.setCapability("os_version", BrowserstackConnection.config.os_version());

        // Set other BrowserStack capabilities
        capabilities.setCapability("project", BrowserstackConnection.config.project());
        capabilities.setCapability("build", BrowserstackConnection.config.build());
        capabilities.setCapability("name", BrowserstackConnection.config.name());
        return capabilities;
    }
}
