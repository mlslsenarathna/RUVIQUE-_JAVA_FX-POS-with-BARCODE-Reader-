package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.SupplierEntity;

public interface SupplierRepository {
    SupplierEntity getSupplierByID(String id);
}
