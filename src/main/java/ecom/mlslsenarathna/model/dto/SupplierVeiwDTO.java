package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SupplierVeiwDTO {
    private String name;
    private String mobile ;
    private String address;
    private String email;
    private String country;
}
