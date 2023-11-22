package HWS.HW17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends BasePage{
    public Cart(WebDriver driver) {
        super(driver);
    }

    public void checkout(){
        clickButton(driver.findElement(By.cssSelector("#checkout")));
    }
}
