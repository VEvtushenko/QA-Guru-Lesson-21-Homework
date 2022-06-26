package helpers;

import config.BrowserstackConnection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DriverSettings {

    static final File jsonConfigFile = new File("src/test/resources/config/json/first.conf.json");

    public static DesiredCapabilities setCapabilities() throws IOException, ParseException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability("browserstack.user", BrowserstackConnection.config.username());
//        capabilities.setCapability("browserstack.key",BrowserstackConnection.config.access_key());

        JSONParser parser = new JSONParser();
        JSONObject configJson = (JSONObject) parser.parse(new FileReader(jsonConfigFile));

        capabilities.setCapability("app", configJson.get("capabilities.app"));

        // Specify device and os_version for testing
        capabilities.setCapability("device", configJson.get("environments.device"));
        capabilities.setCapability("os_version", configJson.get("environments.os_version"));

        // Set other BrowserStack capabilities
        capabilities.setCapability("project", configJson.get("capabilities.project"));
        capabilities.setCapability("build", configJson.get("capabilities.build"));
        capabilities.setCapability("name", configJson.get("capabilities.name"));
        return capabilities;
    }
}
