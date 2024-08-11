package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Driver {

    public WebDriver driver;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void startDriver(){
        drivers(Browsers.CHROME);
        driver = getDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        driver.navigate().to("https://useinsider.com/ ");

    }
    @After
    public void quitDriver(){
        driver.quit();
    }

    private void drivers(Browsers browsers) {
        switch (browsers) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
            default:
                WebDriverManager.chromedriver().setup();
        }
    }

    private WebDriver getDriver(Browsers browsers) {
        switch (browsers) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browsers);
        }
    }
}

