package ecom.mlslsenarathna.model.dto;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderInfoDTO {
    private Long orderId;

    private String itemId;
    private int quantity;
    private double sellingPrice;
}
