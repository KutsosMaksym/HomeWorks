package HWsAPI.HW23.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private double price;
    private String coverFileName;
}
