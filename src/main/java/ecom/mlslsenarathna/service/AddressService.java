package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.AddressDTO;
import ecom.mlslsenarathna.model.entity.AddressEntity;
import ecom.mlslsenarathna.repository.AddressRepository;
import ecom.mlslsenarathna.repository.impl.AddressRepositoryImpl;

public class AddressService {
    AddressRepository addressRepository=new AddressRepositoryImpl();
    public void registrationAddress(AddressDTO address) {
        AddressEntity addressEntity=new AddressEntity(
                address.getAddressId(),
                address.getAddressLine1(),
                address.getAdddressLine2(),
                address.getCity(),
                address.getDistrict(),
                address.getPostalCode()
        );
        addressRepository.registrationAddress(addressEntity);
    }
    public String getAddressId(){
        AddressEntity addressEntity=addressRepository.getLastAddressId();
        System.out.println(addressRepository.getLastAddressId());
        if(addressRepository.getLastAddressId().getAddressId()!=null){
            String lastId= String.valueOf(addressRepository.getLastAddressId().getAddressId());
            lastId = lastId.split("[A-Z]")[1];
            lastId= String.format("A%03d",(Integer.parseInt(lastId)+1));
            return lastId;

        }
        return "A001";
    }

    public AddressDTO getAddressById(String addressId) {
       AddressEntity addressEntity= addressRepository.getAddressById(addressId);
       return new AddressDTO(
               addressEntity.getAddressId(),
               addressEntity.getAddressLine1(),
               addressEntity.getAdddressLine2(),
               addressEntity.getCity(),
               addressEntity.getDistrict(),
               addressEntity.getPostalCode()
       );
    }

    public void updateAddress(AddressDTO addressDTO) {
        addressRepository.updateAddress(new AddressEntity(
                addressDTO.getAddressId(),
                addressDTO.getAddressLine1(),
                addressDTO.getAdddressLine2(),
                addressDTO.getCity(),
                addressDTO.getDistrict(),
                addressDTO.getPostalCode()
        ));
    }
}
