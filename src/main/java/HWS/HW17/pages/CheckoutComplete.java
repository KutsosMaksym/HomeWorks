package HWS.HW17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete extends BasePage {

    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }


    public String getTitle() {
        return driver.findElement(By.cssSelector(".title")).getText();
    }

    public void backHome() {
        clickButton(driver.findElement(By.cssSelector("#back-to-products")));
    }
}
