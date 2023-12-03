package HWS.HW17.pages;

import HWS.globalPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {
    ArrayList<WebElement> products;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToLinkedinPage() {
        driver.findElement(By.cssSelector("a[href*='https://www.linkedin.com/company/sauce-labs/'")).click();
    }

    public void openBurgerMenu() {
        clickButton(driver.findElement(By.cssSelector("#react-burger-menu-btn")));
    }

    public void logout() {
        openBurgerMenu();
        clickButton(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logout_sidebar_link"))));
    }

    public void recordProductInCurrentOrder() {
        products = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']"));
        products.addAll(elements);
    }

    public WebElement getFirstItem() {
        recordProductInCurrentOrder();
        return products.get(0);
    }

    public String getProductTitle(WebElement product) {
        return product.findElement(By.cssSelector(".inventory_item_name ")).getText();
    }

    public void openFilterList() {
        clickButton(driver.findElement(By.cssSelector(".product_sort_container")));
    }

    public void filterByPriceHighToLow() {
        openFilterList();
        clickButton(driver.findElement(By.xpath("//option[@value='hilo']")));
    }

    public void addToCart(WebElement product) {
        clickButton(product.findElement(By.cssSelector("button")));
    }

    public void openCart() {
        clickButton(driver.findElement(By.cssSelector(".shopping_cart_link")));
    }

}
