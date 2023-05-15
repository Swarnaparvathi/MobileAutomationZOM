package Driver.StepDefinitions;

import ObjectRepository.HomePage_OR;
import ObjectRepository.LandingPage_OR;
import ObjectRepository.RestaurantPage_OR;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author Swarnaparvathi
 * created on 14/05/23
 */

public class BaseSteps {
    protected LandingPage_OR landing;
    protected HomePage_OR home;
    protected RestaurantPage_OR resto;

    public void setupScreens(AndroidDriver<MobileElement> driver) {
        landing = new LandingPage_OR(driver);
        home = new HomePage_OR(driver);
        resto = new RestaurantPage_OR(driver);
    }
}