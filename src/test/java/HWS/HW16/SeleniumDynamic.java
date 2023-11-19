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
import java.util.ArrayList;

public class SeleniumDynamic extends BaseTest {
    @Test
    public void addBoxes() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement buttonAddBox = driver.findElement(By.id("adder"));
        buttonAddBox.click();
        buttonAddBox.click();
        buttonAddBox.click();
        ArrayList<WebElement> boxes = new ArrayList<>();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boxes.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box0"))));
        boxes.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box1"))));
        boxes.add(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box2"))));
        Assert.assertEquals(boxes.size(), 3);
    }

    @Test
    public void inputText() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement buttonNewInput = driver.findElement(By.id("reveal"));
        buttonNewInput.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed"))).isDisplayed());
    }
}
