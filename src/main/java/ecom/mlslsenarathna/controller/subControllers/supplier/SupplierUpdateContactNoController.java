package ecom.mlslsenarathna.controller.subControllers.supplier;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.SupplierDTO;
import ecom.mlslsenarathna.service.SupplierService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SupplierUpdateContactNoController {
    SupplierService supplierService=new SupplierService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnSet;

    @FXML
    private JFXTextField txtCurrentNumber;

    @FXML
    private JFXTextField txtNewNumber;

    @FXML
    private JFXTextField txtSerchInput;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        txtCurrentNumber.setText(supplierDTO.getSupplierContactNo());
    }

    @FXML
    void btnSetOnAction(ActionEvent event) {
        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        supplierDTO.setSupplierContactNo(String.valueOf(txtNewNumber.getText()));
        supplierService.updateSupplier(supplierDTO);


    }

    @FXML
    void txtSerchInputOnAction(ActionEvent event) {
        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        txtCurrentNumber.setText(supplierDTO.getSupplierContactNo());

    }

}
