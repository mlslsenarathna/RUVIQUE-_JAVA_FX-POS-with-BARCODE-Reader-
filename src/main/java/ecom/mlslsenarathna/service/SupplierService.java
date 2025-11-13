package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.SupplierDTO;
import ecom.mlslsenarathna.model.entity.SupplierEntity;
import ecom.mlslsenarathna.repository.SupplierRepository;
import ecom.mlslsenarathna.repository.impl.SupplierRepositoryImpl;

public class SupplierService {
    SupplierRepository supplierRepository=new SupplierRepositoryImpl();

    public boolean isSupplierId(String input) {
        return input != null && input.matches("^S\\d{4}$");
    }

    public SupplierDTO searchBySupplierId(String id) {
        SupplierEntity supplierEntity=supplierRepository.getSupplierByID(id);
    return new SupplierDTO(
            supplierEntity.getSupplierId(),
            supplierEntity.getSupplierName(),
            supplierEntity.getSupplierContactNo(),
            supplierEntity.getSupplierEmail(),
            supplierEntity.getSupplierCountry(),
            supplierEntity.getSupplierCompanyRegistrationNo(),
            supplierEntity.getAddressId()
    );
    }
}
