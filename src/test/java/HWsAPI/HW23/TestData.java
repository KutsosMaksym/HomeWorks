package HWsAPI.HW23;

import HWsAPI.HW23.dto.CheckOutDTO;
import HWsAPI.HW23.dto.ShoppingCartResponseDTO;
import HWsAPI.HW23.dto.UserDTO;
import com.github.javafaker.Faker;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestData {
    static Faker faker = new Faker();
    public static UserDTO buildDefaultUserData() {
        return   UserDTO.builder()
                .userId(0)
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .password(faker.address().buildingNumber())
                .gender("male")
                .userTypeId(faker.random().nextInt(1,1000))
                .build();
    }
    public static UserDTO buildtUserWithoutGenderData() {
        return   UserDTO.builder()
                .userId(0)
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .username(faker.name().username())
                .password(faker.address().buildingNumber())
                .gender(null)
                .userTypeId(faker.random().nextInt(1,1000))
                .build();
    }

    public static CheckOutDTO buildCheckoutData(List<ShoppingCartResponseDTO> shoppingCartResponseDTO, int cartTotal){
        Instant currentTime = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String formattedTime = formatter.format(currentTime.atOffset(ZoneOffset.UTC));
        return CheckOutDTO.builder()
                .orderId(faker.random().nextInt(70000,1000000) + "s")
                .orderDetails(shoppingCartResponseDTO)
                .cartTotal(cartTotal)
                .orderDate(formattedTime)
                .build();

    }
}
