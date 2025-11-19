package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.EmployeeDTO;
import ecom.mlslsenarathna.model.entity.EmployeeEntity;
import ecom.mlslsenarathna.repository.EmployeeRepository;
import ecom.mlslsenarathna.repository.impl.EmployeeRepositoryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.List;


public class EmployeeService {
    EmployeeRepository employeeRepository=new EmployeeRepositoryImpl();

    public String getLastEmployeeID(){
       EmployeeEntity employeeEntity= employeeRepository.getLastEmployee();
       return employeeEntity.getEmployeeId();
    }
    public String setEmployeeId() {
        if(getLastEmployeeID()!=null){
            String lastId= String.valueOf(getLastEmployeeID());
            lastId = lastId.split("[A-Z]")[1]; // C001==> 001
            lastId= String.format("E%03d",(Integer.parseInt(lastId)+1));
            return lastId;

        }
        return "E001";

    }


    public void registerEmploye(EmployeeDTO employeeDTO) {
        employeeRepository.registerEmployee(new EmployeeEntity(
              employeeDTO.getEmployeeId(),
                employeeDTO.getEmplyeeName(),
                employeeDTO.getContactNo(),
                employeeDTO.getNationalId(),
                employeeDTO.getAddressId()

        ));
    }



    public EmployeeDTO searchByEmployerNic(String nic) {

        EmployeeEntity employeeEntity=employeeRepository.getEmplyeeByNic(nic);
            return new EmployeeDTO(
                    employeeEntity.getEmployeeId(),
                    employeeEntity.getEmplyeeName(),
                    employeeEntity.getContactNo(),
                    employeeEntity.getNationalId(),
                    employeeEntity.getAddressId()
            );

    }
    public ObservableList<EmployeeDTO> getEmployeeDTOS(){
       List<EmployeeEntity> employeeEntityList=employeeRepository.getAllEmployees();
       ObservableList<EmployeeDTO> employeeDTOS= FXCollections.observableArrayList();
       for(EmployeeEntity employeeEntity:employeeEntityList){
           employeeDTOS.add(new EmployeeDTO(
                   employeeEntity.getEmployeeId(),
                   employeeEntity.getEmplyeeName(),
                   employeeEntity.getContactNo(),
                   employeeEntity.getNationalId(),
                   employeeEntity.getAddressId()
           ));

       }
       return  employeeDTOS;
    }
}

