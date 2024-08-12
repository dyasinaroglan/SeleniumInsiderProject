package pageElements;

import methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseMethods{

    private final By insiderLogo = By.cssSelector("a[class='navbar-brand d-flex flex-row align-items-center'] img");
    private final By companyButton = By.cssSelector("ul[class='navbar-nav'] li:nth-child(6)");
    private final By careersButton = By.cssSelector(".new-menu-dropdown-layout-6-mid-container a[href='https://useinsider.com/careers/']");
    private final By cookies = By.id("wt-cli-accept-all-btn");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement anaSayfaControl(){
        return findElement(insiderLogo);
    }
    public void anaSayfaGiris(){
        elementVisible(insiderLogo);
        elementDisable(insiderLogo);
    }

    public void companyClick(){
        clickTo(companyButton);
        logger.info("elementine tıklandı");
    }
    public void acceptAllCookies(){
        clickTo(cookies);
    }
    public void careersClick(){
        clickTo(careersButton);
    }
}
