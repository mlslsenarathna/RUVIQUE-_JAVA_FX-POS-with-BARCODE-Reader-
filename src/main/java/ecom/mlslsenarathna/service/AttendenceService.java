package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.AttendenceDTO;
import ecom.mlslsenarathna.model.entity.AttendenceEntity;
import ecom.mlslsenarathna.repository.AttendenceRepository;
import ecom.mlslsenarathna.repository.impl.AttendenceRepositoryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public class AttendenceService {
    AttendenceRepository attendenceRepository=new AttendenceRepositoryImpl();
    public String getnewAttendenceId() {
       return null;
    }

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

        for(AttendenceEntity attendenceEntity:attendenceEntities){
            if(LocalDate.now().equals(attendenceEntity.getDate())){
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
    public  String getNewAttendenceID(){
        AttendenceEntity attendenceEntity=attendenceRepository.getLastAttendence();
        return null;
    }
}
