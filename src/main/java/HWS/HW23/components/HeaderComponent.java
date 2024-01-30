package HWS.HW23.components;

import HWS.globalPages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage {
    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void searchBook(String keyWord) {
        waitPageLoad();
        driver.findElement(By.xpath("//input[@placeholder='Search books or authors']")).sendKeys(keyWord);
        clickButton(driver.findElement(By.xpath("//span[text()=' " + keyWord + " ']")));
    }

    public void openCart() {
        clickButton(driver.findElement(By.xpath("//mat-icon[text()='shopping_cart']")));
    }

    @Step("Open Cart")
    public int cartCount() {
        return Integer.parseInt(driver.findElement(By.xpath("//span[@id='mat-badge-content-0']")).getText());
    }
}
