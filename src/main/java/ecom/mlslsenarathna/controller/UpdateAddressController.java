package ecom.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.AddressDTO;
import ecom.mlslsenarathna.model.dto.CustomerDTO;
import ecom.mlslsenarathna.service.AddressService;
import ecom.mlslsenarathna.service.CustomerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class UpdateAddressController {
    CustomerService customerService=new CustomerService();
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
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String input=txtSerchInput.getText();

        if(customerService.isCustomerId(input)){
            CustomerDTO customerDTO=customerService.searchCustomerId(input);
            AddressDTO addressDTO=addressService.getAddressById(customerDTO.getAddressId());
            txtAddressLine1.setText(addressDTO.getAddressLine1());
            txtAddressLine2.setText(addressDTO.getAdddressLine2());
            txtCity.setText(addressDTO.getCity());
            txtDistrict.setText(addressDTO.getDistrict());
            txtPostalCode.setText(addressDTO.getPostalCode());


        }else if(customerService.isMobileNumber(input)){
            CustomerDTO customerDTO= customerService.searchCustomerPhone(input);
            AddressDTO addressDTO=addressService.getAddressById(customerDTO.getAddressId());
            txtAddressLine1.setText(addressDTO.getAddressLine1());
            txtAddressLine2.setText(addressDTO.getAdddressLine2());
            txtCity.setText(addressDTO.getCity());
            txtDistrict.setText(addressDTO.getDistrict());
            txtPostalCode.setText(addressDTO.getPostalCode());

        }else{
            JOptionPane.showMessageDialog(null,"Please Check Input");
        }

    }

    @FXML
    void btnSetOnAction(ActionEvent event) {
        String input=txtSerchInput.getText();

        if(customerService.isCustomerId(input)){
            CustomerDTO customerDTO=customerService.searchCustomerId(input);
            AddressDTO addressDTO=addressService.getAddressById(customerDTO.getAddressId());
            addressDTO.setAddressLine1(txtAddressLine1.getText());
            addressDTO.setAdddressLine2(txtAddressLine2.getText());
            addressDTO.setCity(txtCity.getText());
            addressDTO.setDistrict(txtDistrict.getText());
            addressDTO.setPostalCode(txtPostalCode.getText());
            addressService.updateAddress(addressDTO);
            JOptionPane.showMessageDialog(null,"Updated");
            setClear();

        }else if(customerService.isMobileNumber(input)){
            CustomerDTO customerDTO= customerService.searchCustomerPhone(input);
            AddressDTO addressDTO=addressService.getAddressById(customerDTO.getAddressId());
            addressDTO.setAddressLine1(txtAddressLine1.getText());
            addressDTO.setAdddressLine2(txtAddressLine2.getText());
            addressDTO.setCity(txtCity.getText());
            addressDTO.setDistrict(txtDistrict.getText());
            addressDTO.setPostalCode(txtPostalCode.getText());
            addressService.updateAddress(addressDTO);
            JOptionPane.showMessageDialog(null,"Updated");
            setClear();

        }else{
            JOptionPane.showMessageDialog(null,"Update failed");
        }



    }
    private void setClear(){
        txtSerchInput.setText(null);
        txtAddressLine1.setText(null);
        txtAddressLine2.setText(null);
        txtCity.setText(null);
        txtDistrict.setText(null);
        txtPostalCode.setText(null);
    }
}
