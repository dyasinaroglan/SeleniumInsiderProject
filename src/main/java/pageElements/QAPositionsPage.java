package pageElements;

import methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QAPositionsPage extends BaseMethods {

    private final By allButtonLocation = By.id("select2-filter-by-location-container");
    private final By locationIstanbulTurkey = By.xpath("//li[contains(.,'Istanbul, Turkey')]");
    private final By allButtonDepartment = By.id("select2-filter-by-department-container");
    private final By qualityAssurance = By.xpath("(//*[text()='Quality Assurance'])[5]");
    public QAPositionsPage(WebDriver driver) {
        super(driver);
    }

    public void filterByLocation() throws InterruptedException {
        scrollByAmount(0,50);
        sleep(3);
        clickTo(allButtonLocation);
        sleep(3);
        elementVisible(locationIstanbulTurkey);
    }
    public void filterByDepartment() throws InterruptedException {
        sleep(3);
        clickTo(allButtonDepartment);
        sleep(3);
        sleep(1);
        elementVisible(qualityAssurance);
    }
}
