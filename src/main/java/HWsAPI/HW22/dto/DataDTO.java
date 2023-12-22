package HWsAPI.HW22.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataDTO {
    @JsonProperty("id") int id;
    @JsonProperty("email") String email;
    @JsonProperty("first_name") String first_name;
    @JsonProperty("last_name") String last_name;
    @JsonProperty("avatar") String avatar;
}
