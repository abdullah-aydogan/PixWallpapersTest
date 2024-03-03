package testRunners;

import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import util.DriverFactory;

@CucumberOptions(
        features = {"src/test/java/features/homePage.feature"},
        glue = {"stepDefinitions", "util"},
        plugin = {"summary", "pretty", "html:reports/cucumberReport/homePageReport.html"}
)
public class HomePageRunner extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver = DriverFactory.getDriver();
}