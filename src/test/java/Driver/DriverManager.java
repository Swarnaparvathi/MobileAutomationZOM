package Driver;

import io.appium.java_client.AppiumDriver;

/**
 * @author Swarnaparvathi
 * created on 14/05/23
 */
public class DriverManager {
    private static ThreadLocal<AppiumDriver<?>> driver = new ThreadLocal<>();

    public static AppiumDriver<?> getDriver() {
        return driver.get();
    }

    public static void setDriver(AppiumDriver<?> driver) {
        DriverManager.driver.set(driver);
    }
}
