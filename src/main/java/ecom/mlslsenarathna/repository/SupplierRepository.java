package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.SupplierEntity;

public interface SupplierRepository {
    SupplierEntity getSupplierByID(String id);

     SupplierEntity getLastSupplier();

    void registerNewSupplier(SupplierEntity supplierEntity);

    void updateSupplierDetails(SupplierEntity supplierEntity);

    void deleteById(SupplierEntity supplierEntity);
}
