package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static AppiumDriver driver;
    public static Properties properties;
    public static DesiredCapabilities capabilities;

    public static AppiumDriver initializeDriver(String browser) {

        properties = ConfigReader.getProperties();
        capabilities = new DesiredCapabilities();

        if(browser.equals("Android")) {

            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "emulator-5554");
            capabilities.setCapability("appPackage", "com.pashapuma.pix.wallpapers");
            capabilities.setCapability("appActivity", "com.pashapuma.pix.wallpapers.MainActivity");
        }

        try {
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        }

        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);

        return getDriver();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}