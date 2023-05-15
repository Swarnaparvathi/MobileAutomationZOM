package Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * @author Swarnaparvathi
 * created on 14/05/23
 */

public class BaseTest {
    public static AppiumDriver<WebElement> driver;
    private final DesiredCapability desiredCapabilitiesUtil = new DesiredCapability();
    private static AppiumDriverLocalService server;

    @BeforeMethod
    @Parameters({"udid", "platformVersion", "platformName"})
    public void setup(String udid, String platformVersion, String platformName) throws IOException {
        DesiredCapabilities caps = desiredCapabilitiesUtil.getDesiredCapabilities(udid, platformVersion, platformName);
        if (platformName.equals("Android")) {

            DriverManager.setDriver(new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps));

        } else {
            DriverManager.setDriver(new IOSDriver<>(new URL("http://127.0.0.1:4726/wd/hub"), caps));

        }
    }

    @AfterMethod
    public synchronized void teardown() {
        DriverManager.getDriver().closeApp();
        DriverManager.getDriver().quit();
    }

    /**
     * Start's the Appium Server and sets the environment variables
     */
    public static void startAppiumServer() {
        String userDir = System.getProperty("user.dir");
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingDriverExecutable(new File("/usr/local/bin/node"));
        serviceBuilder.withAppiumJS(new File("/usr/local/bin/appium"));
        HashMap<String, String> environment = new HashMap();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        environment.put("PATH", "/Library/Java/JavaVirtualMachines/jdk-13.0.1.jdk/Contents/Home");
        environment.put("PATH", userDir + "/Library/Android/sdk");

        serviceBuilder.withIPAddress("127.0.0.1");
        serviceBuilder.usingPort(4723);
        serviceBuilder.withEnvironment(environment);

        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
    }

    /**
     * Stop's the Appium Server and Close the Connection
     */
//    @AfterTest
    public void stopAppiumServer() {
        server.stop();
    }
}
