package com.ahmed;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class ActionTest extends SuperTest{
    @Test void hoverElement() {
        open("https://demo.nopcommerce.com/");
        ElementsCollection menuOptions = $$("ul.top-menu.notmobile li");
        SelenideElement linkComputers = menuOptions.get(0);
        actions().moveToElement(linkComputers).build().perform();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        $(By.partialLinkText("Notebooks")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    @Test
    void dragDrop() {
        open("https://jqueryui.com/resources/demos/droppable/default.html");
//        open("file:///home/ahmed/Downloads/jQuery%20UI%20Droppable%20-%20Default%20functionality.html");

//        open("https://jqueryui.com/droppable/");
//        switchTo().frame(0);

        SelenideElement source = $("#draggable");
        SelenideElement dest = $("#droppable");

//        actions().clickAndHold(source).moveToElement(dest).release().build().perform();
        actions().dragAndDrop(source,dest).build().perform();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }

    @Test
    void contextMenu() {
        open("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        SelenideElement menuButton = $("span.context-menu-one");
        actions().contextClick(menuButton).build().perform();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));

        $("ul.context-menu-list").$$("li").stream()
                .filter(option->option.getText().contains("Copy"))
                .findFirst().get().click();

        switchTo().alert().accept();

        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
    }
}
