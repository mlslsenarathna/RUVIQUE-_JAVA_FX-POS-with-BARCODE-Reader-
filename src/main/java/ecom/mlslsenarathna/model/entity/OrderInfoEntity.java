package ecom.mlslsenarathna.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "orderinfo")
@IdClass(OrderInfoId.class)
public class OrderInfoEntity {
    @Id
    private Long orderId;
    @Id
    private String itemId;
    private int quantity;
    private double sellingPrice;

}
