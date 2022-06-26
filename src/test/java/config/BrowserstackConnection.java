package config;

import org.aeonbits.owner.ConfigFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BrowserstackConnection {

    public static Configuration config = ConfigFactory.create(Configuration.class, System.getProperties());

    public static DesiredCapabilities setCapabilities(File jsonConfigFile) throws IOException, ParseException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        JSONParser parser = new JSONParser();
        JSONObject configJson = (JSONObject) parser.parse(new FileReader(jsonConfigFile));

        capabilities.setCapability("app", configJson.get("capabilities.app"));

        // Specify device and os_version for testing
        capabilities.setCapability("device", configJson.get("capabilities.device"));
        capabilities.setCapability("os_version", configJson.get("capabilities.os_version"));

        // Set other BrowserStack capabilities
        capabilities.setCapability("project", configJson.get("capabilities.project"));
        capabilities.setCapability("build", configJson.get("capabilities.build"));
        capabilities.setCapability("name", configJson.get("capabilities.name"));
        return capabilities;
    }

}
