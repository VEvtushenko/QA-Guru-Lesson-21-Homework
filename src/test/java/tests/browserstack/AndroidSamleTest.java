package tests.browserstack;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static drivers.BrowserStackJUnitTest.driver;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class AndroidSamleTest {

        @Test
//        @MethodSource("devices")
        void test(int taskId) throws IOException, InterruptedException {
//            createConnection(taskId);
            Duration duration = Duration.ofSeconds(30);
            AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, duration).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
            searchElement.click();

            AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, duration).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
            insertTextElement.sendKeys("BrowserStack");

            Thread.sleep(5000);

            List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
            assertTrue(allProductsName.size() > 0);
        }
}

