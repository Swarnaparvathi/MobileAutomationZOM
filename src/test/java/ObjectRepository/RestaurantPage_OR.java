package ObjectRepository;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * @author Swarnaparvathi
 * Created On 15/05/23
 */
public class RestaurantPage_OR extends BaseScreen {


    public RestaurantPage_OR(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    By Rating = By.id("com.application.zomato:id/topTextView");
    By NextBtn = By.id("com.application.zomato:id/next_state");
    By AddAPayment = By.id("com.application.zomato:id/place_order_text");
    By AddUpi = By.xpath("//android.widget.TextView[contains(@text, 'Add new UPI ID')]");
    By EnterUpi = By.id("com.application.zomato:id/input_et");
    By SaveUpiBtn = By.id("com.application.zomato:id/submit_btn");
    By Back = By.id("com.application.zomato:id/back_button");

    By AddToCart = By.xpath("//android.widget.TextView[contains(@text, 'ADD')]");
    By AddItem = By.xpath("//android.widget.Button[contains(@text, 'Add item')]");

    public void VerifyRating() {
        waitAndFindElement(Rating);
        elementDisplayed(Rating);
    }

    public void clickAddToCart() {
        waitAndFindElement(AddToCart);
        click(AddToCart);
    }

    public void clickAddItem() {
        waitAndFindElement(AddItem);
        click(AddItem);
    }

    public void clickNextBtn() {
        waitAndFindElement(NextBtn);
        click(NextBtn);
    }

    public void VerifyAddAPayment() {
        waitAndFindElement(AddAPayment);
        elementDisplayed(AddAPayment);
    }

    public void clickAddAPayment() {
        waitAndFindElement(AddAPayment);
        click(AddAPayment);
    }

    public void VerifyAddUpi() {
        waitAndFindElement(AddUpi);
        elementDisplayed(AddUpi);
    }

    public void ClickUpi() {
        waitAndFindElement(AddUpi);
        click(AddUpi);
    }

    public void EnterUpi(String upi) {
        waitAndFindElement(EnterUpi);
        sendKey(EnterUpi, upi);
    }

    public void ClickSaveUpiBtn() {
        waitAndFindElement(SaveUpiBtn);
        click(SaveUpiBtn);
    }

    public void ClickBack() {
        waitAndFindElement(Back);
        click(Back);
    }

}
