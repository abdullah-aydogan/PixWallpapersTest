package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {

    public AndroidDriver driver;
    public WebDriverWait wait;
    public Actions action;

    public ElementHelper(AndroidDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
    }

    // Element bulma, kontrol etme
    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public WebElement findElement(By key) {
        return presenceElement(key);
    }

    // Elemente tıklama
    public void click(By key) {
        findElement(key).click();
    }

    // Elemente değer gönderme
    public void sendKey(By key, String text) {

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        findElement(key).sendKeys(text);
    }

    // Elementin görünürlüğünü kontrol etme
    public void checkVisible(By key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }
}