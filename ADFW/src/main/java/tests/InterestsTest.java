package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.InterestPage;
import utils.ReportPrint;

public class InterestsTest extends BaseTest {

    @Test(priority = 3)
    public void interestPageCompleteFlow() {

        ReportPrint.createTest("Interest Page → Scroll → Continue → Home");

        InterestPage interestPage = new InterestPage(driver);

        // 🔥 Full interest flow with scroll
        interestPage.completeInterestFlow();

        ReportPrint.pass("Interest page completed and navigated to Home page");
    }
}
//intrest test page pushed
