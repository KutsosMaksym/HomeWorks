package HWS.HW23.pages;

import HWS.HW23.components.HeaderComponent;
import HWS.globalPages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final HeaderComponent headerComponent;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
    }

    @Step("Login")
    public void login(String login, String password) {
        waitPageLoad();
        driver.findElement(By.xpath("//input[@data-placeholder='Username']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@data-placeholder='Password']")).sendKeys(password);
        clickButton(driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']")));
        if (isElementVisible(By.xpath("//mat-card-title[text()=' Shopping cart is empty ']")))
            driver.navigate().refresh();
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }
}
