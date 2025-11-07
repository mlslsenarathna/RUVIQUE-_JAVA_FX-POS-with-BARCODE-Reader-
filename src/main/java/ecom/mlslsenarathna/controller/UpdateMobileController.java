package ecom.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.CustomerDTO;
import ecom.mlslsenarathna.service.CustomerService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class UpdateMobileController {
    CustomerService customerService=new CustomerService();

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
        Stage stage= (Stage) btnBack.getScene().getWindow();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/HomePageView.fxml"))));
            stage.setMaximized(true);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
       String input=txtSerchInput.getText();

        if(customerService.isCustomerId(input)){
            CustomerDTO customerDTO=customerService.searchCustomerId(input);
            if(customerService.isCustomerDTONull(customerDTO)){
                txtCurrentNumber.setText(customerDTO.getCustMobile());
            }else{
                JOptionPane.showMessageDialog(null,"Update Failed Check cust Id");
            }

        }else if(customerService.isMobileNumber(input)){
           CustomerDTO customerDTO= customerService.searchCustomerPhone(input);
            if(customerService.isCustomerDTONull(customerDTO)) {
                txtCurrentNumber.setText(customerDTO.getCustMobile());
            }else{
                JOptionPane.showMessageDialog(null,"Update Failed Check Mobile Number");
            }

        }else{
            JOptionPane.showMessageDialog(null,"Please Check Input");
        }

    }

    @FXML
    void btnSetOnAction(ActionEvent event) {
        String input=txtSerchInput.getText();

        if(customerService.isCustomerId(input)){
            CustomerDTO customerDTO=customerService.searchCustomerId(input);
            customerDTO.setCustMobile(txtNewNumber.getText());
            customerService.updateCustomer(customerDTO);
            JOptionPane.showMessageDialog(null,"Updated ..");

        }else if(customerService.isMobileNumber(input)){
            CustomerDTO customerDTO= customerService.searchCustomerPhone(input);
            customerDTO.setCustMobile(txtNewNumber.getText());
            customerService.updateCustomer(customerDTO);
            JOptionPane.showMessageDialog(null,"Updated ..");

        }else{
            JOptionPane.showMessageDialog(null,"Update Failed");
        }
        txtNewNumber.setText(null);
    }

}
