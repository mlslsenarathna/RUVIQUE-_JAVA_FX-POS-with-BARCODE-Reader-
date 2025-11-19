package ecom.mlslsenarathna.service;


import ecom.mlslsenarathna.model.dto.AttedensVeiwDTO;
import ecom.mlslsenarathna.model.dto.AttendenceDTO;
import ecom.mlslsenarathna.model.dto.EmployeeDTO;
import ecom.mlslsenarathna.model.entity.AttendenceEntity;
import ecom.mlslsenarathna.model.entity.EmployeeEntity;
import ecom.mlslsenarathna.repository.AttendenceRepository;
import ecom.mlslsenarathna.repository.impl.AttendenceRepositoryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public class AttendenceService {
    AttendenceRepository attendenceRepository=new AttendenceRepositoryImpl();
    WorkingTimeCalculatorService workingTimeCalculatorService=new WorkingTimeCalculatorService();
    EmployeeService  employeeService=new EmployeeService();

    public void setOnRecorde(AttendenceDTO attendenceDTO) {
        attendenceRepository.setAttendenceOn(new AttendenceEntity(
                attendenceDTO.getAttendenceId(),
                attendenceDTO.getEmplyeeNIC(),
                attendenceDTO.getDate(),
                attendenceDTO.getStart(),
                attendenceDTO.getStop()
        ));

    }
    public ObservableList<AttendenceDTO> getTodayList(){
        List<AttendenceEntity> attendenceEntities=attendenceRepository.getAllAttendence();
        ObservableList<AttendenceDTO> attendenceDTOSTodays= FXCollections.observableArrayList();
        System.out.println("Error in");

        for(AttendenceEntity attendenceEntity:attendenceEntities){
            LocalDate date1=attendenceEntity.getDate();
            LocalDate date2=LocalDate.now();
            System.out.println("condition");
            if(date1.equals(date2)){
                attendenceDTOSTodays.add(
                        new AttendenceDTO(
                                attendenceEntity.getAttendenceId(),
                                attendenceEntity.getEmplyeeNIC(),
                                attendenceEntity.getDate(),
                                attendenceEntity.getStart(),
                                attendenceEntity.getStop()
                        )
                );

            }
        }
        System.out.println("Error out");
        return attendenceDTOSTodays;

    }


    public AttendenceDTO getnewAttendence(String text) {
        ObservableList<AttendenceDTO> todayList=getTodayList();
        for (AttendenceDTO attendenceDTO:todayList){
            if(attendenceDTO.getEmplyeeNIC().equals(text)){
                return  attendenceDTO;

            }
        }
        return null;
    }
    public String getLastID(){
        AttendenceEntity attendenceEntity=attendenceRepository.getLastAttendence();
        return attendenceEntity.getAttendenceId();
    }
    public  String getNewAttendenceID(){
        if(getLastID()!=null){
            String lastId= String.valueOf(getLastID());
            lastId = lastId.split("[A-Z]")[2]; // C001==> 001
            lastId= String.format("AT%03d",(Integer.parseInt(lastId)+1));
            return lastId;

        }
        return "AT001";
    }

    public ObservableList<AttedensVeiwDTO> getEmployeeWorkigData() {
        List<AttendenceEntity> attendenceEntities=attendenceRepository.getAllAttendence();
      // ObservableList<EmployeeDTO> employeeDTOS=employeeService.
        ObservableList<AttedensVeiwDTO> attedensVeiwDTOS=FXCollections.observableArrayList();
        for(AttendenceEntity attendenceEntity:attendenceEntities){
            EmployeeDTO employeedto=employeeService.searchByEmployerNic(attendenceEntity.getEmplyeeNIC());
            double hours=  workingTimeCalculatorService.getHours(attendenceEntity.getStart(),attendenceEntity.getStop());
            attedensVeiwDTOS.add(new AttedensVeiwDTO(
                   employeedto.getEmplyeeName(),
                    employeedto.getNationalId(),
                    hours,
                    workingTimeCalculatorService.getDays(hours)

            ));


        }
        return attedensVeiwDTOS;

    }


    public ObservableList<AttedensVeiwDTO> setEmployeeWorkigData() {
    ObservableList<EmployeeDTO> employeeDTOS=employeeService.getEmployeeDTOS();
    ObservableList<AttendenceDTO> attendenceDTOS=getAttendenceDTOS();

    ObservableList<AttedensVeiwDTO> attedensVeiwDTOS=FXCollections.observableArrayList();
    for(EmployeeDTO employeeDTO:employeeDTOS){
        double hours=0;
        double days=0;
        for (AttendenceDTO attedensDTO:attendenceDTOS){
         if(employeeDTO.getNationalId().equals(attedensDTO.getEmplyeeNIC())){
             double dayhour=workingTimeCalculatorService.getHours(attedensDTO.getStart(),attedensDTO.getStop());
             hours+=dayhour;
             days+=workingTimeCalculatorService.getDays(dayhour);
         }
        }
        attedensVeiwDTOS.add(
                new AttedensVeiwDTO(
                        employeeDTO.getEmplyeeName(),
                        employeeDTO.getNationalId(),
                        hours,
                        days
                )
        );

    }

        return attedensVeiwDTOS;
    }

    public ObservableList<AttendenceDTO>  getAttendenceDTOS(){
        List<AttendenceEntity> attendenceEnitities=attendenceRepository.getAllAttendence();
        ObservableList<AttendenceDTO> attendenceDTOS=FXCollections.observableArrayList();

        for (AttendenceEntity attendenceEntity:attendenceEnitities){
            attendenceDTOS.add(new AttendenceDTO(
                    attendenceEntity.getAttendenceId(),
                    attendenceEntity.getEmplyeeNIC(),
                    attendenceEntity.getDate(),
                    attendenceEntity.getStart(),
                    attendenceEntity.getStop()
            ));
        }
        return attendenceDTOS;
    }

}

