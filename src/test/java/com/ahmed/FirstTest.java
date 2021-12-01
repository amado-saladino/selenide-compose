package com.ahmed;

import com.codeborne.selenide.*;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FirstTest extends SuperTest {
    @Test(priority = 1)
    void searchGoogle() {
//        Configuration.browser = "firefox";
//        System.setProperty("selenide.browser", "firefox");
//        System.setProperty("chromeoptions.prefs","intl.accept_languages=de");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", ImmutableMap.of("intl.accept_languages", "en_UK"));
        Configuration.browserCapabilities = options;

        open("https://www.google.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $(By.name("q")).setValue("Create pod in kubernetes").pressEnter();
        System.out.println(title());

        SelenideElement results = $(By.id("result-stats"));
        results.shouldBe(visible);
        String txt_result = results.text();
        System.out.println(txt_result);
        ElementsCollection result_set = $$(By.cssSelector("div.g h3"));
        result_set.stream().map(e->e.text()).forEach(System.out::println);
        result_set.should(CollectionCondition.sizeGreaterThan(5));
        //Assert.assertTrue(result_set.size() > 5);
    }

    @Test(priority = 2)
    void duckGo() {
        open("https://duckduckgo.com/");
        $("#search_form_input_homepage").setValue("how to install podman ubuntu").pressEnter();
    }
}
