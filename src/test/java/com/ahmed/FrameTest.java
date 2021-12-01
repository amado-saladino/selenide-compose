package com.ahmed;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class FrameTest extends SuperTest {
    @Test
    void typePost() {
        open("http://the-internet.herokuapp.com/iframe");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        SelenideElement header = $("h3");
        System.out.println(header.getText());

        $("button[title=Bold]").click();
        switchTo().frame(0);
        $("p").setValue("Hello there");

        switchTo().defaultContent();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        System.out.println($("#page-footer div[style]").getText());
    }
}
