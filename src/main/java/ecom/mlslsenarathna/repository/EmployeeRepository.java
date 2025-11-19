package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.EmployeeEntity;

public interface EmployeeRepository {
    EmployeeEntity getLastEmployee();

    void registerEmployee(EmployeeEntity employeeEntity);

}