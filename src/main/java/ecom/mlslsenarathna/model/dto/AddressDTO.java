package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AddressDTO {
    private String addressId;
    private String addressLine1;
    private String adddressLine2;
    private String city;
    private String district;
    private String postalCode;
}
