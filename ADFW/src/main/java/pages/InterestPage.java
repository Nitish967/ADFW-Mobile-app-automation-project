package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InterestPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // ========== LOCATORS ==========
    private By continueButton =
            By.xpath("//android.widget.TextView[@text='CONTINUE']");

    private By networkToggle =
            By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]");

    private By checkBox =
            By.xpath("//android.widget.TextView[@text='']");

    private By interestOptions =
            By.xpath("//android.widget.TextView[contains(@text,'Turn')]");

    // ========== CONSTRUCTOR ==========
    public InterestPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ========== ACTION METHODS ==========
    public void selectFirstInterest() {
        List<WebElement> interests =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(interestOptions));

        if (!interests.isEmpty()) {
            interests.get(0).click();
        }
    }

    public void toggleNetwork() {
        wait.until(ExpectedConditions.elementToBeClickable(networkToggle)).click();
    }

    public void acceptTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(checkBox)).click();
    }

    // 🔥 SCROLL TO CONTINUE BUTTON
    public void scrollToContinueButton() {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().text(\"CONTINUE\"))"
                )
        );
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    // 🔥 COMPLETE FLOW METHOD (recommended)
    public void completeInterestFlow() {
        selectFirstInterest();
        toggleNetwork();
        acceptTerms();
        scrollToContinueButton();
        clickContinue();
    }
}
