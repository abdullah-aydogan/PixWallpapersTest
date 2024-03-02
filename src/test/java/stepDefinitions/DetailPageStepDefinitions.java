package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DetailPage;
import util.DriverFactory;

public class DetailPageStepDefinitions {

    public DetailPage detailPage = new DetailPage(DriverFactory.getDriver());

    @Given("Check notification permission window")
    public void checkNotificationPermissionWindow() {
        detailPage.checkNotificationWindow();
    }

    @When("Skip notification window")
    public void skipNotificationWindow() {
        detailPage.skipNotificationWindow();
    }

    @Then("Check that the home page")
    public void checkThatTheHomePage() {
        detailPage.checkHomePage();
    }

    @Given("Get count images")
    public void getCountOfImagesListed() {
        detailPage.getItemCount();
    }

    @When("Click on the random image from the list")
    public void clickOnTheRandomImageFromTheList() {
        detailPage.clickRandomItem();
    }

    @When("Click on the information button")
    public void clickOnTheInformationButton() {
        detailPage.clickInfoButton();
    }

    @When("Check that the information screen appears")
    public void checkThatTheInformationScreenAppears() {
        detailPage.checkInfoScreen();
    }

    @When("Click outside")
    public void clickOutside() {
        detailPage.clickOutside();
    }

    @When("Click on the apply button")
    public void clickOnTheApplyButton() {
        detailPage.clickApplyButton();
    }

    @When("Check that the apply screen appears")
    public void checkThatTheApplyScreenAppears() {
        detailPage.checkApplyScreen();
    }

    @When("Click the cancel button")
    public void clickTheCancelButton() {
        detailPage.clickCancelButton();
    }

    @When("Click the close button")
    public void clickTheCloseButton() {
        detailPage.clickCloseButton();
    }

    @Then("Check return home page")
    public void checkReturnHomePage() {
        detailPage.checkReturnHomePage();
    }

    @Given("Switch to collections tab")
    public void switchToCollectionsTab() {
        detailPage.switchCollectionsTab();
    }

    @When("Get count collections")
    public void getCountCollections() {
        detailPage.getItemCount();
    }

    @When("Click random collection")
    public void clickRandomCollection() {
        detailPage.clickRandomItem();
    }

    @When("Get count collection images")
    public void getCountCollectionImages() {
        detailPage.getItemCount();
    }

    @When("Click random collection image")
    public void clickRandomCollectionImage() {
        detailPage.clickRandomItem();
    }

    @When("Save image")
    public void saveImage() {
        detailPage.saveImage();
    }

    @When("Apply image to phone home screen")
    public void applyImageToPhoneHomeScreen() {
        detailPage.applyImage();
    }

    @When("Return to home page")
    public void returnToHomePage() {
        detailPage.returnHomePage();
    }

    @Then("Check return app home page")
    public void checkReturnAppHomePage() {
        detailPage.checkReturnAppHomePage();
    }
}