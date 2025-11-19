package ecom.mlslsenarathna.controller;

import com.beust.ah.A;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.AddressDTO;
import ecom.mlslsenarathna.model.dto.EmployeeDTO;
import ecom.mlslsenarathna.service.AddressService;
import ecom.mlslsenarathna.service.EmployeeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeManagementController implements Initializable {
    EmployeeService employeeService=new EmployeeService();
    AddressService addressService=new AddressService();

    @FXML
    private JFXButton btnAttendenceSheet;

    @FXML
    private JFXButton btnCancle;

    @FXML
    private JFXButton btnDeleteEmployee;

    @FXML
    private JFXButton btnEmployeeVeiw;

    @FXML
    private JFXButton btnFingerPrintRegister;

    @FXML
    private JFXButton btnRegisterEmployee;

    @FXML
    private JFXButton btnResetForm;

    @FXML
    private JFXButton btnUpdateAddress;

    @FXML
    private JFXButton btnsalaryManagement;

    @FXML
    private JFXTextField txtAddressLine1;

    @FXML
    private JFXTextField txtAddressLine2;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXTextField txtDistrict;

    @FXML
    private JFXTextField txtEmployeeContactNo;

    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private JFXTextField txtNationalID;

    @FXML
    private JFXTextField txtPostalCode;

    @FXML
    private Label lblEmployeeId;

    @FXML
    void btnAttendenceSheetOnAction(ActionEvent event) {
        JOptionPane.showMessageDialog(null,"FingerPrint take..!");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EmployeeAttendenceMark.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Attendence ");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }



        lblEmployeeId.setText(employeeService.getLastEmployeeID());



    }

    @FXML
    void btnCancleOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void btnEmployeeVeiwOnAction(ActionEvent event) {

    }

    @FXML
    void btnFingerPrintRegister(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FingerPrintTakeInput.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Scannner ");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void btnRegisterEmployeeOnAction(ActionEvent event) {
        registration();




    }

    private void registration() {
        AddressDTO addressDTO=new AddressDTO(
                addressService.getAddressId(),
                txtAddressLine1.getText(),
                txtAddressLine2.getText(),
                txtCity.getText(),
                txtDistrict.getText(),
                txtPostalCode.getText()
        );
        EmployeeDTO employeeDTO=new EmployeeDTO(
                lblEmployeeId.getText(),
                txtEmployeeName.getText(),
                txtEmployeeContactNo.getText(),
                txtNationalID.getText(),
                addressDTO.getAddressId()
        );

        addressService.registrationAddress(addressDTO);
        employeeService.registerEmploye(employeeDTO);

        JOptionPane.showMessageDialog(null,"FingerPrint take..!");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FingerPrintTakeInput.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Scannner ");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }



        lblEmployeeId.setText(employeeService.getLastEmployeeID());






    }

    @FXML
    void btnResetFormOnAction(ActionEvent event) {
        resetForm();

    }

    private void resetForm() {
        lblEmployeeId.setText(employeeService.getLastEmployeeID());
        txtEmployeeName.setText(null);
        txtAddressLine1.setText(null);
        txtAddressLine2.setText(null);
        txtCity.setText(null);
        txtDistrict.setText(null);
        txtPostalCode.setText(null);
        txtNationalID.setText(null);
        txtEmployeeContactNo.setText(null);
    }


    @FXML
    void btnUpdateAddressOnAction(ActionEvent event) {

    }

    @FXML
    void btnsalaryManagementOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setEmployeeID();
    }

    private void setEmployeeID() {
        lblEmployeeId.setText(employeeService.setEmployeeId());
    }
}
