package HWS.HW21.pagesSelenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    ElementsCollection products;

    public void openFilterList() {
        $(".product_sort_container").click();
    }

    public void filterByPriceHighToLow() {
        openFilterList();
        $x("//option[@value='hilo']").click();
    }

    public void recordProductInCurrentOrder() {
        products = $$x("//div[@class='inventory_list']//div[@class='inventory_item']");
    }

    public SelenideElement getFirstItem() {
        recordProductInCurrentOrder();
        return products.get(0);
    }

    public String getProductTitle(SelenideElement product) {
        return product.$(".inventory_item_name ").getText();
    }
    public void addToCart(SelenideElement product) {
        product.$("button").click();
    }

    public void openCart() {
        $(".shopping_cart_link").click();
    }

    public void logout() {
        openBurgerMenu();
        $("#logout_sidebar_link").click();
    }

    public void openBurgerMenu() {
        $("#react-burger-menu-btn").click();
    }
}

