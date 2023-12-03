package HWS.HW17.pages;

import HWS.globalPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    private void setStandardUserName(String username) {
        setText(driver.findElement(By.cssSelector("#user-name")), username);
    }

    public void setCommonPassword(String password) {
        setText(driver.findElement(By.cssSelector("#password")), password);
    }

    public void submit() {
        clickButton(driver.findElement(By.cssSelector("#login-button")));
    }

    public void login(String username, String password) {
        setStandardUserName(username);
        setCommonPassword(password);
        submit();
    }

}
