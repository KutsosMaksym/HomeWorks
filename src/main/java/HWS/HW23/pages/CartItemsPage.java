package HWS.HW23.pages;

import HWS.HW23.components.HeaderComponent;
import HWS.globalPages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartItemsPage extends BasePage {
    private final HeaderComponent headerComponent;

    public CartItemsPage(WebDriver driver) {
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
    }

    public Boolean checkIfBookPresentByTitle(String title) {
        return isElementVisible(By.xpath("//a[text()='" + title + "']"));
    }

    public String getTotalValue() {
        return driver.findElement(By.xpath("//mat-card-content/th[last()-1]")).getText();
    }

    @Step("Open Checkout Procedure")
    public void navigateToCheckOut() {
        clickButton(driver.findElement(By.xpath("//span[text()='CheckOut']")));
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }

    public boolean isBookInCart(String title) {
        return isElementVisible(By.xpath("//a[text()='" + title + "']"));
    }
}
