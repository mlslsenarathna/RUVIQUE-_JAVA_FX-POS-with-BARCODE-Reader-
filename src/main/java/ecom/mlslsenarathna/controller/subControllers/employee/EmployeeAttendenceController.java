package ecom.mlslsenarathna.controller.subControllers.employee;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.AttendenceDTO;
import ecom.mlslsenarathna.model.dto.EmployeeDTO;
import ecom.mlslsenarathna.service.AttendenceService;
import ecom.mlslsenarathna.service.EmployeeService;
import ecom.mlslsenarathna.service.SupplierService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class EmployeeAttendenceController {
  EmployeeService employeeService=new EmployeeService();
  AttendenceService attendenceService=new AttendenceService();


    @FXML
    private JFXButton btnAddRecord;

    @FXML
    private JFXButton btnCancle;

    @FXML
    private JFXButton btnEmployeeTimeOff;

    @FXML
    private JFXButton btnEmployeeTimeOn;

  @FXML
  private JFXButton   btnOverVeiw;

    @FXML
    private JFXButton btnFingerPrintRegister;

    @FXML
    private JFXButton btnFingerPrintRegister1;

    @FXML
    private JFXButton btnListenFingerPrintInput;

    @FXML
    private JFXButton btnResetForm11;

    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private JFXTextField txtEmployeeNic;

    @FXML
    void btnAddRecordOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancleOnAction(ActionEvent event) {

    }

    @FXML
    void btnEmployeeTimeOffOnAction(ActionEvent event) {

      AttendenceDTO attendenceDTO=attendenceService.getnewAttendence(txtEmployeeNic.getText());
      System.out.println(attendenceDTO.toString());
      attendenceDTO.setStop(LocalTime.now());
      attendenceService.setOnRecorde(attendenceDTO);
    }

    @FXML
    void btnEmployeeTimeOnAction(ActionEvent event) {
        AttendenceDTO attendenceDTO=new AttendenceDTO(
                attendenceService.getNewAttendenceID(),
                txtEmployeeNic.getText(),
                LocalDate.now(),
                LocalTime.now(),
                LocalTime.now()
                );
        attendenceService.setOnRecorde(attendenceDTO);


    }

    @FXML
    void btnFingerPrintRegister(ActionEvent event) {

    }

    @FXML
    void btnListenFingerPrintInputOnAction(ActionEvent event) {

    }

  @FXML
  void btnOverVeiwOnAcrion(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EmployeeAttendenceOverView.fxml"));
      Parent root = loader.load();

      Stage popupStage = new Stage();
      popupStage.setTitle("Attendence Overview");
      popupStage.setScene(new Scene(root));
      popupStage.initModality(Modality.APPLICATION_MODAL);
      popupStage.setResizable(false);
      popupStage.showAndWait();


    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  @FXML
  void upComming(ActionEvent event) {

  }

    @FXML
    void btnResetFormOnAction(ActionEvent event) {

    }

    @FXML
    void txtEmployeeNicOnAction(ActionEvent event) {
        checkEmployee();


    }

    private void checkEmployee() {
        String nic=txtEmployeeNic.getText();
        EmployeeDTO employeeDTO=employeeService.searchByEmployerNic(nic);
        txtEmployeeName.setText(employeeDTO.getEmplyeeName());

    }

}
