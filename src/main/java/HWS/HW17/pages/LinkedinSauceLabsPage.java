package HWS.HW17.pages;

import HWS.Util.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkedinSauceLabsPage extends BasePage {
    public LinkedinSauceLabsPage(WebDriver driver) {
        super(driver);
    }
    public By getLinkedinIcon (){
    return By.cssSelector("a[href*='/?trk=organization_guest_nav-header-logo']");
    }

}
