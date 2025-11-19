package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository {
    EmployeeEntity getLastEmployee();

    void registerEmployee(EmployeeEntity employeeEntity);


    EmployeeEntity getEmplyeeByNic(String nic);

    List<EmployeeEntity> getAllEmployees();


}