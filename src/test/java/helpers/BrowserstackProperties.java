package helpers;

import config.BrowserstackConnection;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserstackProperties {

    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(BrowserstackConnection.config.username(), BrowserstackConnection.config.access_key())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }

    public static String sessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

}
