package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.CustomerDTO;
import ecom.mlslsenarathna.model.entity.CustomerEntity;
import ecom.mlslsenarathna.repository.AddressRepository;
import ecom.mlslsenarathna.repository.CustomerRepository;
import ecom.mlslsenarathna.repository.impl.AddressRepositoryImpl;
import ecom.mlslsenarathna.repository.impl.CustomerRepositoryImpl;

public class CustomerService {
    CustomerRepository customerRepository=new CustomerRepositoryImpl();
    AddressRepository addressRepository=new AddressRepositoryImpl();


    public void registerCustomer(CustomerDTO newCustomer) {
        CustomerEntity customerEntity=new CustomerEntity(
                newCustomer.getCustId(),
                newCustomer.getCustName(),
                newCustomer.getCustMobile(),
                newCustomer.getSex(),
                newCustomer.getAddressId(),
                newCustomer.getDob()
        );
        customerRepository.customerRegistration(customerEntity);
    }

    public String getCustomerID() {
        System.out.println(customerRepository.getLastCustomer());
        if(customerRepository.getLastCustomer().getCustId()!=null){
            String lastId= String.valueOf(customerRepository.getLastCustomer().getCustId());
            lastId = lastId.split("[A-Z]")[1]; // C001==> 001
            lastId= String.format("C%03d",(Integer.parseInt(lastId)+1));
           return lastId;

        }
        return "C001";
    }

    public void checkSearchInputUpdateNumber(String input) {
        if(isCustomerId(input)){

        }
    }

    public boolean isCustomerId(String input) {
        return input != null && input.matches("^C\\d{3}$");
    }



    public boolean isMobileNumber(String input) {
        return input != null && input.matches("^(0\\d{9}|\\+94\\d{9})$");

    }

    public CustomerDTO searchCustomerId(String input) {
        CustomerEntity customerEntity=customerRepository.searchCustomerById(input);
        if(customerEntity!=null){
            return  new CustomerDTO(
                    customerEntity.getCustId(),
                    customerEntity.getCustName(),
                    customerEntity.getCustMobile(),
                    customerEntity.getSex(),
                    customerEntity.getAddressId(),
                    customerEntity.getDob()

            );

        }
        return null;
    }

    public void updateCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity=new CustomerEntity(
                customerDTO.getCustId(),
                customerDTO.getCustName(),
                customerDTO.getCustMobile(),
                customerDTO.getSex(),
                customerDTO.getAddressId(),
                customerDTO.getDob()
        );
        customerRepository.updateCustomerByID(customerEntity);

    }

    public CustomerDTO searchCustomerPhone(String input) {
        CustomerEntity customerEntity=customerRepository.searchCustomerByMobile(input);
        if(customerEntity!=null){
            return  new CustomerDTO(
                    customerEntity.getCustId(),
                    customerEntity.getCustName(),
                    customerEntity.getCustMobile(),
                    customerEntity.getSex(),
                    customerEntity.getAddressId(),
                    customerEntity.getDob()

            );

        }
        return null;

    }

    public boolean isCustomerDTONull(CustomerDTO customerDTO) {
        if(customerDTO!=null){
            return true;
        }
        return false;
    }
}
