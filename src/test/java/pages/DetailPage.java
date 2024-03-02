package pages;

import io.appium.java_client.AppiumBy;
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

    public int itemCount = 0;

    By notificationWindow = By.id("com.android.permissioncontroller:id/grant_dialog");
    By notificationDenyButton = By.id("com.android.permissioncontroller:id/permission_deny_button");
    By homePageTab = By.id("com.pashapuma.pix.wallpapers:id/wallpapers");
    By recyclerView = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.pashapuma.pix.wallpapers:id/recycler_view\")");
    By imageView = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.pashapuma.pix.wallpapers:id/wallpaper_image\")");
    By infoButton = By.id("com.pashapuma.pix.wallpapers:id/details");
    By infoScreen = By.id("com.pashapuma.pix.wallpapers:id/container");
    By touchOutside = By.id("com.pashapuma.pix.wallpapers:id/touch_outside");
    By applyButton = By.id("com.pashapuma.pix.wallpapers:id/apply");
    By applyScreen = By.id("com.pashapuma.pix.wallpapers:id/parentPanel");
    By cancelButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"İptal\")");
    By closeButton = By.className("android.widget.ImageButton");
    By collectionsTab = By.id("com.pashapuma.pix.wallpapers:id/collections");
    By downloadButton = By.id("com.pashapuma.pix.wallpapers:id/download");
    By downloadText = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Kaydediliyor…\")");
    By applyHomePageBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Ana Ekrana için ayarla\")");
    By okBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Tamam\")");
    By applyText = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Duvar kağıdı uygulandı.\")");

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

    public void getItemCount() {

        WebElement elements = driver.findElement(recyclerView);
        List<WebElement> allItems = elements.findElements(imageView);

        itemCount = allItems.size();
        System.out.println("Bulunan Eleman Adeti : " + itemCount);
    }

    public void clickRandomItem() {

        WebElement elements = driver.findElement(recyclerView);
        List<WebElement> allItems = elements.findElements(imageView);

        Random rnd = new Random();
        int randomIndex = rnd.nextInt(allItems.size());

        WebElement item = allItems.get(randomIndex);
        item.click();
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

    public void switchCollectionsTab() {
        elementHelper.click(collectionsTab);
    }

    public void saveImage() {

        elementHelper.click(downloadButton);
        elementHelper.checkVisible(downloadText);
    }

    public void applyImage() {

        elementHelper.click(applyButton);
        elementHelper.click(applyHomePageBtn);
        elementHelper.click(okBtn);
        elementHelper.checkVisible(applyText);
    }

    public void returnHomePage() {

        elementHelper.click(closeButton);
        elementHelper.click(closeButton);
        elementHelper.click(homePageTab);
    }

    public void checkReturnAppHomePage() {
        elementHelper.checkVisible(homePageTab);
    }
}