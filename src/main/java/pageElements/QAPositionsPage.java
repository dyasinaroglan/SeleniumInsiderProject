package pageElements;

import methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QAPositionsPage extends BaseMethods {

    private final By allButtonLocation = By.cssSelector("span[id='select2-filter-by-location-container']");
    private final By locationIstanbulTurkey = By.id("filter-by-location");
    private final By allButtonDepartment = By.id("select2-filter-by-department-container");
    private final By selectDepartment = By.id("filter-by-department");
    private final By allQualityAssuranceText = By.xpath("//div[@class='position-list-item-wrapper bg-light']/p[contains(text(), 'Assurance Engineer')]");
    private final By allIstanbulTurkeyText = By.xpath("//div[contains(text(), 'Istanbul, Turkey')]");
    private final By viewRoleButton = By.xpath("//a[@href='https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc']");
    public QAPositionsPage(WebDriver driver) {
        super(driver);
    }

    public void filterByLocation() throws InterruptedException {
        scrollByAmount(0,200);
        sleep(5);
        clickTo(allButtonLocation);
        sleep(1);
        elementVisible(locationIstanbulTurkey);
        selectFromDropdownAndClick(locationIstanbulTurkey,"Istanbul, Turkey");

    }
    public void filterByDepartment() throws InterruptedException {
        sleep(4);
        clickTo(allButtonDepartment);
        sleep(2);
        elementVisible(selectDepartment);
        selectFromDropdownAndClick(selectDepartment,"Quality Assurance");
        clickTo(allButtonDepartment);
    }
    public void viewRoleHover(){
        scrollByAmount(0,350);
    }
    public void viewRoleClick() throws InterruptedException {
        sleep(2);
        hoverOverElement(viewRoleButton);
        sleep(1);
        clickTo(viewRoleButton);
    }
    public WebElement locationIstanbulControl(){
        return findElement(locationIstanbulTurkey);
    }
    public WebElement departmentQAssuranceControl(){
        return findElement(selectDepartment);
    }
    public void assertText(){
        asserTextElements(allQualityAssuranceText,"Assurance Engineer");
        asserTextElements(allIstanbulTurkeyText,"Istanbul, Turkey");
    }
}
