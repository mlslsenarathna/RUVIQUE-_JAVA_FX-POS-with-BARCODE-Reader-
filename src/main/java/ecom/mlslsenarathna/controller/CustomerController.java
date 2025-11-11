package ecom.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.AddressDTO;
import ecom.mlslsenarathna.model.dto.CustomerDTO;
import ecom.mlslsenarathna.service.AddressService;
import ecom.mlslsenarathna.service.CustomerService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    CustomerService customerService=new CustomerService();
    AddressService addressService=new AddressService();

    @FXML
    private JFXButton btnCancle;

    @FXML
    private JFXButton btnDeleteCustomer;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXButton btnResetForm;

    @FXML
    private JFXButton btnUpdateAddress;

    @FXML
    private JFXButton btnUpdateMobileNumber;

    @FXML
    private JFXButton btnViewCustomers;

    @FXML
    private JFXComboBox<String> cmdSex;

    @FXML
    private DatePicker dobDate;

    @FXML
    private Label lblCustomerId;

    @FXML
    private Label lblDateTime;

    @FXML
    private JFXTextField txtAddressLine1;

    @FXML
    private JFXTextField txtAddressLine2;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXTextField txtDistrict;

    @FXML
    private JFXTextField txtMobile;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPostalCode;


    @FXML
    void btnRegisterOnAction(ActionEvent event) {
       CustomerDTO newCustomer=getNewRegisterCustomer();
        customerService.registerCustomer(newCustomer);
        resetForm();

    }

    private CustomerDTO getNewRegisterCustomer() {
        String custId=lblCustomerId.getText();
        String name=txtName.getText();
        String mobileNum=txtMobile.getText();
        String sex=cmdSex.getValue();
        String addressId= addressService.getAddressId();
        AddressDTO address=new AddressDTO(
                addressId,
                txtAddressLine1.getText(),
                txtAddressLine2.getText(),
                txtCity.getText(),
                txtDistrict.getText(),
                txtPostalCode.getText()

        );
        LocalDate dob=dobDate.getValue();
        addressService.registrationAddress(address);
        return new CustomerDTO(custId,name,mobileNum,sex,addressId,dob);

    }
    @FXML
    void btnResetFormOnAction(ActionEvent event) {
        resetForm();

    }


    @FXML
    void btnUpdateAddressOnAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UpdateAddress.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Update Address");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnUpdateMobileNumberOnAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UpdateMobile.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Update Mobile Number");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnViewCustomersOnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setSexComboBox();

        lblCustomerId.setText(customerService.getCustomerID());

    }

    private void setSexComboBox() {
        cmdSex.getItems().addAll("Female","Male");
    }


    private  void resetForm(){
        lblCustomerId.setText(customerService.getCustomerID());
        txtName.setText(null);
        txtMobile.setText(null);
        cmdSex.setValue(null);
        txtAddressLine1.setText(null);
        txtAddressLine2.setText(null);
        txtCity.setText(null);
        txtDistrict.setText(null);
        txtPostalCode.setText(null);
        dobDate.setValue(null);
    }

    public void btnCancleOnAction(ActionEvent actionEvent) {
    }



    public void btnDeleteCustomerOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DeleteCustomer.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Delete Customer");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
