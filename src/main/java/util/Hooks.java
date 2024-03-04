package util;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.Properties;

public class Hooks {

    public AppiumDriver driver;
    public Properties properties;

    // Test öncesinde properties ve driver tanımlamaları yapılır
    @Before
    public void before() {

        properties = ConfigReader.initializeProperties();
        driver = DriverFactory.initializeDriver();
    }

    // Test sonrası driver kapatılır
    @After
    public void after() {
        driver.quit();
    }
}