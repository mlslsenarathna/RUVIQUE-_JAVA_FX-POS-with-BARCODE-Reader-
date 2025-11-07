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
@Table(name = "address")
public class AddressEntity {
        @Id
        private String addressId;
        private String addressLine1;
        private String adddressLine2;
        private String city;
        private String district;
        private String postalCode;
}
