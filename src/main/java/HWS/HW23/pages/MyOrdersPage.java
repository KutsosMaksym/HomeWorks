package HWS.HW23.pages;

import HWS.HW23.components.HeaderComponent;
import HWS.globalPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyOrdersPage extends BasePage {
    private final HeaderComponent headerComponent;

    public MyOrdersPage(WebDriver driver) {
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }

    public String getTotalPrice() {
        isElementVisible(By.xpath("//tbody/tr/td[3]"));
        return driver.findElement(By.xpath("//tbody/tr/td[3]")).getText();
    }
}
