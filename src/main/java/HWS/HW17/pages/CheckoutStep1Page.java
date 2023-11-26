package HWS.HW17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStep1Page extends BasePage{
    public CheckoutStep1Page(WebDriver driver) {
        super(driver);
    }
    private void setFirstName(String firstName){
        setText(driver.findElement(By.cssSelector("#first-name")),firstName);
    }
    private void setLastName(String lastName){
        setText(driver.findElement(By.cssSelector("#last-name")),lastName);
    }
    private void setZipCode(String zipCode){
        setText(driver.findElement(By.cssSelector("#postal-code")),zipCode);
    }
    public void setPersonalInfo(String firstName, String lastName, String zipCode){
        setFirstName(firstName);
        setLastName(lastName);
        setZipCode(zipCode);
    }
    public void continueCheckout(){
        clickButton(driver.findElement(By.cssSelector("#continue")));
    }
}
