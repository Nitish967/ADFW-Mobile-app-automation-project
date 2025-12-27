package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ReportPrint {

    private static ExtentReports extent;
    public static ExtentTest test;

    private static final String REPORT_DIR =
            System.getProperty("user.dir") + File.separator + "reports";

    private static final String HTML_REPORT =
            REPORT_DIR + File.separator + "Automation_Dashboard.html";

    private static final String SCREENSHOT_DIR =
            System.getProperty("user.dir") + File.separator + "screenshots";

    // ================= INIT REPORT =================
    public static void initReport() {
        if (extent != null) return;

        new File(REPORT_DIR).mkdirs();
        new File(SCREENSHOT_DIR).mkdirs();

        ExtentSparkReporter spark = new ExtentSparkReporter(HTML_REPORT);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Mobile Automation Dashboard");
        spark.config().setReportName("Appium Test Execution Report");
        spark.config().setTimeStampFormat("dd-MMM-yyyy HH:mm:ss");

        extent = new ExtentReports();
        extent.attachReporter(spark);

        extent.setSystemInfo("Platform", "Android");
        extent.setSystemInfo("Automation", "Appium + Java");
        extent.setSystemInfo("Framework", "TestNG + POM");
        extent.setSystemInfo("Tester", "QA Nitish Tiwari");

        System.out.println("📊 Dashboard Report Initialized → " + HTML_REPORT);
    }

    // ================= CREATE TEST =================
    public static void createTest(String testName) {
        if (extent == null) initReport();
        test = extent.createTest(testName);
    }

    // ================= LOG METHODS =================
    public static void pass(String message) {
        if (test != null) test.pass(message);
        System.out.println("✅ " + message);
    }

    public static void fail(String message) {
        if (test != null) test.fail(message);
        System.out.println("❌ " + message);
    }

    public static void info(String message) {
        if (test != null) test.info(message);
        System.out.println("ℹ " + message);
    }

    public static void warning(String message) {
        if (test != null) test.warning(message);
        System.out.println("⚠ " + message);
    }

    // ================= ATTACH SCREENSHOT =================
    public static void attachScreenshot(String screenshotFileName) {
        if (test != null) {
            String path = SCREENSHOT_DIR + File.separator + screenshotFileName + ".png";
            File f = new File(path);
            if (f.exists()) {
                test.addScreenCaptureFromPath(path);
            } else {
                test.warning("Screenshot not found: " + screenshotFileName);
            }
        }
    }

    // ================= FLUSH =================
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
            System.out.println("✅ Attractive Dashboard Generated Successfully");
        }
    }
}
//report page pushed