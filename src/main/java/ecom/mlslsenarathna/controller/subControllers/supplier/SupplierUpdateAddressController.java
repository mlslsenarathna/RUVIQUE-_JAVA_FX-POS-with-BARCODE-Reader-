package ecom.mlslsenarathna.controller.subControllers.supplier;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.AddressDTO;
import ecom.mlslsenarathna.model.dto.SupplierDTO;
import ecom.mlslsenarathna.service.AddressService;
import ecom.mlslsenarathna.service.SupplierService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SupplierUpdateAddressController {
    SupplierService supplierService=new SupplierService();
    AddressService addressService=new AddressService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnSet;

    @FXML
    private JFXTextField txtAddressLine1;

    @FXML
    private JFXTextField txtAddressLine2;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXTextField txtDistrict;

    @FXML
    private JFXTextField txtPostalCode;

    @FXML
    private JFXTextField txtSerchInput;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        SupplierDTO supplierDTO=supplierService.searchBySupplierId(txtSerchInput.getText());
        AddressDTO addressDTO=addressService.getAddressById(supplierDTO.getAddressId());
        setAddressDTOInfo(addressDTO);


    }

    private void  setAddressDTOInfo(AddressDTO addressDTO) {
        txtAddressLine1.setText(addressDTO.getAddressLine1());
        txtAddressLine2.setText(addressDTO.getAdddressLine2());
        txtCity.setText(addressDTO.getCity());
        txtDistrict.setText(addressDTO.getDistrict());
        txtPostalCode.setText(addressDTO.getPostalCode());

    }

    @FXML
    void btnSetOnAction(ActionEvent event) {
        SupplierDTO supplierDTO=supplierService.searchBySupplierId(txtSerchInput.getText());
        AddressDTO addressDTO=addressService.getAddressById(supplierDTO.getAddressId());
        addressDTO=setNewAddressDTO(addressDTO);

        addressService.updateAddress(addressDTO);

    }

    private AddressDTO setNewAddressDTO(AddressDTO addressDTO) {
        addressDTO.setAddressLine1(txtAddressLine1.getText());
        addressDTO.setAdddressLine2(txtAddressLine2.getText());
        addressDTO.setCity(txtCity.getText());
        addressDTO.setDistrict(txtDistrict.getText());
        addressDTO.setPostalCode(txtPostalCode.getText());
        return addressDTO;
    }

    @FXML
    void txtSerchInputOnAction(ActionEvent event) {
        SupplierDTO supplierDTO=supplierService.searchBySupplierId(txtSerchInput.getText());
        AddressDTO addressDTO=addressService.getAddressById(supplierDTO.getAddressId());
        setAddressDTOInfo(addressDTO);
    }

}
