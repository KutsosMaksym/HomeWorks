package HWS.HW19.pages;

import HWS.HW19.componentes.HeaderComponent;
import HWS.globalPages.BasePage;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    HeaderComponent headerComponent;
    public MainPage(WebDriver driver) {
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
    }
    public void openMainPage(){
        driver.get("https://automationexercise.com/");
    }

    public void openContactUsPage() { // Do I need this method? Or better to use HeaderComponent directly?
        headerComponent.navigateToContactUsPage();
    }
}
