package HWS.HW21;

import HWS.HW21.pagesSelenide.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedeniCss extends BaseTestSelenide {

    @Test
    public void Saucedemo() {
        LoginPage loginPage = openLoginPage();
        loginPage.login("standard_user", "secret_sauce");

        MainPage mainPage = new MainPage();
        mainPage.filterByPriceHighToLow();
        String firstProductTitle = mainPage.getProductTitle(mainPage.getFirstItem());
        Assert.assertEquals(firstProductTitle, "Sauce Labs Fleece Jacket");
        mainPage.addToCart(mainPage.getFirstItem());
        mainPage.openCart();

        CartPage cartPage = new CartPage();
        cartPage.checkout();
        CheckoutStep1Page checkoutStep1Page = new CheckoutStep1Page();
        checkoutStep1Page.setPersonalInfo("Peter", "Parker", "11375");
        checkoutStep1Page.continueCheckout();

        CheckoutStep2Page checkoutStep2Page = new CheckoutStep2Page();
        Assert.assertTrue(checkoutStep2Page.getTotalPrice().contains("49.99"));
        Assert.assertEquals(checkoutStep2Page.getFirstItemTitle(), firstProductTitle);
        checkoutStep2Page.finish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        Assert.assertEquals(checkoutCompletePage.getTitle(), "Checkout: Complete!");
        checkoutCompletePage.backHome();
        mainPage.logout();
        System.out.println();
    }


}
