package ecom.mlslsenarathna.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "attendence")
public class AttendenceEntity {
    @Id
    private String attendenceId;
    private String emplyeeNIC;
    private LocalDate date;
    private LocalTime start;
    private LocalTime stop;
}
