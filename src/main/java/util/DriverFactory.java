package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static AppiumDriver driver;
    public static Properties properties;
    public static DesiredCapabilities capabilities;

    public static AppiumDriver initializeDriver() {

        properties = ConfigReader.getProperties();
        capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "android");
        capabilities.setCapability("appPackage", "com.pashapuma.pix.wallpapers");
        capabilities.setCapability("appActivity", "com.pashapuma.pix.wallpapers.MainActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("ignoreHiddenApiPolicyError", "true");

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }

        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);

        try {
            driver.switchTo().alert().dismiss();
        }

        catch (NoAlertPresentException e) {
            System.out.println("Bildirim izni penceresi bulunamadı.");
        }

        return getDriver();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}