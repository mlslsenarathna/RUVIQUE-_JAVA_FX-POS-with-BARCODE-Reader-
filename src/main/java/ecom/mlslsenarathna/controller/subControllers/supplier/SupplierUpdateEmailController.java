package ecom.mlslsenarathna.controller.subControllers.supplier;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.SupplierDTO;
import ecom.mlslsenarathna.service.SupplierService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SupplierUpdateEmailController {
    SupplierService supplierService=new SupplierService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnSet;

    @FXML
    private JFXTextField txtCurrentEmail;

    @FXML
    private JFXTextField txtNewEmail;

    @FXML
    private JFXTextField txtSerchInput;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {

        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        txtCurrentEmail.setText(supplierDTO.getSupplierEmail());


    }

    @FXML
    void btnSetOnAction(ActionEvent event) {
        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        supplierDTO.setSupplierEmail(txtNewEmail.getText());
        supplierService.updateSupplier(supplierDTO);

    }

    @FXML
    void txtSerchInputOnAction(ActionEvent event) {

        SupplierDTO supplierDTO= supplierService.searchBySupplierId(txtSerchInput.getText());
        txtCurrentEmail.setText(supplierDTO.getSupplierEmail());


    }

}
