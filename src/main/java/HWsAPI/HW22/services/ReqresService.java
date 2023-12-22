package HWsAPI.HW22.services;

import HWsAPI.HW22.dto.UserDTO;
import io.restassured.response.Response;

public class ReqresService extends BaseService {
    protected static final String bookingPath = "/users/";
    public Response getSingleUserById(int userId) {
        return setRequestSpec().when()
                .get(bookingPath + userId);
    }
    public Response createNewBooking(UserDTO user) {
        return setRequestSpec()
                .body(user)
                .when().post(bookingPath);
    }
    public Response deleteUser(int userId) {
        return setRequestSpec()
                .when().delete(bookingPath + userId);
    }
}
