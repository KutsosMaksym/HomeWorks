package HWS.HW15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BstackdemoPage {
    WebDriver driver;

    public BstackdemoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductXpath(String productName) {
        return "//p[@class='shelf-item__title' and text()='" + productName + "']/parent::*";
    }

    public WebElement buttonAddProduct(String productName) {
        return driver.findElement(By.xpath(getProductXpath(productName) + "/div[text()='Add to cart']"));
    }

    public WebElement productPrice(String productName) {
        return driver.findElement(By.xpath(getProductXpath(productName) + "//div[@class='val']"));
    }
}
