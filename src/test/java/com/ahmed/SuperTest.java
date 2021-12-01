package com.ahmed;

import com.ahmed.utils.PropertyReader;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class SuperTest {
    @BeforeClass
    void beforeClass() {
        String headless = PropertyReader.getProperty("headless", "false");
        System.out.println("Running in headless: " + headless);
        Configuration.headless = Boolean.parseBoolean(headless);
    }
}
