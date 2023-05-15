package PageObjects;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import Driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

/**
 * @author Swarnaparvathi
 * created on 14/05/23
 */

public class AppiumActions extends BaseTest {

    public void SendText(MobileElement element, String Text) {
        element.sendKeys(Text);
    }

    public void ClickElement(MobileElement element) {
        element.click();
    }

    public void AssertElementDisplay(MobileElement element) {
        Assert.assertTrue(element.isDisplayed(), element + " is not displayed");
    }

    public void ExplicitWait(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getText(MobileElement elementText) {
        return elementText.getText();
    }

    public void VisibilityOfElement(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean ValidateElementNotPresent(MobileElement element) {

        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Element Not Present");
            return false;
        }

    }

    public void ValidateTextNotPresentInScreen(String text) {
        System.out.println("Text to be searched is" + text);
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        Assert.assertEquals(list.size() > 0, false);
    }

    public void ClearText(MobileElement element) {
        element.clear();
    }

    public void InvisibilityOfElement(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void ExplicitWaitWithTime(MobileElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void ClickIFElementPresent(MobileElement element) {
        try {
            element.isDisplayed();
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("element not present");
        }
    }

    public void ClickOnElementUsingAccessibilityID(String locator) {
        driver.findElementByAccessibilityId(locator).click();
    }


    public void scrollToText(String text, AppiumDriver<MobileElement> driver)

        // scroll to particular text
            throws MalformedURLException, InterruptedException {
        MobileElement el = (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().textContains(\"" + text + "\"));");
        el.click();
    }

    public boolean isElementDisplay(MobileElement MobileElement) {

        //check weather element is present or not
        try {
            return MobileElement.isDisplayed();
            //return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not displayed: " + e.getMessage());
            System.out.println("This stacktrace message for not locating element");
            //e.printStackTrace();
            return false;
        }
    }

    public void ScrollToNameUsingIOSPredicateString(String text) throws WebDriverException, InterruptedException {
        Thread.sleep(3000);
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("predicateString", "name == '" + text + "'");
        driver.executeScript("mobile: scroll", scrollObject);
    }
}
