package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemOutOfStockDTO {
    private String itemId;
    private String itemName;
    private String supplierName;
    private String supplierContactNo;
    private String supplierEmail;
    private int stock;


}