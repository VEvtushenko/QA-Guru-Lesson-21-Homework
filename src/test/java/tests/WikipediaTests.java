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
import static data.TestData.item_name;
import static data.TestData.verification_text;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class WikipediaTests extends TestBase {
    @Test
    @Owner("Vladimir Evtushenko")
    @Description("Test search in Wikipedia app, after input text in search box we should see any results")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("DemoQA")
    @Link(value = "QA Guru, Lesson 21, Homework", url = "https://github.com/VEvtushenko/QA-Guru-Lesson-21-Homework")
    @DisplayName("Search test")
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
    @Owner("Vladimir Evtushenko")
    @Description("Test search and open item by name in Wikipedia app")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("DemoQA")
    @Link(value = "QA Guru, Lesson 21, Homework", url = "https://github.com/VEvtushenko/QA-Guru-Lesson-21-Homework")
    @DisplayName("Open item by name")
    void openItemTest() {
        back();
        step("Type search text", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(item_name);
        });
        step("Open item", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description")).click();
        });
        step("Verify item", () -> {
            $(AppiumBy.xpath("//android.widget.TextView[@resource-id='pcs-edit-section-title-description']")).
                    shouldHave(Condition.text(verification_text));
        });
    }

}
