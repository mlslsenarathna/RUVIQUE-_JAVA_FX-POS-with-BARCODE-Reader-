package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemDTO {
    private String itemId;
    private String itemName;
    private String supplierId;
    private String description;
    private String color;
    private String size;
    private int stockCount;
    private String manufactureCountry;
    private double supplierPrice;
    private double sellingPrice;

}
