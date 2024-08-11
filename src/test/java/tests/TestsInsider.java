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

        Assertions.assertNotNull(homePage.insiderLogo, "Ana sayfa başarılı bir şekilde yüklenmedi");

        homePage.acceptAllCookies();
        homePage.companyClick();
        homePage.careersClick();

        careersPage.careersPageElementControl();
        careersPage.scrollToElement();
        careersPage.clickSeeAllTeams();
        careersPage.clickQA();
        careersPage.clickSeeAllQaJobs();

        qaPositionsPage.filterByLocation();
        qaPositionsPage.filterByDepartment();
        qaPositionsPage.viewRoleHover();
        qaPositionsPage.viewRoleClick();

        leverPage.switchToNewTab();
        leverPage.leverPageApplyForThisJob();

    }

}
