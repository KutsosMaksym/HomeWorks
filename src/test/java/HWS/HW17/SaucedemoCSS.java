package HWS.HW17;

import HWS.HW16.BaseTest;
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

public class SaucedemoCSS extends BaseTest {
    @Test
    public void Saucedemo (){
        driver.get("https://www.saucedemo.com/");
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        WebElement buttonLogin = driver.findElement(By.cssSelector("#login-button"));
        buttonLogin.click();
        WebElement linkedinIcon = driver.findElement(By.cssSelector("a[href*=\"https://www.linkedin.com/company/sauce-labs/\""));
        linkedinIcon.click();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*=\"/?trk=organization_guest_nav-header-logo\"]"))).isDisplayed());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        driver.navigate().back();
    }
}
