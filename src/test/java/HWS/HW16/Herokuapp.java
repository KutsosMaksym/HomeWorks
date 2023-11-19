package HWS.HW16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Herokuapp extends BaseTest {
    @Test
    public void hiddenElement() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        WebElement example1 = driver.findElement(By.xpath("//a[text()='Example 1: Element on page that is hidden']"));
        example1.click();
        WebElement start = driver.findElement(By.xpath("//button[text()='Start']"));
        start.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        Assert.assertEquals(helloWorld.getText(), "Hello World!");
    }

    @Test
    public void renderedElement() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        WebElement example1 = driver.findElement(By.xpath("//a[text()='Example 2: Element rendered after the fact']"));
        example1.click();
        WebElement start = driver.findElement(By.xpath("//button[text()='Start']"));
        start.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        Assert.assertEquals(helloWorld.getText(), "Hello World!");
    }
}
