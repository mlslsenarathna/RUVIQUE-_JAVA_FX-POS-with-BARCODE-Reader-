package ecom.mlslsenarathna.controller.subControllers.supplier;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.SupplierDTO;
import ecom.mlslsenarathna.service.SupplierService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SupplierUpdateRegistrationNoController {
    SupplierService supplierService=new SupplierService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnSet;

    @FXML
    private JFXTextField txtCusrrentRegNo;

    @FXML
    private JFXTextField txtNewRegNo;

    @FXML
    private JFXTextField txtSerchInput;

    @FXML
    void btnBackOnAction(ActionEvent event) {


    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        txtCusrrentRegNo.setText(supplierDTO.getSupplierCompanyRegistrationNo());

    }

    @FXML
    void btnSetOnAction(ActionEvent event) {
        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        supplierDTO.setSupplierCompanyRegistrationNo(String.valueOf(txtNewRegNo.getText()));
        supplierService.updateSupplier(supplierDTO);


    }

    @FXML
    void txtSerchInputOnAction(ActionEvent event) {
        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        txtCusrrentRegNo.setText(supplierDTO.getSupplierCompanyRegistrationNo());

    }

}
