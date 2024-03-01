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
        detailPage.getImageCount();
    }

    @When("Click on the random image from the list")
    public void clickOnTheRandomImageFromTheList() {
        detailPage.clickRandomImage();
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
}