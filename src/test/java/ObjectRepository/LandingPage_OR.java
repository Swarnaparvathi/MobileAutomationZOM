package ObjectRepository;

import Utils.OTPExtractor;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;

/**
 * @author Swarnaparvathi
 * Created On 15/05/23
 */

public class LandingPage_OR extends BaseScreen {


    public LandingPage_OR(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    By PermissionAllow = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    By CountryCode = By.id("com.application.zomato:id/tv_phone_code");
    By phoneNumberInput = By.id("com.application.zomato:id/fw_mobile_edit_text");
    By ContinueBtn = By.id("com.application.zomato:id/send_otp_button");
    By OtpHeader = By.id("com.application.zomato:id/first_title_switcher");
    By OtpField = By.id("com.application.zomato:id/otp_edit_text");
    By ResendOtp = By.id("com.application.zomato:id/resendButton");
    By OtpMsg = By.id("com.google.android.apps.messaging:id/swipeableContainer");
    By OtpText = By.id("com.google.android.apps.messaging:id/message_text");
    By HomeSearchBar = By.id("com.application.zomato:id/search_bar_view_flipper");


    public void setPermissionAllow() {
        waitAndFindElement(PermissionAllow);
        elementDisplayed(PermissionAllow);
        click(PermissionAllow);
    }

    public void Verify_Mobile_Field() {
        waitAndFindElement(phoneNumberInput);
        elementDisplayed(phoneNumberInput);
    }

    public void clickMobileNumber() {
        waitAndFindElement(phoneNumberInput);
        elementDisplayed(phoneNumberInput);
    }

    public void enter_Mobile_Number(String mobile) {
        sendKey(phoneNumberInput, mobile);
    }

    public void clickContinue() {
        click(ContinueBtn);
    }

    public void verifyOtpPage() {
        waitAndFindElement(OtpHeader);
        elementDisplayed(OtpHeader);
        waitAndFindElement(OtpField);
        elementDisplayed(OtpField);
        waitAndFindElement(ResendOtp);
        elementDisplayed(ResendOtp);
    }

    public void enterOtp() {
        try {
            waitAndFindElement(HomeSearchBar);
            System.out.println("OTP is not required and user is logged in");
        } catch (Exception e) {
            driver.startActivity(new Activity("com.google.android.apps.messaging", "com.google.android.apps.messaging.ui.ConversationListActivity"));
            click(OtpMsg);
            String sms = getText(OtpText);
            String OTP = OTPExtractor.returnOtp(sms);
            sendKey(OtpField, OTP);
        }
    }


}
