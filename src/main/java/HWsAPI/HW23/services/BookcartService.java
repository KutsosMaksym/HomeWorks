package HWsAPI.HW23.services;


import HWsAPI.HW23.dto.CheckOutDTO;
import HWsAPI.HW23.dto.UserDTO;
import io.restassured.response.Response;

public class BookcartService extends BaseService {
    protected static final String userPath = "/User";
    protected static final String loginPath = "/Login";
    protected static final String AddToCartPath = "/ShoppingCart/AddToCart/";
    protected static final String shoppingCartPath = "/ShoppingCart/";
    protected static final String checkoutPath = "/CheckOut/";

    public Response createNewUser(UserDTO user) {
        return setRequestSpec()
                .body(user)
                .when().post(userPath);
    }

    public Response login(UserDTO user) {
        return setRequestSpec()
                .body(user)
                .when().post(loginPath);
    }

    public Response addToCart(int userId, int bookId) {
        return setRequestSpec()
                .when()
                .post(AddToCartPath + userId + "/" + bookId);
    }

    public Response getShoppingCart(int userId) {
        return setRequestSpec()
                .when()
                .get(shoppingCartPath + userId);
    }

    public Response checkout(int userId, CheckOutDTO checkOutDTO, String token) {
        return setRequestSpec()
                .header("Authorization","Bearer " + token)
                .body(checkOutDTO)
                .when().post(checkoutPath + userId);
    }
}
