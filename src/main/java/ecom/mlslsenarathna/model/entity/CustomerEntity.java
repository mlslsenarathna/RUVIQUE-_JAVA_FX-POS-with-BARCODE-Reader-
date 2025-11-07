package ecom.mlslsenarathna.model.entity;

import ecom.mlslsenarathna.model.dto.AddressDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    private String custId;
    private String custName;
    private String custMobile;
    private String sex;
    private String addressId;
    private LocalDate dob;
}
