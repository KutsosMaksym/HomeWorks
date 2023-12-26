package HWsAPI.HW23.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckOutDTO {
    private String orderId;
    private List<ShoppingCartResponseDTO> orderDetails;
    private int cartTotal;
    private String orderDate;
}
