package HWS.HW23.pages;

import HWS.HW23.components.HeaderComponent;
import HWS.globalPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {
    private final HeaderComponent headerComponent;
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
    }


    public void placeOrder(String name, String address1, String address2, String pinCode, String state) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(name);
        driver.findElement(By.xpath("//input[@formcontrolname='addressLine1']")).sendKeys(address1);
        driver.findElement(By.xpath("//input[@formcontrolname='addressLine2']")).sendKeys(address2);
        driver.findElement(By.xpath("//input[@formcontrolname='pincode']")).sendKeys(pinCode);
        driver.findElement(By.xpath("//input[@formcontrolname='state']")).sendKeys(state);
        clickButton(driver.findElement(By.xpath("//span[text()='Place Order']")));
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }
}
