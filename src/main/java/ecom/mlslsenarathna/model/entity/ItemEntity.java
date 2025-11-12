package ecom.mlslsenarathna.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    private String itemId;
    private String itemName;
    private String itemSupplierId;
    private String description;
    private String color;
    private double size;
    private int stockCount;
    private String manufactureCountry;
    private double supplierPrice;
    private double sellPrice;

}
