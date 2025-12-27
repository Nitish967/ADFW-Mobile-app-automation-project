package base;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Base {

    public static void main(String[] args) throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("Pixel 9");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        //options.setApp("C:\\Users\\Dell\\OneDrive\\Desktop\\android_tools\\apk_files\\app-release.apk");
        
        options.setNoReset(false);  // false → app data reset ho sakta hai
        options.setFullReset(false); // false → app uninstall/reinstall nahi, bas update

        URL url = new URL("http://127.0.0.1:4723");

        AndroidDriver driver = new AndroidDriver(url, options);

        System.out.println("✅ App launched successfully 🚀");

        // ---- BASIC CHECKS ----
        System.out.println("Current Activity: " + driver.currentActivity());
        System.out.println("Device Time: " + driver.getDeviceTime());

        Thread.sleep(5000);

        driver.quit();
        System.out.println("Driver closed successfully");
    }
}
