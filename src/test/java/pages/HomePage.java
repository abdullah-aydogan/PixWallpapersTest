package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;
import util.ElementHelper;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class HomePage {

    public AppiumDriver driver;
    public WebDriverWait wait;
    public ElementHelper elementHelper;
    public static Properties properties;

    public int imageCount = 0;

    By notificationWindow = By.id("com.android.permissioncontroller:id/grant_dialog");
    By notificationDenyButton = By.id("com.android.permissioncontroller:id/permission_deny_button");
    By homePageTab = By.id("com.pashapuma.pix.wallpapers:id/wallpapers");
    By recyclerView = By.id("com.pashapuma.pix.wallpapers:id/recycler_view");
    By cardView = By.className("androidx.cardview.widget.CardView");
    By heartIcon = By.className("android.widget.CheckBox");
    By favoritesTab = By.id("com.pashapuma.pix.wallpapers:id/favorites");
    By wallpaperImg = By.id("com.pashapuma.pix.wallpapers:id/wallpaper_image");
    By stateText = By.id("com.pashapuma.pix.wallpapers:id/state_text");
    By searchIcon = By.id("com.pashapuma.pix.wallpapers:id/search");
    By searchEditText = By.id("com.pashapuma.pix.wallpapers:id/search_src_text");

    public HomePage(AppiumDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);

        properties = ConfigReader.getProperties();
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
        List<WebElement> allItems = elements.findElements(cardView);

        imageCount = allItems.size();
        System.out.println("Resim Adeti : " + imageCount);
    }

    public void clickHeartIcon() {

        List<WebElement> heartIcons = driver.findElements(heartIcon);
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(heartIcons.size());

        WebElement heartIcon = heartIcons.get(randomIndex);
        heartIcon.click();
    }

    public void switchFavoritesTab() {
        elementHelper.click(favoritesTab);
    }

    public void checkFavoritesList() {
        elementHelper.checkVisible(wallpaperImg);
    }

    public void checkEmptyFavoritesList() {
        elementHelper.checkVisible(stateText);
    }

    public void clickSearchIcon() {
        elementHelper.click(searchIcon);
    }

    public void writeBlueInEditTxt() {
        elementHelper.sendKey(searchEditText, properties.getProperty("searchTextBlue"));
    }

    public void writeDsdInEditTxt() {
        elementHelper.sendKey(searchEditText, properties.getProperty("searchTextDsd"));
    }

    public void checkSearchResult(String result) {
        elementHelper.checkVisible(wallpaperImg);
    }

    public void checkSearchEmptyResult(String result) {
        elementHelper.checkVisible(stateText);
    }
}