package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static data.TestData.itemName;
import static data.TestData.verificationText;
import static io.qameta.allure.Allure.step;

@Tag("android")
@Owner("Vladimir Evtushenko")
@Feature("DemoQA")
@Link(value = "QA Guru, Lesson 21, Homework", url = "https://github.com/VEvtushenko/QA-Guru-Lesson-21-Homework")

public class WikipediaTests extends TestBase {
    @Test
    @DisplayName("Search test")
    @Description("Test search in Wikipedia app, after input text in search box we should see any results")
    @Severity(SeverityLevel.BLOCKER)
    void searchTest() {
        back();
        step("Type search text", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Check that we find something", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Open item by name")
    @Description("Test search and open item by name in Wikipedia app")
    @Severity(SeverityLevel.BLOCKER)
    void openItemTest() {
        back();
        step("Type search text", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(itemName);
        });
        step("Open item", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description")).click();
        });
        step("Verify item", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@resource-id='pcs-edit-section-title-description']")).
                    shouldHave(Condition.text(verificationText));
        });
    }

}
