package utils;

import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver initDriver() throws Exception {

        if (driver != null) {
            return driver;
        }

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("AndroidDevice");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\Dell\\OneDrive\\Desktop\\android_tools\\apk_files\\app-release.apk");

        // 🔥 AUTO PERMISSION FOR ANDROID 12–15
        options.setAutoGrantPermissions(true);

        options.setNoReset(false);
        options.setFullReset(false);

        URL url = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("✅ App launched successfully 🚀");
        System.out.println("ℹ Permission popup not shown (auto-granted)");

        return driver;
    }

    public static AndroidDriver getDriver() {
        return driver;
    }
}
