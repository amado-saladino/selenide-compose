package com.ahmed;

import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class CollectionTest extends SuperTest {
    @Test
    void collectLinks() {
        open("http://the-internet.herokuapp.com/");
        ElementsCollection links = $("ul").$$("a");
        System.out.println(links.size());
        System.out.println("All links:");
        links.stream().map(elem->elem.getText()).forEach(System.out::println);

        System.out.println("last 3 links:");
        links.last(3).stream().map(elem->elem.getText()).forEach(System.out::println);

        System.out.println("First 3 links");
        links.first(3).texts().forEach(e-> System.out.println(e));
    }
}
