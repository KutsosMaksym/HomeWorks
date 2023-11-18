package HWS.HW15;

import HWS.TestHelper.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BstackdemoTest extends BaseTest {
    @Test
    public void addProductsToBasket() {
        driver.get("https://www.bstackdemo.com/");
        BstackdemoPage bstackdemoPage = new BstackdemoPage(driver);
        String iphoneXsName = "iPhone XS";
        WebElement buttonAddIphoneXs = bstackdemoPage.buttonAddProduct(iphoneXsName);
        buttonAddIphoneXs.click();
        String Pixel13Name = "Pixel 3";
        WebElement buttonPixel3 = bstackdemoPage.buttonAddProduct(Pixel13Name);
        buttonPixel3.click();
        WebElement bagNameIphoneXs = driver.findElement(By.xpath("(//div[@class='float-cart__shelf-container']//p[@class='title'])[1]"));
        WebElement bagPriceIphoneXs = driver.findElement(By.xpath("(//div[@class='float-cart__shelf-container']//div[@class='shelf-item__price'])[1]/p"));
        WebElement bagQuantityIphoneXs = driver.findElement(By.xpath("(//div[@class='float-cart__shelf-container']//p[@class='desc'])[1]"));
        WebElement bagNamePixel3 = driver.findElement(By.xpath("(//div[@class='float-cart__shelf-container']//p[@class='title'])[2]"));
        WebElement bagPricePixel3 = driver.findElement(By.xpath("(//div[@class='float-cart__shelf-container']//div[@class='shelf-item__price'])[2]/p"));
        WebElement bagQuantityPixel3 = driver.findElement(By.xpath("(//div[@class='float-cart__shelf-container']//p[@class='desc'])[2]"));
        WebElement buttonCheckout = driver.findElement(By.xpath("//div[@class='buy-btn']"));
        WebElement buttonSubtotalBag = driver.findElement(By.xpath("//p[@class='sub-price__val']"));
        Assert.assertEquals(bagNameIphoneXs.getText(), iphoneXsName);
        Assert.assertEquals(bagPriceIphoneXs.getText().replaceAll("\\s", ""), "$549.00");
        Assert.assertTrue(bagQuantityIphoneXs.getText().contains("Quantity: 1"));
        Assert.assertEquals(bagNamePixel3.getText(), Pixel13Name);
        Assert.assertEquals(bagPricePixel3.getText().replaceAll("\\s", ""), "$599.00");
        Assert.assertTrue(bagQuantityPixel3.getText().contains("Quantity: 1"));
        Assert.assertTrue(bagQuantityPixel3.getText().contains("Quantity: 1"));
        Assert.assertEquals(buttonCheckout.getText(), "CHECKOUT");
        Assert.assertEquals(buttonSubtotalBag.getText(), "$ 1148.00");
    }

    @Test
    public void removeProductFromBasket() {
        driver.get("https://www.bstackdemo.com/");
        BstackdemoPage bstackdemoPage = new BstackdemoPage(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonAddIphone11 = bstackdemoPage.buttonAddProduct("iPhone 11");
        buttonAddIphone11.click();
        WebElement buttonRemoveProductFromBasket = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='shelf-item__del']")));
        buttonRemoveProductFromBasket.click();
        WebElement emptyBagText = driver.findElement(By.xpath("//div[@class='float-cart__shelf-container']/p"));
        WebElement bagCounter = driver.findElement(By.xpath("//span[@class='bag__quantity']"));
        WebElement buttonCheckout = driver.findElement(By.xpath("//div[@class='buy-btn']"));
        WebElement buttonSubtotalBag = driver.findElement(By.xpath("//p[@class='sub-price__val']"));
        Assert.assertEquals(emptyBagText.getText(), "Add some products in the bag\n:)");
        Assert.assertEquals(bagCounter.getText(), "0");
        Assert.assertEquals(buttonCheckout.getText(), "CONTINUE SHOPPING");
        Assert.assertEquals(buttonSubtotalBag.getText(), "$ 0.00");
    }
}
