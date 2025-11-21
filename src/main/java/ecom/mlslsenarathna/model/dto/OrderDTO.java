package ecom.mlslsenarathna.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {
    private Long orderId;
    private LocalDateTime orderDateandTime;
    private String customerMobile;
    private double totalPrice;

}
