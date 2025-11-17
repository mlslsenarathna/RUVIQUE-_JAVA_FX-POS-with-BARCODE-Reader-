package ecom.mlslsenarathna.controller.subControllers.supplier;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.SupplierDTO;
import ecom.mlslsenarathna.service.SupplierService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SupplierDeleleteController {
    SupplierService supplierService=new SupplierService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtCoutry;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtRegNo;

    @FXML
    private JFXTextField txtSerchInput;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        supplierService.deleteSupplierById(supplierDTO);
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        setDetails(supplierDTO);
        txtSerchInput.setEditable(false);
    }

    private void setDetails(SupplierDTO supplierDTO) {
        txtCoutry.setText(supplierDTO.getSupplierCountry());
        txtName.setText(supplierDTO.getSupplierName());
        txtEmail.setText(supplierDTO.getSupplierEmail());
        txtRegNo.setText(supplierDTO.getSupplierCompanyRegistrationNo());
        txtContact.setText(supplierDTO.getSupplierContactNo());
    }

    @FXML
    void txtSerchInputOnAction(ActionEvent event) {
        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        setDetails(supplierDTO);
        txtSerchInput.setEditable(false);
    }

}
