package ecom.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.AddressDTO;
import ecom.mlslsenarathna.model.dto.CustomerDTO;
import ecom.mlslsenarathna.service.AddressService;
import ecom.mlslsenarathna.service.CustomerService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteCustomerController implements Initializable {
    CustomerService customerService=new CustomerService();
    AddressService addressService=new AddressService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXComboBox<String> cmdSex;

    @FXML
    private DatePicker dobDate;

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
    private JFXTextField txtSerchInput;
    private HomePageController parentController;


    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       stage.close();


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String input=txtSerchInput.getText();
        String id = input.substring(0, 1).toUpperCase() + input.substring(1);


        if(customerService.isCustomerId(id)){
            CustomerDTO customerDTO=customerService.searchCustomerId(input);
            customerService.deleteByCustomerId(customerDTO.getCustId());
            addressService.deleteByAddressId(customerDTO.getAddressId());
            setClear();


        }else if(customerService.isMobileNumber(id)){
            CustomerDTO customerDTO= customerService.searchCustomerPhone(input);
            customerService.deleteByCustomerId(customerDTO.getCustId());
            addressService.deleteByAddressId(customerDTO.getAddressId());
            setClear();


        }else{
            JOptionPane.showMessageDialog(null,"Please Check Input");
        }



    }

    private void setClear() {
        txtSerchInput.setText(null);
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

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String input=txtSerchInput.getText();
        String id = input.substring(0, 1).toUpperCase() + input.substring(1);


        if(customerService.isCustomerId(id)){
            CustomerDTO customerDTO=customerService.searchCustomerId(input);
            AddressDTO addressDTO=addressService.getAddressById(customerDTO.getAddressId());
            setSelectedProperties(customerDTO,addressDTO);


        }else if(customerService.isMobileNumber(id)){
            CustomerDTO customerDTO= customerService.searchCustomerPhone(input);
            AddressDTO addressDTO=addressService.getAddressById(customerDTO.getAddressId());
            setSelectedProperties(customerDTO,addressDTO);

        }else{
            JOptionPane.showMessageDialog(null,"Please Check Input");
        }


    }
    private void setSelectedProperties(CustomerDTO customerDTO,AddressDTO addressDTO){
        txtName.setText(customerDTO.getCustName());
        txtMobile.setText(customerDTO.getCustMobile());
        cmdSex.setValue(customerDTO.getSex());
        txtAddressLine1.setText(addressDTO.getAddressLine1());
        txtAddressLine2.setText(addressDTO.getAdddressLine2());
        txtCity.setText(addressDTO.getCity());
        txtDistrict.setText(addressDTO.getDistrict());
        txtPostalCode.setText(addressDTO.getPostalCode());
        dobDate.setValue(customerDTO.getDob());
    }
    @FXML
    void txtSerchInputOnAction(ActionEvent event) {
        btnSearch.fire();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      setComboBox();


    }

    private void setComboBox() {
        cmdSex.setItems(FXCollections.observableArrayList("Male", "Female"));
        //  cmdSex.lookup(".text").setStyle("-fx-fill: white;");
    }

}
