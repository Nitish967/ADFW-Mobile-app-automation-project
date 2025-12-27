package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class HomePage {

    private AndroidDriver driver;

    // ========= LOCATORS (Parent Views, Clickable) =========
    private By agendaMenu = By.xpath("//android.view.View[@content-desc=\"Agenda\"]");
    private By ticketMenu = By.xpath("//android.view.View[@content-desc='Ticket']");
    private By chatMenu = By.xpath("//android.view.View[@content-desc='Chat']");
    private By exploreMenu = By.xpath("//android.view.View[@content-desc='Explore']");
    private By homeButton = By.xpath("//android.widget.TextView[@text='Home']");
    private By sideMenuButton = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.ImageView");

    // ========= CONSTRUCTOR =========
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // ========= SAFE CLICK =========
    private void safeClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            element.click();
        } catch (Exception e) {
            // fallback using JS click
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }

    // ========= PAGE ACTIONS =========
    public void clickAgenda() {
        safeClick(agendaMenu);
    }

    public void clickTicket() {
        safeClick(ticketMenu);
    }

    public void clickChat() {
        safeClick(chatMenu);
    }

    public void clickExplore() {
        safeClick(exploreMenu);
    }

    public void clickHome() {
        safeClick(homeButton);
    }

    public void openSideMenu() {
        safeClick(sideMenuButton);
    }

    // ========= SCROLL =========
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }

    // ========= SCREENSHOT =========
    public String takeScreenshot(String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dir = System.getProperty("user.dir") + "/screenshots";
            Files.createDirectories(Paths.get(dir));

            String path = dir + "/" + name + ".png";
            Files.copy(src.toPath(), Paths.get(path));
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}
