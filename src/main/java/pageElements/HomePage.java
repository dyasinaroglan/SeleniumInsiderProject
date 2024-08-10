package pageElements;

import methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseMethods{

    public final By insiderLogo = By.cssSelector("a[class='navbar-brand d-flex flex-row align-items-center'] img");
    public final By companyButton = By.cssSelector("ul[class='navbar-nav'] li:nth-child(6)");
    public final By careersButton = By.cssSelector(".new-menu-dropdown-layout-6-mid-container a:nth-child(2)");
    public final By cookies = By.id("wt-cli-accept-all-btn");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void anaSayfaGiris(){
        elementVisible(insiderLogo);
        elementDisable(insiderLogo);
    }
    public void companyClick(){
        clickTo(companyButton);
    }
    public void acceptAllCookies(){
        clickTo(cookies);
    }
    public void careersClick(){
        clickTo(careersButton);
    }
}
