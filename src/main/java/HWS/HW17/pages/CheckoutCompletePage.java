package HWS.HW17.pages;

import HWS.globalPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }


    public String getTitle() {
        return driver.findElement(By.cssSelector(".title")).getText();
    }

    public void backHome() {
        clickButton(driver.findElement(By.cssSelector("#back-to-products")));
    }
}
