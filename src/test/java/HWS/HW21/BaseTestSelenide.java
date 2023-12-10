package HWS.HW21;


import HWS.HW21.pagesSelenide.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;

public class BaseTestSelenide {

    @BeforeMethod
    public void setup() {
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1440x1100";
        Configuration.downloadsFolder = "foo/bar_downloads";
    }


    public LoginPage openLoginPage() {
        Selenide.open("");
        return new LoginPage();
    }
}
