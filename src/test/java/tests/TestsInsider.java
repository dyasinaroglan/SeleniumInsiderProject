package tests;

import methods.BaseMethods;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.asserts.Assertion;
import pageElements.CareersPage;
import pageElements.HomePage;
import pageElements.LeverPage;
import pageElements.QAPositionsPage;
import utils.Browsers;
import utils.Driver;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.TimeUnit;

import static org.testng.TestRunner.PriorityWeight.priority;


public class TestsInsider extends Driver {

    @Test()
    public void test1() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        CareersPage careersPage = new CareersPage(driver);
        QAPositionsPage qaPositionsPage = new QAPositionsPage(driver);
        LeverPage leverPage = new LeverPage(driver);

        Assertions.assertNotNull(homePage.anaSayfaControl(), "The homepage failed to load successfully.");
        homePage.anaSayfaGiris();
        homePage.acceptAllCookies();
        homePage.companyClick();
        homePage.careersClick();

        careersPage.careersPageElementControl();
        Assertions.assertNotNull(careersPage.ourLocationsControl());
        careersPage.scrollToElement();
        careersPage.clickSeeAllTeams();
        careersPage.clickQA();
        careersPage.clickSeeAllQaJobs();

        qaPositionsPage.filterByLocation();
        Assertions.assertNotNull(qaPositionsPage.locationIstanbulControl());
        qaPositionsPage.filterByDepartment();
        Assertions.assertNotNull(qaPositionsPage.departmentQAssuranceControl());
        qaPositionsPage.viewRoleHover();
        qaPositionsPage.assertText();
        qaPositionsPage.viewRoleClick();

        leverPage.switchToNewTab();
        leverPage.leverPageApplyForThisJob();
        Assert.assertNotNull("The 'APPLY FOR THIS JOB' button was successfully displayed.",leverPage.applyForThisJobButtonAssert());

    }

}
