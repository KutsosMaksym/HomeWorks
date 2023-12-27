package HWsAPI.HW23;

import HWsAPI.HW23.dto.CheckOutDTO;
import HWsAPI.HW23.dto.LoginResponseDTO;
import HWsAPI.HW23.dto.ShoppingCartResponseDTO;
import HWsAPI.HW23.dto.UserDTO;
import HWsAPI.HW23.services.BookcartService;
import io.restassured.response.Response;
import listeners.ApiTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import org.testng.annotations.Listeners;


@Listeners(ApiTestListener.class)
public class BookcartApiTest {
    BookcartService bookcartService = new BookcartService();

    @Test
    public void createNewUser() {
        UserDTO userDTO = TestData.buildDefaultUserData();
        Response response = bookcartService.createNewUser(userDTO);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void tryToCreateUserWithoutGenderData() {
        UserDTO userDTO = TestData.buildtUserWithoutGenderData();
        Response response = bookcartService.createNewUser(userDTO);
        Assert.assertEquals(response.getStatusCode(), 500);
    }

    @Test
    public void login() {
        UserDTO userDTO = TestData.buildDefaultUserData();
        bookcartService.createNewUser(userDTO);

        Response response = bookcartService.login(userDTO);
        LoginResponseDTO loginResponseDTO = response.then().statusCode(200).extract().as(LoginResponseDTO.class);
        Assert.assertEquals(loginResponseDTO.getUserDetails().getUsername(), userDTO.getUsername());
    }

    @Test
    public void tryLoginWithWrongPassword() {
        UserDTO userDTO = TestData.buildDefaultUserData();
        bookcartService.createNewUser(userDTO);
        userDTO.setPassword(userDTO.getPassword() + "W");

        Response response = bookcartService.login(userDTO);
        response.then().statusCode(401);
    }

    @Test
    public void addBookToCart() {
        UserDTO userDTO = TestData.buildDefaultUserData();
        bookcartService.createNewUser(userDTO);
        Response loginResponse = bookcartService.login(userDTO);

        LoginResponseDTO loginResponseDTO = loginResponse.then().statusCode(200).extract().as(LoginResponseDTO.class);
        bookcartService.addToCart(loginResponseDTO.getUserDetails().getUserId(), 40);
        Response addToCartResponse = bookcartService.addToCart(loginResponseDTO.getUserDetails().getUserId(), 40);

        Assert.assertEquals(addToCartResponse.as(Integer.class), 2);
    }


    @Test //failed
    public void tryToAddNonExistentBookToCart() {
        UserDTO userDTO = TestData.buildDefaultUserData();
        bookcartService.createNewUser(userDTO);

        Response loginResponse = bookcartService.login(userDTO);
        LoginResponseDTO loginResponseDTO = loginResponse.then().statusCode(200).extract().as(LoginResponseDTO.class);

        Response addToCartResponse = bookcartService.addToCart(loginResponseDTO.getUserDetails().getUserId(), 7777777);
        Assert.assertNotEquals((addToCartResponse.as(Integer.class)), 1);
    }


    @Test
    public void checkShoppingCart() {
        UserDTO userDTO = TestData.buildDefaultUserData();
        bookcartService.createNewUser(userDTO);
        Response loginResponse = bookcartService.login(userDTO);

        LoginResponseDTO loginResponseDTO = loginResponse.then().statusCode(200).extract().as(LoginResponseDTO.class);
        bookcartService.addToCart(loginResponseDTO.getUserDetails().getUserId(), 41);

        Response response = bookcartService.getShoppingCart(loginResponseDTO.getUserDetails().getUserId());
        response.then().statusCode(200);
        List<ShoppingCartResponseDTO> shoppingCartResponse = response.jsonPath().getList("", ShoppingCartResponseDTO.class);
        Assert.assertEquals(shoppingCartResponse.get(0).getBook().getTitle(), "The Hate U Give");
    }

    @Test
    public void checkCartNonExistentUser() {
        Response response = bookcartService.getShoppingCart(999999998);
        response.then().statusCode(200);
        List<ShoppingCartResponseDTO> shoppingCartResponse = response.jsonPath().getList("", ShoppingCartResponseDTO.class);
        Assert.assertTrue(shoppingCartResponse.isEmpty());
    }

    @Test
    public void checkout() {
        UserDTO userDTO = TestData.buildDefaultUserData();
        bookcartService.createNewUser(userDTO);
        Response loginResponse = bookcartService.login(userDTO);

        LoginResponseDTO loginResponseDTO = loginResponse.then().statusCode(200).extract().as(LoginResponseDTO.class);
        Response addToCartResponse = bookcartService.addToCart(loginResponseDTO.getUserDetails().getUserId(), 41);

        Response getShoppingCartResponse = bookcartService.getShoppingCart(loginResponseDTO.getUserDetails().getUserId());
        getShoppingCartResponse.then().statusCode(200);
        List<ShoppingCartResponseDTO> shoppingCartResponse = getShoppingCartResponse.jsonPath().getList("", ShoppingCartResponseDTO.class);

        CheckOutDTO checkOut = TestData.buildCheckoutData(shoppingCartResponse, addToCartResponse.as(Integer.class));
        Response checkoutResponse = bookcartService.checkout(loginResponseDTO.getUserDetails().getUserId(), checkOut, loginResponseDTO.getToken());
        checkoutResponse.then().statusCode(200);

        getShoppingCartResponse = bookcartService.getShoppingCart(loginResponseDTO.getUserDetails().getUserId());
        getShoppingCartResponse.then().statusCode(200);
        shoppingCartResponse = getShoppingCartResponse.jsonPath().getList("", ShoppingCartResponseDTO.class);
        Assert.assertTrue(shoppingCartResponse.isEmpty());
    }

    @Test
    public void tryCheckoutWithInvalidToken() {
        UserDTO userDTO = TestData.buildDefaultUserData();
        bookcartService.createNewUser(userDTO);
        Response loginResponse = bookcartService.login(userDTO);

        LoginResponseDTO loginResponseDTO = loginResponse.then().statusCode(200).extract().as(LoginResponseDTO.class);
        Response addToCartResponse = bookcartService.addToCart(loginResponseDTO.getUserDetails().getUserId(), 41);

        Response getShoppingCartResponse = bookcartService.getShoppingCart(loginResponseDTO.getUserDetails().getUserId());
        getShoppingCartResponse.then().statusCode(200);
        List<ShoppingCartResponseDTO> shoppingCartResponse = getShoppingCartResponse.jsonPath().getList("", ShoppingCartResponseDTO.class);

        CheckOutDTO checkOut = TestData.buildCheckoutData(shoppingCartResponse, addToCartResponse.as(Integer.class));
        Response checkoutResponse = bookcartService.checkout(loginResponseDTO.getUserDetails().getUserId(), checkOut, "wrong token");
        checkoutResponse.then().statusCode(401);
    }

}