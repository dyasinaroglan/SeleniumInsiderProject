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

    public WebDriver driver;   // burada herkes kafasına göre setlemesin, değer vermesin
    public FluentWait<WebDriver> wait;

    Actions actions;

    public JavascriptExecutor js;
    public BaseMethods(WebDriver driver){
        this.driver = driver; // hangi webDriver, constructor yapmazsak driver null olarak dönecek, bu driver Driver class'ından alınan driver demek istiyoruz
        this.wait = new FluentWait<>(this.driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
        this.js = (JavascriptExecutor) driver;
        /*
        constructor'da driver adında bir parametre tanımlanmış bu parametrenin adı, sınıfın içinde tanımlanan driver instance değişkeni ile aynı
        Eğer this kullanılmazsa Java hangi driver değişkeninin kullanılması gerektiğini anlayamaz. this.driver = driver; ifadesiyle class'da yer alan instance değişkeninin
        constructor'dan gelen driver parametresiyle başlatılması gerektiğini belirtmiş oluyoruz.
        this kullanılmasaydı driver değişkeni başlatılmamış olurdu ve null kalırdı

        this anahtar kelimesi, sınıfın instance değişkenleri ile metod veya constructor içinde tanımlanan yerel değişkenler arasındaki karışıklığı önlemek için kullanılır.
         */
    }
    public WebElement findElement (By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickTo(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        logger.info(" Clicked on the element.");

    }
    public void sendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
        logger.info(text + " The value was entered.");
    }
    public void elementVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("The element was successfully located and became visible.");
    }
    public void elementDisable(By locator){
         driver.findElement(locator).isDisplayed();
    }
    public void scrollTo(By locator){
        WebElement element = driver.findElement(locator);
        String text = findElement(locator).getText();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
        logger.info("Element " + text + " kaydırılarak görüntülendi.");
    }
    public void sleep(int second) throws InterruptedException {
        Thread.sleep(second * 1000);
        logger.info(second + " Waited for seconds.");
    }
    public void scrollByAmount(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }
    public void hoverOverElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }
    public void selectFromDropdownAndClick(By locator, String visibleText){
        WebElement dropdownElement = driver.findElement(locator);
        Select dropDown = new Select(dropdownElement);
        dropDown.selectByVisibleText(visibleText);
        logger.info("Selected " + visibleText + " from the dropdown.", visibleText);

        WebElement selectedOption = dropDown.getFirstSelectedOption();
        selectedOption.click();
        logger.info("Clicked on the selected item: " + visibleText);
    }
    public void switchToNewTab(){
        String firstWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()){
            if(!windowHandle.equals(firstWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        logger.info("Successfully switched to the new tab: {}", driver.getTitle());
    }
    public void verifyPageTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "The page title is not as expected!");
    }
    public void asserTextElements(By locator, String expectedText){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        boolean isTextFound = false;
        for (WebElement element : elements){
            String actualText = element.getText();
            if(actualText.contains(expectedText)){
                isTextFound = true;
                logger.info("Expected text was found within the element " + locator + " " + expectedText);
            }else {
                logger.warn("Expected text was not found within the element. Current text: ", locator, expectedText, actualText);
                logger.warn("Expected text was not found within the element. Current text: " + locator + " " + expectedText + " " + actualText);
            }
        }
        assertTrue("No element contains the expected text " + expectedText, isTextFound);
    }
}
