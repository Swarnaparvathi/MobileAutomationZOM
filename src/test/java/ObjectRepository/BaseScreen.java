package ObjectRepository;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;

import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Swarnaparvathi
 * created on 14/05/23
 */

public class BaseScreen {
    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;

    public BaseScreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    protected void click(By by) {
        driver.findElement(by).click();
    }

    protected void closeapp() {

        driver.closeApp();
    }

    protected WebElement waitAndFindElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected WebElement elementDisplayed(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected String getText(By by) {
        return waitAndFindElement(by).getText();
    }

    protected void sendKey(By by, String text) {
        waitAndFindElement(by).sendKeys(text);
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void assertEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected, "Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
    }

    protected void waitVisibility(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToText(String text, AppiumDriver<?> driver) throws MalformedURLException, InterruptedException {
        try {
            MobileElement el = (MobileElement) ((FindsByAndroidUIAutomator<?>) driver).findElementByAndroidUIAutomator("new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().textContains(\"" + text + "\"));");
        } catch (Exception E) {
            System.out.println("Scrolled");
        }
    }

    public static void scrollToTextClick(String text, AppiumDriver<?> driver) throws MalformedURLException, InterruptedException {
        try {
            MobileElement el = (MobileElement) ((FindsByAndroidUIAutomator<?>) driver).findElementByAndroidUIAutomator("new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().textContains(\"" + text + "\"));");
            el.click();
        } catch (Exception E) {
            System.out.println("Scrolled");
        }
    }

    public static void TapByCoordinates(AppiumDriver driver) {
        int xPoint = 376;
        int yPoint = 542;
        AndroidTouchAction touchAction = new AndroidTouchAction(driver);
        touchAction.press(PointOption.point(xPoint, yPoint)).release().perform();
    }

}
