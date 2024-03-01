package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import util.DriverFactory;

public class HomePageStepDefinitions {

    public HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Given("See notification permission window")
    public void seeNotificationPermissionWindow() {
        homePage.checkNotificationWindow();
    }

    @When("Skip notification permission window")
    public void skipNotificationPermissionWindow() {
        homePage.skipNotificationWindow();
    }

    @Then("Check that the home page opens")
    public void checkThatTheHomePageOpens() {
        homePage.checkHomePage();
    }

    @Given("Get count of images listed")
    public void getCountOfImagesListed() {
        homePage.getImageCount();
    }

    @When("Click the heart icon of a random image")
    public void clickTheHeartIconOfARandomImage() {
        homePage.clickHeartIcon();
    }

    @When("Switch to the favorites tab")
    public void switchToTheFavoritesTab() {
        homePage.switchFavoritesTab();
    }

    @Then("Check that the favorites list appears")
    public void checkThatTheFavoritesListAppears() {
        homePage.checkFavoritesList();
    }
}