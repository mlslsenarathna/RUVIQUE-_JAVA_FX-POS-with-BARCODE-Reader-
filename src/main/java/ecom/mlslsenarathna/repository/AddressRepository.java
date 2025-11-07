package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.AddressEntity;

public interface AddressRepository {

    AddressEntity getLastAddressId();

    void registrationAddress(AddressEntity addressEntity);
}
