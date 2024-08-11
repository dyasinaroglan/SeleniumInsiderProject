package pageElements;

import methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QAPositionsPage extends BaseMethods {

    private final By allButtonLocation = By.id("select2-filter-by-location-container");
    private final By locationIstanbulTurkey = By.xpath("//li[contains(.,'Istanbul, Turkey')]");
    private final By allButtonDepartment = By.id("select2-filter-by-department-container");
    private final By qualityAssurance = By.xpath("(//*[text()='Quality Assurance'])[5]");

    private final By hoverQualityAssurance = By.xpath("(//div[@class='position-list-item-wrapper bg-light']/p)[1]");
    private final By viewRoleButton = By.xpath("//a[@href='https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc']");
    public QAPositionsPage(WebDriver driver) {
        super(driver);
    }

    public void filterByLocation() throws InterruptedException {
        scrollByAmount(0,200);
        sleep(1);
        clickTo(allButtonLocation);
        sleep(1);
        elementVisible(locationIstanbulTurkey);
        clickTo(locationIstanbulTurkey);
    }
    public void filterByDepartment() throws InterruptedException {
        sleep(1);
        clickTo(allButtonDepartment);;
        sleep(1);
        elementVisible(qualityAssurance);
        clickTo(qualityAssurance);
    }
    public void viewRoleHover(){
        scrollByAmount(0,350);
        hoverOverElement(viewRoleButton);
    }
    public void viewRoleClick() throws InterruptedException {
        sleep(1);
        clickTo(viewRoleButton);

        sleep(2);
    }
}
