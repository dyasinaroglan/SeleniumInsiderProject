package pageElements;

import methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QAPositionsPage extends BaseMethods {

    private final By allButtonLocation = By.cssSelector("span[id='select2-filter-by-location-container']");
    private final By locationIstanbulTurkey = By.xpath("//li[contains(.,'Istanbul, Turkey')]");
    private final By allButtonDepartment = By.id("select2-filter-by-department-container");
    private final By qualityAssurance = By.id("select2-filter-by-department-result-7bso-Quality Assurance");

    private final By allQualityAssuranceText = By.xpath("//div[@class='position-list-item-wrapper bg-light']/p[contains(text(), 'Assurance Engineer')]");
    private final By allIstanbulTurkeyText = By.xpath("//div[contains(text(), 'Istanbul, Turkey')]");
    private final By viewRoleButton = By.xpath("//a[@href='https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc']");
    public QAPositionsPage(WebDriver driver) {
        super(driver);
    }

    public void filterByLocation() throws InterruptedException {
        scrollByAmount(0,200);
        sleep(2);
        clickTo(allButtonLocation);
        clickTo(allButtonLocation);
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
    }
    public void viewRoleClick() throws InterruptedException {
        sleep(1);
        clickTo(viewRoleButton);
    }
    public WebElement locationIstanbulControl(){
        return findElement(locationIstanbulTurkey);
    }
    public WebElement departmentQAssuranceControl(){
        return findElement(qualityAssurance);
    }
    public void assertText(){
        asserTextElements(allQualityAssuranceText,"Assurance Engineer");
        asserTextElements(allIstanbulTurkeyText,"Istanbul, Turkey");
    }
}
