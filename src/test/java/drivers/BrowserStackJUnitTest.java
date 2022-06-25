package drivers;

import io.appium.java_client.android.AndroidDriver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class BrowserStackJUnitTest {

    public static AndroidDriver driver;
    public static String username, accessKey;
    public static JSONObject config;
    public static DesiredCapabilities capabilities;
    @BeforeAll
    public static void browserStackJUnitTest() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        config = (JSONObject) parser.parse(new FileReader("src/test/resources/com/browserstack/run_first_test/first.conf.json"));
        username = (String) config.get("username");
        accessKey = (String) config.get("access_key");

        JSONArray env = (JSONArray) config.get("environments");
        List<String> envMap = (List<String>) env.get(0);
        capabilities.setCapability(envMap.get(0), envMap.get(1));
        envMap = (List<String>) env.get(1);
        capabilities.setCapability(envMap.get(0), envMap.get(1));
        driver = new AndroidDriver(new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), capabilities);
    }
}
