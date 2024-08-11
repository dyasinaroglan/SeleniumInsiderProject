package pageElements;

import methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPage extends BaseMethods {

    private final By ourLocations = By.cssSelector("h3[class='category-title-media ml-0']");
    private final By lifeAtInsider = By.xpath("//*[text()='Life at Insider']");
    private final By seeAllTeams = By.xpath("//*[text()='See all teams']");
    private final By scrollFindYourCalling = By.xpath("//h3[contains(.,'Find your calling')]");
    private final By QAclick = By.xpath("//*[text()='Quality Assurance']");
    private final By seeAllQAJobs = By.cssSelector("div[class='button-group d-flex flex-row'] a");

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void careersPageElementControl() {
        elementVisible(ourLocations);
        elementVisible(lifeAtInsider);
        elementVisible(seeAllTeams);

    }
    public void scrollToElement(){
        scrollTo(seeAllTeams);
    }
    public void clickSeeAllTeams() throws InterruptedException {
        sleep(1);
        clickTo(seeAllTeams);
    }
    public void clickQA() throws InterruptedException {
        sleep(1);
        scrollTo(QAclick);
        sleep(1);
        clickTo(QAclick);
    }
    public void clickSeeAllQaJobs(){
        clickTo(seeAllQAJobs);
    }
    public WebElement ourLocationsControl(){
        return findElement(ourLocations).findElement(lifeAtInsider).findElement(seeAllTeams);
    }
}
