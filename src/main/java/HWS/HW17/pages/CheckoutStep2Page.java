package HWS.HW17.pages;

import HWS.globalPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStep2Page extends BasePage {
    public CheckoutStep2Page(WebDriver driver) {
        super(driver);
    }

    public String getFirstItemTitle (){
        return driver.findElement(By.cssSelector(".inventory_item_name")).getText();
    }
    public String getTotalPrice() {
        return driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
    }

    public void finish() {
        clickButton(driver.findElement(By.cssSelector("#finish")));
    }
}
