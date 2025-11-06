package ecom.mlslsenarathna.model.entity;

import ecom.mlslsenarathna.model.dto.AddressDTO;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerEntity {
    private String custId;
    private String custName;
    private String custMobile;
    private String sex;
    private AddressDTO custAddress;
    private LocalDate dob;
}
