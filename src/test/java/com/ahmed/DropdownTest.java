package com.ahmed;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DropdownTest extends SuperTest {
    @Test
    void selectOption() {
        open("http://the-internet.herokuapp.com/dropdown");
        SelenideElement select = $("#dropdown");
        select.selectOption("Option 1");
        System.out.println("Selected option: " + select.getSelectedOption().getText());

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        selectText("option 2");
        System.out.println("Selected option: " + select.getSelectedOption().getText());
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    private void selectText(String text) {
        ElementsCollection options = $$("#dropdown option");
        options.stream().filter(option->option.getText().equalsIgnoreCase(text)).findFirst().get().click();
    }
}
