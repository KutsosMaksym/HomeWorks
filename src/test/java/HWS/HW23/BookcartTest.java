package HWS.HW23;

import HWS.HW23.pages.*;
import HWS.UtilTest.BaseTest;
import HWsAPI.HW23.TestData;
import HWsAPI.HW23.dto.LoginResponseDTO;
import HWsAPI.HW23.dto.UserDTO;
import HWsAPI.HW23.services.BookcartService;
import io.restassured.response.Response;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookcartTest extends BaseTest {
    BookcartService bookcartService = new BookcartService();
    String title = "Slayer";
    String price = "₹1,234.00";
    @Test
    @Description("E2E test")
    public void toBuyBookE2E() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();

        mainPage.getHeaderComponent().searchBook(title);
        mainPage.addFirstItemToCart();

        UserDTO userDTO = TestData.buildDefaultUserData();
        bookcartService.createNewUser(userDTO);
        Response response = bookcartService.login(userDTO);
        response.then().statusCode(200).extract().as(LoginResponseDTO.class);

        Assert.assertEquals(mainPage.getHeaderComponent().cartCount(), 1);
        mainPage.getHeaderComponent().openCart();

        CartItemsPage cartItemsPage = new CartItemsPage(driver);
        Assert.assertTrue(cartItemsPage.checkIfBookPresentByTitle(title));
        Assert.assertEquals(cartItemsPage.getTotalValue(), price);

        cartItemsPage.navigateToCheckOut();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userDTO.getUsername(), userDTO.getPassword());

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        Assert.assertTrue(cartItemsPage.isBookInCart(title));
        checkOutPage.placeOrder("Max", "Via Giuseppe Garibaldi", "9/c, 24122 Bergamo BG","241221", "BG");

        MyOrdersPage myOrdersPage = new MyOrdersPage(driver);
        Assert.assertEquals(myOrdersPage.getTotalPrice(), price);
    }
}
