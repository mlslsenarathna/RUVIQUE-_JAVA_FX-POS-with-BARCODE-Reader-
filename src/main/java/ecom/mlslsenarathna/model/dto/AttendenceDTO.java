package ecom.mlslsenarathna.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AttendenceDTO {
    private String attendenceId;
    private String emplyeeNIC;
    private LocalDate date;
    private LocalTime start;
    private LocalTime stop;

}
