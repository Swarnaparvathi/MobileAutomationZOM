package ObjectRepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @author Swarnaparvathi
 * Created On 15/05/23
 */
public class HomePage_OR extends BaseScreen {


    public HomePage_OR(AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    By HomeSearchBar = By.id("com.application.zomato:id/search_bar_view_flipper");
    By Delivery = By.xpath("//android.widget.TextView[contains(@text, 'Delivery')]");
    By DeliveryHeader = By.id("com.application.zomato:id/tab_snippet_type_5_title");
    By DeviceLocation = By.id("com.application.zomato:id/use_location_button");

    By SearchBar = By.id("com.application.zomato:id/edittext");
    By Profile = By.id("com.application.zomato:id/profile_image");
    By CurrentDevice = By.id("com.application.zomato:id/positive_button");

    By Logout = By.xpath("//android.widget.TextView[contains(@text, 'Log out')]");

    public void VerifyHomeSearchBar() {
        waitAndFindElement(HomeSearchBar);
        elementDisplayed(HomeSearchBar);
    }


    public void VerifyDeliveryHeader() {
        waitAndFindElement(DeliveryHeader);
        elementDisplayed(DeliveryHeader);
    }

    public void VerifyDeviceLocation() {
        try{
            waitAndFindElement(DeviceLocation);
            elementDisplayed(DeviceLocation);
            click(DeviceLocation);
        }
        catch (Exception e){
            System.out.println("Device Location is Granted");
        }

    }

    public void VerifyDelivery() {
        waitAndFindElement(Delivery);
        elementDisplayed(Delivery);
    }

    public void clickSearch() {
        waitAndFindElement(HomeSearchBar);
        click(HomeSearchBar);
    }

    public void enterRestaurantName(String search) {
        sendKey(SearchBar, search);
    }

    public void chooseRestaurant() {
        TapByCoordinates(driver);
    }

    public void clickProfile() {
        waitAndFindElement(Profile);
        click(Profile);
    }

    public void clickCurrentDevice() {
        waitAndFindElement(CurrentDevice);
        click(CurrentDevice);
    }

    public void clickLogout() {
        waitAndFindElement(Logout);
        click(Logout);
    }

    public void CloseApp() {
        closeapp();
    }


}
