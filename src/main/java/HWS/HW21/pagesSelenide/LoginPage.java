package HWS.HW21.pagesSelenide;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement username = $("#user-name");
    SelenideElement password = $("#password");
    SelenideElement loginButton = $("#login-button");

    private void setUserName(String username) {
        this.username.setValue(username);
    }

    public void setPassword(String password) {
        this.password.setValue(password);
    }

    public void login(String username, String password) {
        setUserName(username);
        setPassword(password);
        loginButton.click();
    }
}
