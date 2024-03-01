package util;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.Reporter;

import java.util.Properties;

public class Hooks {

    public AppiumDriver driver;
    public Properties properties;

    @Before
    public void before() {

        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        properties = ConfigReader.initializeProperties();
        driver = DriverFactory.initializeDriver(browser);
    }

    @After
    public void after() {
        driver.quit();
    }
}