package HWS.HW17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStep2 extends BasePage {
    public CheckoutStep2(WebDriver driver) {
        super(driver);
    }

    public String getTotalPrice() {
        return driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
    }

    public void finish() {
        clickButton(driver.findElement(By.cssSelector("#finish")));
    }
}
