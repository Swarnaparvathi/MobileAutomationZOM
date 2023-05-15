package Driver.StepDefinitions;

import Driver.PropertyData;
import Driver.DriverManager;
import ObjectRepository.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static Driver.BaseTest.driver;


/**
 * @author Swarnaparvathi
 * created on 14/05/23
 */

public class StepDefinitions extends BaseSteps {

    @Before
    public void setupLoginSteps() {
        setupScreens((AndroidDriver<MobileElement>) DriverManager.getDriver());
    }

    PropertyData pd = new PropertyData();

    private static boolean isAppLaunched() {
        return driver.findElements(By.id("com.application.zomato:id/splash_screen")).size() > 0;
    }

    @Given("^Launch the App$")
    public void Launch_the_app() throws Throwable {
        System.out.println("App launched");
    }

    @And("^Verify the \"([^\"]*)\" Page$")
    public void Verify_the_page(String page) throws Throwable {
        switch (page) {
            case "Landing":
                landing.setPermissionAllow();
                landing.Verify_Mobile_Field();
                break;
            case "OTP":
                landing.verifyOtpPage();
                break;
            case "Home":
                home.VerifyDeviceLocation();
                home.VerifyDelivery();
                home.VerifyHomeSearchBar();
                break;
            case "Restaurant Search":
                home.VerifyDeliveryHeader();
                break;
            case "Cart":
                resto.VerifyAddAPayment();
                break;
            case "Payment":
                resto.VerifyAddUpi();
                break;
        }
    }

    @And("^User enters the \"([^\"]*)\"$")
    public void enter_options(String options) {
        switch (options) {
            case "Mobile Number":
                landing.enter_Mobile_Number(pd.MobileNumber);
                break;
            case "OTP":
                landing.enterOtp();
                break;
            case "Restaurant Name":
                home.enterRestaurantName(pd.RestaurantName);
                break;
                case "UPI ID":
                resto.EnterUpi(pd.UPIID);
        }
    }

    @And("^User clicks on \"([^\"]*)\"$")
    public void userClicks(String button) {
        switch (button) {
            case "Mobile Number Field":
                landing.clickMobileNumber();
                break;
            case "Continue":
                landing.clickContinue();
                break;
            case "Search Field":
                home.VerifyHomeSearchBar();
                home.clickSearch();
                break;
            case "Restaurant Name":
                home.chooseRestaurant();
                break;
            case "Add To Cart":
                resto.clickAddToCart();
                break;
            case "Add Item":
                resto.clickAddItem();
                break;
            case "Next":
                resto.clickNextBtn();
                break;
                case "Add Payment Method":
                resto.clickAddAPayment();
                break;
            case "Add New UPI":
                resto.ClickUpi();
                break;
            case "Save UPI":
                resto.ClickSaveUpiBtn();
                break;
            case "Back Button":
                resto.ClickBack();
                break;
        }
    }

    @And("^Scroll to \"([^\"]*)\"$")
    public void scrollToText(String text) throws MalformedURLException, InterruptedException {
        BaseScreen.scrollToText(text, DriverManager.getDriver());
    }

    @And("^Navigate back$")
    public void navigateBack() {
        DriverManager.getDriver().navigate().back();
    }

    @Then("^User closes the App$")
    public void userClosesApp() {
        home.CloseApp();
    }
}
