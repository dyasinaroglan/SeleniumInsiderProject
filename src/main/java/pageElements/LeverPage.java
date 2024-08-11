package pageElements;

import methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeverPage extends BaseMethods {

    private final By applyForThisJobButton = By.xpath("(//*[text()='Apply for this job'])[1]");
    public LeverPage(WebDriver driver) {
        super(driver);
    }
    public void leverPageControl() throws InterruptedException {
        sleep(1);
        switchToNewTab();
        verifyPageTitle("Insider. - Senior Software Quality Assurance Engineer");
    }
    public void leverPageApplyForThisJob() throws InterruptedException {
        sleep(1);
        elementVisible(applyForThisJobButton);
    }
}
