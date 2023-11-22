package HWS.HW17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    private void setStandardUserName() {
        setText(driver.findElement(By.cssSelector("#user-name")), "standard_user");
    }

    public void setCommonPassword() {
        setText(driver.findElement(By.cssSelector("#password")), "secret_sauce");
    }

    public void submit() {
        clickButton(driver.findElement(By.cssSelector("#login-button")));
    }

    public void loginAsStandardUserName() {
        setStandardUserName();
        setCommonPassword();
        submit();
    }

}
