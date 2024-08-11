package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Driver;

import java.time.Duration;

import static com.mysql.cj.conf.PropertyKey.logger;

public class BaseMethods extends Driver {

    public WebDriver driver;
    public FluentWait<WebDriver> wait;

    Actions actions;

    public   JavascriptExecutor js;
    public BaseMethods(WebDriver driver){
        this.driver = driver;
        this.wait = new FluentWait<>(this.driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        this.js = (JavascriptExecutor) driver;
        this.actions = actions;
    }
    public void clickTo(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        logger.info("elementine tıklandı");

    }
    public void sendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
        logger.info(locator + " text değeri yazıldı.");
    }
    public void elementVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void elementDisable(By locator){
         driver.findElement(locator).isDisplayed();
    }
    public void scrollTo(By locator){
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }
    public void sleep(int second) throws InterruptedException {
        Thread.sleep(second * 1000);
    }
    public void scrollByAmount(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }
    public void hoverOverElement(By locator){
        actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
        logger.info("Mouse, elementin üzerine getirildi: Locator: {}", locator);
    }
}
