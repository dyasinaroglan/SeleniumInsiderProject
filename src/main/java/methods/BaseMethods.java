package methods;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Driver;

import java.time.Duration;
import java.util.List;

import static com.mysql.cj.conf.PropertyKey.logger;
import static org.junit.Assert.assertTrue;

public class BaseMethods extends Driver {

    public WebDriver driver;
    public FluentWait<WebDriver> wait;

    Actions actions;

    public JavascriptExecutor js;
    public BaseMethods(WebDriver driver){
        this.driver = driver;
        this.wait = new FluentWait<>(this.driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        this.js = (JavascriptExecutor) driver;
        this.actions = actions;
    }
    public WebElement findElement (By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickTo(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        logger.info(locator.toString() + " elementine tıklandı");

    }
    public void sendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
        logger.info(locator + " text değeri yazıldı.");
    }
    public void elementVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element '{}' başarılı bir şekilde bulundu ve görünür hale geldi.", locator.toString());
    }
    public void elementDisable(By locator){
         driver.findElement(locator).isDisplayed();
    }
    public void scrollTo(By locator){
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(false);", element);
        logger.info("Element '{}' kaydırılarak görüntülendi.", locator.toString());
    }
    public void sleep(int second) throws InterruptedException {
        Thread.sleep(second * 1000);
        logger.info(second + " saniye beklendi.");
    }
    public void scrollByAmount(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }
    public void selectFromDropdownAndClick(By locator, String visibleText){
        WebElement dropdownElement = driver.findElement(locator);
        Select dropDown = new Select(dropdownElement);
        dropDown.selectByVisibleText(visibleText);
        logger.info("Dropdown'dan '{}' seçildi.", visibleText);

        WebElement selectedOption = dropDown.getFirstSelectedOption();
        selectedOption.click();
        logger.info("Seçilen '{}' öğesine tıklandı.", visibleText);
    }
    public void switchToNewTab(){
        String firstWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()){
            if(!windowHandle.equals(firstWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        logger.info("Yeni sekmeye başarıyla geçildi: Title: {}", driver.getTitle());
    }
    public void verifyPageTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Sayfa başlığı beklendiği gibi değil!");
    }
    public void asserTextElements(By locator, String expectedText){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        boolean isTextFound = false;
        for (WebElement element : elements){
            String actualText = element.getText();
            if(actualText.contains(expectedText)){
                isTextFound = true;
                logger.info("Element '{}' içinde beklenen '{}' metni bulundu.", locator, expectedText);
            }else {
                logger.warn("Element '{}' içinde beklenen '{}' metni bulunamadı. Mevcut metin: '{}'", locator, expectedText, actualText);
            }
        }
        assertTrue("Hiçbir element içinde beklenen metin bulunamadı: " + expectedText, isTextFound);
    }
}
