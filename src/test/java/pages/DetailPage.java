package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DetailPage {

    public AppiumDriver driver;
    public WebDriverWait wait;
    public ElementHelper elementHelper;

    public int imageCount = 0;

    By notificationWindow = By.id("com.android.permissioncontroller:id/grant_dialog");
    By notificationDenyButton = By.id("com.android.permissioncontroller:id/permission_deny_button");
    By homePageTab = By.id("com.pashapuma.pix.wallpapers:id/wallpapers");
    By recyclerView = By.id("com.pashapuma.pix.wallpapers:id/recycler_view");
    By imageView = By.className("android.widget.ImageView");
    By infoButton = By.id("com.pashapuma.pix.wallpapers:id/details");
    By infoScreen = By.id("com.pashapuma.pix.wallpapers:id/container");
    By touchOutside = By.id("com.pashapuma.pix.wallpapers:id/touch_outside");
    By applyButton = By.id("com.pashapuma.pix.wallpapers:id/apply");
    By applyScreen = By.id("com.pashapuma.pix.wallpapers:id/parentPanel");
    By cancelButton = By.id("android:id/button2");
    By closeButton = By.className("android.widget.ImageButton");


    public DetailPage(AppiumDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkNotificationWindow() {
        elementHelper.checkVisible(notificationWindow);
    }

    public void skipNotificationWindow() {
        elementHelper.click(notificationDenyButton);
    }

    public void checkHomePage() {
        elementHelper.checkVisible(homePageTab);
    }

    public void getImageCount() {

        WebElement elements = driver.findElement(recyclerView);
        List<WebElement> allItems = elements.findElements(imageView);

        imageCount = allItems.size();
        System.out.println("Resim Adeti : " + imageCount);
    }

    public void clickRandomImage() {

        WebElement elements = driver.findElement(recyclerView);
        List<WebElement> allItems = elements.findElements(imageView);

        Random rnd = new Random();
        int randomIndex = rnd.nextInt(allItems.size());

        WebElement image = allItems.get(randomIndex);
        image.click();
    }

    public void clickInfoButton() {
        elementHelper.click(infoButton);
    }

    public void checkInfoScreen() {
        elementHelper.checkVisible(infoScreen);
    }

    public void clickOutside() {
        elementHelper.click(touchOutside);
    }

    public void clickApplyButton() {
        elementHelper.click(applyButton);
    }

    public void checkApplyScreen() {
        elementHelper.checkVisible(applyScreen);
    }

    public void clickCancelButton() {
        elementHelper.click(cancelButton);
    }

    public void clickCloseButton() {
        elementHelper.click(closeButton);
    }

    public void checkReturnHomePage() {
        elementHelper.checkVisible(homePageTab);
    }
}