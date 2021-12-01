package com.ahmed;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class MultiwindowTest {
    @Test
    void closeBrowser() {
        open("https://opensource-demo.orangehrmlive.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();

        System.out.println(title());

        $("img[alt*=youtube]").click();
        switchTo().window(1);
        System.out.println(title());
        System.out.println(WebDriverRunner.url());
        closeWindow();
        switchTo().window(0);
        System.out.println(title());
        closeWebDriver();
    }
}
