package ecom.mlslsenarathna.service;


public class SalaryService {
    AttendenceService attendenceService=new AttendenceService();


    public double epfCalculator(double netSalary){
        return netSalary*0.08;
    }
    public double etfCalculator(double netSalary){
        return netSalary*0.03;
    }
    public double overTimeCalculator(double hours){
        double otHours=hours-225;
        if(otHours>0){
            return otHours*175;
        }
        return 0.0;
    }
    public double getNetSalary(double hours){
        return hours*110;
    }
    public double allownceCalculator(double netSalary){
        return netSalary*0.12;
    }
    public double getOThours(double hours){
        if(hours>225){
            return hours-225;
        }
        return 0;
    }
    public  double nonLeaveBonus(double hours){
        return 2500;
    }



}
