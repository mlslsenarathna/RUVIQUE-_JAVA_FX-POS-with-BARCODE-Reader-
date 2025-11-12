package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.CustomerEntity;

import java.util.List;

public interface CustomerRepository {

    void customerRegistration(CustomerEntity customerEntity);
    CustomerEntity getLastCustomer();

    CustomerEntity searchCustomerById(String input);

    CustomerEntity searchCustomerByMobile(String input);

    void updateCustomerByID(CustomerEntity customerEntity);

    void deleteCustomerById(CustomerEntity customerEntity);

    List<CustomerEntity> getCustomersList();
}
