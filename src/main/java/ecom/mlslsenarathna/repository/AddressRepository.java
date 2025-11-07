package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.AddressEntity;

public interface AddressRepository {

    AddressEntity getLastAddressId();

    void registrationAddress(AddressEntity addressEntity);

    AddressEntity getAddressById(String addressId);

    void updateAddress(AddressEntity addressEntity);
}
