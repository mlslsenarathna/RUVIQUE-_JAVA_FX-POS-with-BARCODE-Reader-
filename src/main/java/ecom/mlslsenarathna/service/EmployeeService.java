package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.EmployeeDTO;
import ecom.mlslsenarathna.model.entity.EmployeeEntity;
import ecom.mlslsenarathna.repository.EmployeeRepository;
import ecom.mlslsenarathna.repository.impl.EmployeeRepositoryImpl;

public class EmployeeService {
    EmployeeRepository employeeRepository=new EmployeeRepositoryImpl();
    AddressService addressService=new AddressService();


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
}

