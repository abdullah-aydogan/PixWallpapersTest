package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DetailPage {

    public AndroidDriver driver;
    public WebDriverWait wait;
    public ElementHelper elementHelper;

    public int itemCount = 0;

    // Detay sayfasında kullanılan elementlerin tanımlamaları
    // ID, UiSelector(), className

    By homePageTab = By.id("com.pashapuma.pix.wallpapers:id/wallpapers");
    By recyclerView = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.pashapuma.pix.wallpapers:id/recycler_view\")");
    By imageView = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.pashapuma.pix.wallpapers:id/wallpaper_image\")");
    By infoButton = By.id("com.pashapuma.pix.wallpapers:id/details");
    By infoScreen = By.id("com.pashapuma.pix.wallpapers:id/container");
    By applyButton = By.id("com.pashapuma.pix.wallpapers:id/apply");
    By applyScreen = By.id("com.pashapuma.pix.wallpapers:id/parentPanel");
    By cancelButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"İptal\")");
    By closeButton = By.className("android.widget.ImageButton");
    By collectionsTab = By.id("com.pashapuma.pix.wallpapers:id/collections");
    By downloadButton = By.id("com.pashapuma.pix.wallpapers:id/download");
    By downloadText = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Kaydediliyor…\")");
    By applyHomePageBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Ana Ekrana için ayarla\")");
    By okBtn = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Tamam\")");

    // Gerçek cihazda Toast mesajın yakalanması için gerekli element tanımlaması
    // By applyText = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Uygulanıyor…\")");

    // Sanal cihazda Toast mesajın yakalanması için gerekli element tanımlaması
    // Gerçek cihazda bu Toast mesaj yakalanmıyor.
    By applyText = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Duvar kağıdı uygulandı.\")");

    public DetailPage(AndroidDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkHomePage() {
        elementHelper.checkVisible(homePageTab);
    }

    // Listelenen elemanlarını sayısını al
    public void getItemCount() {

        WebElement elements = driver.findElement(recyclerView);
        List<WebElement> allItems = elements.findElements(imageView);

        itemCount = allItems.size();
        System.out.println("Bulunan Eleman Adeti : " + itemCount);
    }

    // Listeden rastgele bir eleman seç
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

    // Boş bir alana tıkla
    public void clickOutside() {
        driver.navigate().back();
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