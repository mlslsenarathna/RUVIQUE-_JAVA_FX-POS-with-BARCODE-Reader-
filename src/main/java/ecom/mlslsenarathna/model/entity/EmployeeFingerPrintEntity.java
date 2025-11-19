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
@Table(name = "employee_fingerPrint")
public class EmployeeFingerPrintEntity {
    @Id
    private String employeeId;
    private String nationalId;
    private byte[] fingerprintTemplate;
}
