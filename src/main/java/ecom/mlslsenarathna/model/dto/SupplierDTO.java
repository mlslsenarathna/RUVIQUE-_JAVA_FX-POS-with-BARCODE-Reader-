package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupplierDTO {
    private String supplierId;
    private String supplierName;
    private String supplierContactNo;
    private String supplierEmail;
    private String supplierCountry;
    private String supplierCompanyRegistrationNo;
    private String addressId;
}
