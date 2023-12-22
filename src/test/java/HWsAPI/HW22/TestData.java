package HWsAPI.HW22;

import HWsAPI.HW22.dto.UserDTO;
import com.github.javafaker.Faker;

public class TestData {
    public static UserDTO buildDefaultUserData() {
        Faker faker = new Faker();
        return UserDTO.builder()
                .name(faker.name().firstName())
                .job(faker.job().title())
                .build();
    }
}
