package HWsAPI.HW22;

import HWsAPI.HW22.dto.UserDTO;
import HWsAPI.HW22.dto.SingleUserResponseDTO;
import HWsAPI.HW22.dto.UserResponseDTO;
import HWsAPI.HW22.services.ReqresService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Reqres {
    ReqresService reqresService = new ReqresService();

    @Test
    public void checkGetSingleUser() {
        Response response = reqresService.getSingleUserById(2);
        SingleUserResponseDTO actualUser = response.then().statusCode(200)
                .extract().as(SingleUserResponseDTO.class);
        Assert.assertEquals(actualUser.getData().getId(), 2);
        Assert.assertEquals(actualUser.getData().getEmail(), "janet.weaver@reqres.in");
        Assert.assertEquals(actualUser.getData().getFirst_name(), "Janet");
        Assert.assertEquals(actualUser.getData().getLast_name(), "Weaver");
        Assert.assertEquals(actualUser.getData().getAvatar(), "https://reqres.in/img/faces/2-image.jpg");
        Assert.assertEquals(actualUser.getSupport().getUrl(), "https://reqres.in/#support-heading");
        Assert.assertEquals(actualUser.getSupport().getText(), "To keep ReqRes free, contributions towards server costs are appreciated!");
    }

    @Test
    public void checkGetSingleUserNotFound(){
        Response response = reqresService.getSingleUserById(23);
        response.then().statusCode(404);
    }

    @Test
    public void checkNewUserCreation(){
        UserDTO createDTO = TestData.buildDefaultUserData();
        Response response = reqresService.createNewBooking(createDTO);
        UserResponseDTO user =  response.then().statusCode(201)
                .extract().as(UserResponseDTO.class);
        Assert.assertEquals(user.getName(), createDTO.getName());
        Assert.assertEquals(user.getJob(),createDTO.getJob());
    }

    @Test
    public void checkDelete(){
        Response response = reqresService.deleteUser(2);
        response.then().statusCode(204);
    }
}
