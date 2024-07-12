package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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

    public AndroidDriver driver;
    public WebDriverWait wait;
    public ElementHelper elementHelper;
    public static Properties properties;

    public int imageCount = 0;

    // Anasayfada kullanılan elementlerin tanımlamaları
    // ID, className

    By homePageTab = By.id("com.pashapuma.pix.wallpapers:id/wallpapers");
    By recyclerView = By.id("com.pashapuma.pix.wallpapers:id/recycler_view");
    By cardView = By.className("androidx.cardview.widget.CardView");
    By heartIcon = By.className("android.widget.CheckBox");
    By favButton = By.id("com.pashapuma.pix.wallpapers:id/fav_button");
    By favoritesTab = By.id("com.pashapuma.pix.wallpapers:id/favorites");
    By wallpaperImg = By.id("com.pashapuma.pix.wallpapers:id/wallpaper_image");
    By stateImage = By.id("com.pashapuma.pix.wallpapers:id/state_image");
    By searchIcon = By.id("com.pashapuma.pix.wallpapers:id/search");
    By searchEditText = By.id("com.pashapuma.pix.wallpapers:id/search_src_text");

    public HomePage(AndroidDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);

        properties = ConfigReader.getProperties();
    }

    public void checkHomePage() {
        elementHelper.checkVisible(homePageTab);
    }

    // Listelenen elemanlarını sayısını al
    public void getImageCount() {

        WebElement elements = driver.findElement(recyclerView);
        List<WebElement> allItems = elements.findElements(cardView);

        imageCount = allItems.size();
        System.out.println("Resim Adeti : " + imageCount);
    }

    // Listeden rastgele bir elemanın favori ikonunu seç
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
        elementHelper.click(favButton);
        elementHelper.checkVisible(stateImage);
    }

    public void checkEmptyFavoritesList() {
        elementHelper.checkVisible(stateImage);
    }

    public void clickSearchIcon() {
        elementHelper.click(searchIcon);
    }

    // Arama bölümüne blue yaz
    public void writeBlueInEditTxt() {
        elementHelper.sendKey(searchEditText, properties.getProperty("searchTextBlue"));
    }

    // Arama bölümüne anlamsız bir kelime yaz (dsd gibi)
    public void writeDsdInEditTxt() {
        elementHelper.sendKey(searchEditText, properties.getProperty("searchTextDsd"));
    }

    public void checkSearchResult(String result) {
        elementHelper.checkVisible(wallpaperImg);
    }

    public void checkSearchEmptyResult(String result) {
        elementHelper.checkVisible(stateImage);
    }
}