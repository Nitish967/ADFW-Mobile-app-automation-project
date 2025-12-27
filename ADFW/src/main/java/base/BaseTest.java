package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import utils.DriverFactory;
import utils.ReportPrint;

public class BaseTest {

    protected static AndroidDriver driver;

    @BeforeSuite
    public void setUpSuite() throws Exception {

        // ✅ Init Report ONCE
        ReportPrint.initReport();

        // ✅ Launch App ONLY ONCE for complete suite flow
        driver = DriverFactory.initDriver();

        System.out.println("🚀 App launched successfully");
    }

    @AfterSuite
    public void tearDownSuite() {

        try {
            if (driver != null) {
                // ❗ Keep commented while debugging multi-test flow
                // driver.quit();
                // System.out.println("🚪 Driver closed successfully");
            }
        } finally {
            // ✅ Flush report ONCE at end
            ReportPrint.flushReport();
            System.out.println("📊 Report flushed successfully");
        }
    }
}
//base push 1