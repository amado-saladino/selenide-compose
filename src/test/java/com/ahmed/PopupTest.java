package com.ahmed;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class PopupTest extends SuperTest{
    @Test
    void clickAlert() {
        open("http://the-internet.herokuapp.com/javascript_alerts");
        ElementsCollection buttons = $$("button");

        //JS alert
        SelenideElement buttonAlert = buttons.get(0);
        buttonAlert.click();
        Alert alert = switchTo().alert();
        System.out.println(alert.getText());
        SelenideElement result = $(By.id("result"));
        System.out.println(result.text());
        result.should(Condition.have(Condition.text("successfully clicked an alert")));

        //JS Confirm
        SelenideElement buttonConfirm = buttons.get(1);
        buttonConfirm.click();
        Alert alert1 = switchTo().alert();
        System.out.println(alert1.getText());

        //dismiss
        alert1.dismiss();
        System.out.println(result.getText());
        result.should(Condition.have(Condition.text("You clicked: Cancel")));

        //accept
        buttonConfirm.click();
        alert1.accept();
        System.out.println(result.getText());
        result.should(Condition.have(Condition.text("You clicked: Ok")));

        //prompt
        SelenideElement buttonPrompt = buttons.get(2);
        buttonPrompt.click();
        Alert alert2 = switchTo().alert();
        System.out.println(alert2.getText());
        String input = "Hello there";
        alert2.sendKeys(input);
        alert2.accept();

        System.out.println(result.getText());
        result.should(Condition.have(Condition.text(input)));
    }
}
