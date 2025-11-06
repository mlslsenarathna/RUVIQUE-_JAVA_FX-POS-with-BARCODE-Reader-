package ecom.mlslsenarathna.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {
    private String custId;
    private String custName;
    private String custMobile;
    private String sex;
    private AddressDTO custAddress;
    private LocalDate dob;

}
