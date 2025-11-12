package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ViewCustomerDTO {
    private String customerName;
    private String custMobileNumber;
    private String customerAddress;
    private String postalCode;
    private double totalValue;
}
