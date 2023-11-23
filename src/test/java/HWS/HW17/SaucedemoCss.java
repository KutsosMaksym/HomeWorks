package HWS.HW17;

import HWS.HW17.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedemoCss extends BaseTest {
    @Test
    public void Saucedemo (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("standard_user", "secret_sauce");

        MainPage mainPage = new MainPage(driver);
        mainPage.goToLinkedinPage();

        LinkedinSauceLabsPage linkedinPage= new LinkedinSauceLabsPage(driver);
        linkedinPage.switchDriverToLastOpenedPage();
        Assert.assertTrue(linkedinPage.isElementVisible(linkedinPage.getLinkedinIcon()));

        linkedinPage.closeCurrentTab();
        mainPage.switchDriverToLastOpenedPage();
        mainPage.logout();
    }

    @Test
    public void buyMostExpensiveProduct (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login("standard_user", "secret_sauce");

        MainPage mainPage = new MainPage(driver);
        mainPage.filterByPriceHighToLow();
        String firstProductTitle = mainPage.getProductTitle(mainPage.getFirstItem());
        Assert.assertEquals(firstProductTitle, "Sauce Labs Fleece Jacket");
        mainPage.addToCart(mainPage.getFirstItem());
        mainPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkout();

        CheckoutStep1Page checkoutStep1Page = new CheckoutStep1Page(driver);
        checkoutStep1Page.setPersonalInfo("Peter", "Parker", "11375");
        checkoutStep1Page.continueCheckout();

        CheckoutStep2Page checkoutStep2Page = new CheckoutStep2Page(driver);
        Assert.assertTrue(checkoutStep2Page.getTotalPrice().contains("49.99"));
        Assert.assertEquals(checkoutStep2Page.getFirstItemTitle(), firstProductTitle);
        checkoutStep2Page.finish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertEquals(checkoutCompletePage.getTitle(), "Checkout: Complete!");
        checkoutCompletePage.backHome();

        mainPage.logout();
    }
}
