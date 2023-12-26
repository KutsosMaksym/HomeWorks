package HWS.HW23.pages;

import HWS.HW23.components.HeaderComponent;
import HWS.globalPages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private final HeaderComponent headerComponent;
    public MainPage(WebDriver driver) {
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
    }
    @Step("Open Main Page")
    public void openMainPage(){
        driver.get("https://bookcart.azurewebsites.net/");
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }
    @Step("Add first Item to Cart")
    public void addFirstItemToCart() throws InterruptedException {
        clickButton(driver.findElement(By.xpath("//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']")));
    }
}
