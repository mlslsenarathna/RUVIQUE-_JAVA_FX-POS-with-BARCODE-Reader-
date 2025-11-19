package ecom.mlslsenarathna.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class WorkingTimeCalculatorService {


    public Long getMinuts(LocalTime startTime, LocalTime endTime) {
        long rawMinutes = ChronoUnit.MINUTES.between(startTime, endTime);


        return rawMinutes;
    }

    public double getHours(LocalTime startTime, LocalTime endTime) {
        double hours=ChronoUnit.HOURS.between(startTime, endTime);
        return hours;
    }
    public  double getDays(double hours) {
        double days=hours/24;
        return days;
    }


}





