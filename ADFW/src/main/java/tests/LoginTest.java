package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ReportPrint;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @Test(priority = 1)
    public void loginNegativeTests() {

        ReportPrint.createTest("Login - Negative Scenarios");
        loginPage = new LoginPage(driver);

        String[][] negativeCases = {
            {"", ""},
            {"B548363", ""},
            {"", "Tiwari"},
            {"ABCDE", "Tiwari"},
            {"12345", "6789"}
        };

        for (String[] testCase : negativeCases) {

            String ticketId = testCase[0];
            String lastName = testCase[1];

            loginPage.login(ticketId, lastName);
            ReportPrint.info(
                "Attempted login | TicketID: " + ticketId + " | LastName: " + lastName
            );

            Assert.assertTrue(
                loginPage.isErrorMessageDisplayed(),
                "❌ Error message NOT shown for invalid credentials"
            );

            ReportPrint.pass("✅ Error message displayed as expected");
        }
    }

    @Test(priority = 2)
    public void loginPositiveTest() {

        ReportPrint.createTest("Login - Positive Scenario");

        loginPage.login("B548363", "Tiwari");
        ReportPrint.info("Entered valid credentials");

        Assert.assertFalse(
            loginPage.isErrorMessageDisplayed(),
            "❌ Login failed with valid credentials"
        );

        ReportPrint.pass("✅ Login successful → Navigated to Interest Page");
    }
}
