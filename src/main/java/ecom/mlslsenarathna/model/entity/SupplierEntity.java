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
@Table(name = "supplier")
public class SupplierEntity {
    @Id
    private String supplierId;
    private String supplierName;
    private String supplierContactNo;
    private String supplierEmail;
    private String supplierCountry;
    private String supplierCompanyRegistrationNo;
    private String addressId;
}
