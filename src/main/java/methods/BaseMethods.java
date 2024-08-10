package methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BaseMethods {

    public WebDriver driver;
    public FluentWait<WebDriver> wait;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    public   JavascriptExecutor js;
    public BaseMethods(WebDriver driver){
        this.driver = driver;
        this.wait = new FluentWait<>(this.driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        this.js = (JavascriptExecutor) driver;
    }
    public void clickTo(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

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

}
