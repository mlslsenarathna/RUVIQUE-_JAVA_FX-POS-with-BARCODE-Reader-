package ecom.mlslsenarathna.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeFingerPrintDTO {
    private String nationalId;
    private byte[] fingerprintTemplate;
}
