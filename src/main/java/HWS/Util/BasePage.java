package HWS.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BasePage {
   public final WebDriver driver;
   public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickButton(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public boolean isElementVisible (By by){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
    }

    public void setText(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }
    public void switchDriverToLastOpenedPage(){
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }

    public void closeCurrentTab(){
        driver.close();
    }
}
