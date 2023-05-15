package Driver;

import Utils.SetProperties;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Swarnaparvathi
 * created on 14/05/23
 */

public class DesiredCapability {

    public DesiredCapabilities getDesiredCapabilities(String udid, String platformVersion, String platformName) {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        String userDir = System.getProperty("user.dir");

        if (platformName.equals("Android")) {
            desiredCapabilities.setCapability("appium:udid", udid);
            desiredCapabilities.setCapability("appium:platformVersion", platformVersion);
            desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
            desiredCapabilities.setCapability("platformName", platformName);
            desiredCapabilities.setCapability("appium:appPackage", "com.application.zomato");
            desiredCapabilities.setCapability("appium:app", userDir +"/src/main/resources/app/Zomato.apk");
            desiredCapabilities.setCapability("appium:appActivity", "com.application.zomato.activities.Splash");
            desiredCapabilities.setCapability("appium:skipUnlock", "true");
            desiredCapabilities.setCapability("appium:noReset", "true");

            return desiredCapabilities;
        } else if (platformName.equals("iOS")) {
            System.out.println("Test on iOS platform");

            desiredCapabilities.setCapability("udid", udid);
            desiredCapabilities.setCapability("platformVersion", platformVersion);
            desiredCapabilities.setCapability("platformName", platformName);
            desiredCapabilities.setCapability("deviceName", "Swarna’s iPhone");
            desiredCapabilities.setCapability("bundleId", "com.application.zomato");
            desiredCapabilities.setCapability("noReset", "false");
            desiredCapabilities.setCapability("xcodeOrgId", "XXXXXXX");
            desiredCapabilities.setCapability("xcodeSigningId", "iPhone Developer");

            return desiredCapabilities;
        } else {
            System.out.println("Requested platform is not found");
            return desiredCapabilities;
        }


    }

}
