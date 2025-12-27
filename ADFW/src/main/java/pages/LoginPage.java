package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // ========== LOCATORS (XPATH) ==========

    private By allowNotificationButton = By.xpath(
        "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']"
    );

    private By ticketIdField = By.xpath(
        "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText"
    );

    private By lastNameField = By.xpath(
        "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText"
    );

    private By loginButton =
        By.xpath("//android.widget.TextView[@text='LOGIN']");

    private By errorMessage = By.xpath(
        "//*[contains(@text,'invalid') or contains(@text,'Incorrect') or contains(@text,'Error')]"
    );

    // ========== CONSTRUCTOR ==========
    public LoginPage(AndroidDriver driver) {

        this.driver = driver;

        if (driver == null) {
            throw new RuntimeException("❌ Driver is NULL in LoginPage");
        }

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        handlePermissionPopup();
    }

    // ========== PERMISSION HANDLER ==========
    private void handlePermissionPopup() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions
                    .elementToBeClickable(allowNotificationButton))
                    .click();

            System.out.println("✅ Notification permission allowed");
        } catch (Exception e) {
            System.out.println("ℹ Permission popup not shown / already handled");
        }
    }

    // ========== ACTION METHODS ==========
    public void enterTicketId(String ticketId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ticketIdField))
            .clear();
        driver.findElement(ticketIdField).sendKeys(ticketId);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField))
            .clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void tapLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton))
            .click();
    }

    // ========== BUSINESS METHOD ==========
    public void login(String ticketId, String lastName) {
        enterTicketId(ticketId);
        enterLastName(lastName);
        tapLogin();
    }

    // ========== VALIDATION METHODS ==========
    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions
                    .visibilityOfElementLocated(errorMessage))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessageText() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
