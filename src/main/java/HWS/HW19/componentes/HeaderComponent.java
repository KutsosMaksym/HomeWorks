package HWS.HW19.componentes;

import HWS.globalPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage {
    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void navigateToContactUsPage(){
        clickButton(driver.findElement(By.xpath("//a[@href='/contact_us']")));
    }
}

