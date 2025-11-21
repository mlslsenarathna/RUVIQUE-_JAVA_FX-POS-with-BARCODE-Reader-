package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderCartItemDTO {
    private String id;
    private String name;
    private String size;
    private int quantity;
    private double price;

}
