package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.CustomerEntity;

public interface CustomerRepository {

    void customerRegistration(CustomerEntity customerEntity);
    CustomerEntity getLastCustomer();

    CustomerEntity searchCustomerById(String input);

    CustomerEntity searchCustomerByMobile(String input);

    void updateCustomerByID(CustomerEntity customerEntity);
}
