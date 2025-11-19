package ecom.mlslsenarathna.controller;

import com.beust.ah.A;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.AddressDTO;
import ecom.mlslsenarathna.model.dto.SupplierDTO;
import ecom.mlslsenarathna.model.entity.AddressEntity;
import ecom.mlslsenarathna.model.entity.SupplierEntity;
import ecom.mlslsenarathna.service.AddressService;
import ecom.mlslsenarathna.service.SupplierService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SupplierManagementController implements Initializable {
    AddressService addressService=new AddressService();
    SupplierService supplierService=new SupplierService();

    @FXML
    private JFXButton btnCancle;

    @FXML
    private JFXButton btnDeleteSupplier;

    @FXML
    private JFXButton btnRegisterSupplier;

    @FXML
    private JFXButton btnResetForm;

    @FXML
    private JFXButton btnUpdateAddress;

    @FXML
    private JFXButton btnUpdateContactNo;

    @FXML
    private JFXButton btnUpdateEmail;

    @FXML
    private JFXButton btnUpdateRegistrationNo;

    @FXML
    private JFXButton btnViewSuppliers;

    @FXML
    private Label lblSupplierId;

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
    private JFXTextField txtSupplierContactNo;

    @FXML
    private JFXTextField txtSupplierCountry;

    @FXML
    private JFXTextField txtSupplierEmail;

    @FXML
    private JFXTextField txtSupplierName;

    @FXML
    private JFXTextField txtXompanyRegNo;

    @FXML
    void btnCancleOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteSupplierOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SupplierDelete.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Delete Supplier");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnRegisterSupplierOnAction(ActionEvent event) {
       getNewRegistration();

    }

    private void getNewRegistration() {
        AddressDTO addressDTO=new AddressDTO(
              addressService.getLastAddressID(),
                txtAddressLine1.getText(),
                txtAddressLine2.getText(),
                txtCity.getText(),
                txtDistrict.getText(),
                txtPostalCode.getText()
                
        );
        addressService.registrationAddress(addressDTO);
        SupplierDTO supplierDTO=new SupplierDTO(
                lblSupplierId.getText(),
                txtSupplierName.getText(),
                txtSupplierContactNo.getText(),
                txtSupplierEmail.getText(),
                txtSupplierCountry.getText(),
                txtXompanyRegNo.getText(),
                addressDTO.getAddressId()
        );
        supplierService.registerNewSupplier(supplierDTO);
        resetForm();
    }

    @FXML
    void btnResetFormOnAction(ActionEvent event) {
            resetForm();
    }

    private void resetForm() {
        txtSupplierName.setText(null);
        txtSupplierEmail.setText(null);
        txtSupplierContactNo.setText(null);
        txtXompanyRegNo.setText(null);
        txtCity.setText(null);
        txtAddressLine1.setText(null);
        txtAddressLine2.setText(null);
        txtDistrict.setText(null);
        txtPostalCode.setText(null);
        txtSupplierCountry.setText(null);

    }

    @FXML
    void btnUpdateAddressOnAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SupplierAddressUpdate.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Update Registration No");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateContactNoOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SupplierUpdateContactNo.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Update Contact No");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateEmailOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SupplierUpdateEmail.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Update Email");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateRegistrationNoOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SupplierUpdateRegistrationNo.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Update Registration No");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnViewSuppliersOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SuppliersView.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Suppliers Overview");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setSupplierID();
    }

    private void setSupplierID() {
        lblSupplierId.setText(supplierService.setSupplierID());
    }
}
