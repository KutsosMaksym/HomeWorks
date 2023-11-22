package HWS.HW17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStep1 extends BasePage{
    public CheckoutStep1(WebDriver driver) {
        super(driver);
    }
    private void setFirstName(){
        setText(driver.findElement(By.cssSelector("#first-name")),"Peter");
    }
    private void setLastName(){
        setText(driver.findElement(By.cssSelector("#last-name")),"Parker");
    }
    private void setZipCode(){
        setText(driver.findElement(By.cssSelector("#postal-code")),"11375");
    }
    public void setPersonalInfo(){
        setFirstName();
        setLastName();
        setZipCode();
    }
    public void continueCheckout(){
        clickButton(driver.findElement(By.cssSelector("#continue")));
    }
}
