package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.SupplierDTO;
import ecom.mlslsenarathna.model.dto.SupplierVeiwDTO;
import ecom.mlslsenarathna.model.entity.AddressEntity;
import ecom.mlslsenarathna.model.entity.SupplierEntity;
import ecom.mlslsenarathna.repository.AddressRepository;
import ecom.mlslsenarathna.repository.SupplierRepository;
import ecom.mlslsenarathna.repository.impl.AddressRepositoryImpl;
import ecom.mlslsenarathna.repository.impl.SupplierRepositoryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class SupplierService {
    SupplierRepository supplierRepository=new SupplierRepositoryImpl();
    AddressRepository addressRepository=new AddressRepositoryImpl();

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

    public String setSupplierID() {
        String lastID=getLastSupplierID();
        if(getLastSupplierID()!=null){
            String lastId= String.valueOf(getLastSupplierID());
            lastId = lastId.split("[A-Z]")[1];
            lastId= String.format("S%04d",(Integer.parseInt(lastId)+1));
            return lastId;

        }
        return "S0001";
    }

    private String getLastSupplierID() {
        SupplierEntity supplierEntity=supplierRepository.getLastSupplier();
        return  supplierEntity.getSupplierId();
    }

    public void registerNewSupplier(SupplierDTO supplierDTO) {
        /*    private String supplierId;
    private String supplierName;
    private String supplierContactNo;
    private String supplierEmail;
    private String supplierCountry;
    private String supplierCompanyRegistrationNo;
    private String addressId;*/
        supplierRepository.registerNewSupplier(new SupplierEntity(
                supplierDTO.getSupplierId(),
                supplierDTO.getSupplierName(),
                supplierDTO.getSupplierContactNo(),
                supplierDTO.getSupplierEmail(),
                supplierDTO.getSupplierCountry(),
                supplierDTO.getSupplierCompanyRegistrationNo(),
                supplierDTO.getAddressId()
        ));
    }

    public void updateSupplier(SupplierDTO supplierDTO) {
        System.out.println("sss"+supplierDTO.toString());
        supplierRepository.updateSupplierDetails(new SupplierEntity(
                supplierDTO.getSupplierId(),
                supplierDTO.getSupplierName(),
                supplierDTO.getSupplierContactNo(),
                supplierDTO.getSupplierEmail(),
                supplierDTO.getSupplierCountry(),
                supplierDTO.getSupplierCompanyRegistrationNo(),
                supplierDTO.getAddressId()

        ));
    }

    public void deleteSupplierById(SupplierDTO supplierDTO) {
        supplierRepository.deleteById(new SupplierEntity(
                supplierDTO.getSupplierId(),
                supplierDTO.getSupplierName(),
                supplierDTO.getSupplierContactNo(),
                supplierDTO.getSupplierEmail(),
                supplierDTO.getSupplierCountry(),
                supplierDTO.getSupplierCompanyRegistrationNo(),
                supplierDTO.getAddressId()
        ));
    }

    public ObservableList<SupplierVeiwDTO> getAllSuppliers() {
       List<SupplierEntity> supplierEntities=supplierRepository.getAllSuppliers();
       ObservableList<SupplierVeiwDTO> supplierVeiwDTOS= FXCollections.observableArrayList();
       for(SupplierEntity supplierEntity:supplierEntities){
           AddressEntity addressEntity=addressRepository.getAddressById(supplierEntity.getAddressId());
           supplierVeiwDTOS.add(
                   new SupplierVeiwDTO(
                           supplierEntity.getSupplierName(),
                           supplierEntity.getSupplierContactNo(),
                           addressEntity.getAddressLine1()+" , "+addressEntity.getAdddressLine2()+" , "+addressEntity.getCity()+" , "+addressEntity.getDistrict(),
                           supplierEntity.getSupplierEmail(),
                           supplierEntity.getSupplierCountry()
                   ));
       }

        return supplierVeiwDTOS;

    }


}
