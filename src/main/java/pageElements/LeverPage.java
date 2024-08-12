package pageElements;

import methods.BaseMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeverPage extends BaseMethods {

    private final By applyForThisJobButton = By.xpath("//div[@class='postings-btn-wrapper']//*[text()='Apply for this job']");
    public LeverPage(WebDriver driver) {
        super(driver);
    }
    public void leverPageControl() throws InterruptedException {
        sleep(1);
        switchToNewTab();
        verifyPageTitle("Insider. - Senior Software Quality Assurance Engineer");
    }
    public WebElement applyForThisJobButtonAssert(){
        return findElement(applyForThisJobButton);
    }
    public void leverPageApplyForThisJob() throws InterruptedException {
        sleep(1);
        elementVisible(applyForThisJobButton);
    }
}
