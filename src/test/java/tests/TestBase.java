package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackDriver;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.BrowserstackProperties.sessionId;
import static io.qameta.allure.Allure.step;

public class TestBase {

    @BeforeAll
    public static void setup() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
    }
    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());

        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();

        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();

        Attachments.video(sessionId);

        step("Close driver", Selenide::closeWebDriver);

    }

}
