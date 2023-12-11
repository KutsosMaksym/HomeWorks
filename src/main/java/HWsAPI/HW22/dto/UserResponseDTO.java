package HWsAPI.HW22.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    @JsonProperty("name") String name;
    @JsonProperty("job") String job;
    @JsonProperty("id") int id;
    @JsonProperty("createdAt") Date createdAt;
}
