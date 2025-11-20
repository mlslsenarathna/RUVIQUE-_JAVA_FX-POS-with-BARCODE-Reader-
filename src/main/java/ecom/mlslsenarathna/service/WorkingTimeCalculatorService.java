package ecom.mlslsenarathna.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class WorkingTimeCalculatorService {


    public double getHours(LocalTime startTime, LocalTime endTime) {
        double hours=ChronoUnit.MINUTES.between(startTime, endTime);
        return hours/60;
    }
    public  double getDays(double hours) {
        double days=hours/9;
        return days;
    }


}





