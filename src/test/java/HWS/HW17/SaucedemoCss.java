package HWS.HW17;

import HWS.HW17.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaucedemoCss extends BaseTest {
    @Test
    public void Saucedemo (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginAsStandardUserName();

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
        loginPage.loginAsStandardUserName();

        MainPage mainPage = new MainPage(driver);
        mainPage.filterByPriceHighToLow();
        mainPage.addToCart(mainPage.getFirstItem());
        mainPage.openCart();

        Cart cart = new Cart(driver);
        cart.checkout();

        CheckoutStep1 checkoutStep1 = new CheckoutStep1(driver);
        checkoutStep1.setPersonalInfo();
        checkoutStep1.continueCheckout();

        CheckoutStep2 checkoutStep2 = new CheckoutStep2(driver);
        Assert.assertTrue(checkoutStep2.getTotalPrice().contains("49.99"));
        checkoutStep2.finish();

        CheckoutComplete checkoutComplete = new CheckoutComplete(driver);
        Assert.assertEquals(checkoutComplete.getTitle(), "Checkout: Complete!");
        checkoutComplete.backHome();

        mainPage.logout();
    }
}
