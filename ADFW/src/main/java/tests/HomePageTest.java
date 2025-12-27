package tests;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ReportPrint;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void setupPage() {
        homePage = new HomePage(driver);
    }

    @Test
    public void homePageFlow() {

        ReportPrint.createTest("Home Page Full Flow");

        try {
            // ===== Agenda =====
            homePage.clickAgenda();
            homePage.scrollDown();
            homePage.scrollUp();
            ReportPrint.attachScreenshot(homePage.takeScreenshot("Agenda_Page"));

            // ===== Ticket =====
            homePage.clickTicket();
            homePage.scrollDown();
            homePage.scrollUp();
            ReportPrint.attachScreenshot(homePage.takeScreenshot("Ticket_Page"));

            // ===== Chat =====
            homePage.clickChat();
            ReportPrint.attachScreenshot(homePage.takeScreenshot("Chat_Page"));

            // ===== Explore =====
            homePage.clickExplore();
            ReportPrint.attachScreenshot(homePage.takeScreenshot("Explore_Page"));

            // ===== Home =====
            homePage.clickHome();
            homePage.scrollDown();
            homePage.scrollUp();
            ReportPrint.attachScreenshot(homePage.takeScreenshot("Home_Page"));

            // ===== Side Menu =====
            homePage.openSideMenu();
            ReportPrint.attachScreenshot(homePage.takeScreenshot("Side_Menu"));

            ReportPrint.pass("Home page flow executed successfully ✅");

        } catch (Exception e) {
            ReportPrint.fail("Home page flow failed ❌: " + e.getMessage());
        }
    }
}
