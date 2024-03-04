package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import util.DriverFactory;

public class HomePageStepDefinitions {

    // Anasayfa için gerekli test adımlarının tanımlandığı sınıf (features dosyası ile ilişkili)

    public HomePage homePage = new HomePage(DriverFactory.getDriver());

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

    @Then("Check that the empty favorites list appears")
    public void checkThatTheEmptyFavoritesListAppears() {
        homePage.checkEmptyFavoritesList();
    }

    @When("Click on the search icon")
    public void clickOnTheSearchIcon() {
        homePage.clickSearchIcon();
    }

    @When("Type blue in the EditText field")
    public void typeBlueInTheEditTextField() {
        homePage.writeBlueInEditTxt();
    }

    @Then("Check the search result {string}")
    public void checkTheSearchResult(String result) {
        homePage.checkSearchResult(result);
    }

    @When("Type dsd in the EditText field")
    public void typeDsdInTheEditTextField() {
        homePage.writeDsdInEditTxt();
    }

    @Then("Check the search empty result {string}")
    public void checkTheSearchEmptyResult(String result) {
        homePage.checkSearchEmptyResult(result);
    }
}