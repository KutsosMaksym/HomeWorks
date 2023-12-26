package HWsAPI.HW23.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailsDTO {
    private int userId;
    private Object firstName;
    private Object lastName;
    private String username;
    private Object password;
    private Object gender;
    private int userTypeId;
}
