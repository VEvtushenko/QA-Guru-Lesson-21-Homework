package tests;

import io.appium.java_client.android.AndroidDriver;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class BrowserStackJUnitTest {

    public static AndroidDriver driver;
    public static String username, accessKey;
    public static JSONObject config;
    public static DesiredCapabilities capabilities;

    public static void browserStackJUnitTest() throws IOException, ParseException {
    JSONParser parser = new JSONParser();
    config = (JSONObject) parser.parse(new FileReader("src/test/resources/com/browserstack/run_first_test/first.conf.json"));
    driver = new AndroidDriver(new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), capabilities);
    }
}
