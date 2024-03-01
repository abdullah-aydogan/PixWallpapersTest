package testRunners;

import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import util.DriverFactory;

@CucumberOptions(
        features = {"src/test/java/features/homePage.feature", "src/test/java/features/detailPage.feature"},
        glue = {"stepDefinitions", "util"},
        tags = "",
        plugin = {"summary", "pretty", "html:reports/cucumberReport/reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver = DriverFactory.getDriver();
}