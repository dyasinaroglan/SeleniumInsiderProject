package utils;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
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

    protected static WebDriver driver;
    protected static ChromeOptions chromeOptions;
    protected static FirefoxOptions firefoxOptions;

    protected  Logger logger = LoggerFactory.getLogger(getClass());

    @BeforeClass
    public static WebDriver setup(Browsers browsers) {
        if (driver == null) {
            switch (browsers) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    chromeOptions = setChromeOptions();
                    driver = new ChromeDriver(setChromeOptions());
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    firefoxOptions = setFireFoxOptions();
                    driver = new FirefoxDriver(setFireFoxOptions());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    chromeOptions = setChromeOptions();
                    driver = new ChromeDriver(setChromeOptions());
            }
            if(driver != null){
                customizeDriver(driver);
            }
        }
        return driver;
    }
    private static ChromeOptions setChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--no-proxy-server");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        return chromeOptions;
    }
    private static FirefoxOptions setFireFoxOptions(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-notifications");
        firefoxOptions.addArguments("--remote-allow-origins=*");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--ignore-certificate-errors");
        firefoxOptions.addArguments("--disable-web-security");
        firefoxOptions.addArguments("--no-proxy-server");
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--disable-gpu");
        return firefoxOptions;
    }
    private static void customizeDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
