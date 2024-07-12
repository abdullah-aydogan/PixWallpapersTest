package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.NoAlertPresentException;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

// Appium driver'ın çalışabilmesi için gereken DriverFactory sınıfı

public class DriverFactory {

    public static AndroidDriver driver;
    public static Properties properties;
    public static UiAutomator2Options options;

    public static AndroidDriver initializeDriver() {

        properties = ConfigReader.getProperties();
        options = new UiAutomator2Options();

        // Testlerin emulator veya gerçek cihazda çalışabilmesi için gereken capability tanımlamaları

        options.setCapability("platformName", "Android");
        options.setCapability("deviceName", "android");
        options.setCapability("appPackage", "com.pashapuma.pix.wallpapers");
        options.setCapability("appActivity", "com.pashapuma.pix.wallpapers.MainActivity");

        try {
            driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        }

        catch (URISyntaxException | MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Bekleme süresi tanımlaması
        int impWait = Integer.parseInt(properties.getProperty("implicitlyWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impWait));

        // Uygulamada çıkan alert pencerelerini kapatmak için gereken kodlamalar
        try {
            driver.switchTo().alert().dismiss();
        }

        catch (NoAlertPresentException e) {
            System.out.println("Bildirim izni penceresi bulunamadı.");
        }

        return getDriver();
    }

    public static AndroidDriver getDriver() {
        return driver;
    }
}