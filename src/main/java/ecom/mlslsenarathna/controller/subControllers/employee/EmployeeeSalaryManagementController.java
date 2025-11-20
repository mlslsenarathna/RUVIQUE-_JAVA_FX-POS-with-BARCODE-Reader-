package ecom.mlslsenarathna.controller.subControllers.employee;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.AttedensVeiwDTO;
import ecom.mlslsenarathna.model.dto.AttendenceDTO;
import ecom.mlslsenarathna.model.dto.EmployeeDTO;
import ecom.mlslsenarathna.service.AttendenceService;
import ecom.mlslsenarathna.service.EmployeeService;
import ecom.mlslsenarathna.service.SalaryService;
import ecom.mlslsenarathna.service.WorkingTimeCalculatorService;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class EmployeeeSalaryManagementController {
    WorkingTimeCalculatorService workingTimeCalculatorService=new WorkingTimeCalculatorService();
    AttendenceService attendenceService=new AttendenceService();
    SalaryService salaryService=new SalaryService();
    
    EmployeeService employeeService=new EmployeeService();


    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnPrintPaySheet;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private Label lblAllownce;

    @FXML
    private Label lblEPF;

    @FXML
    private Label lblETF;

    @FXML
    private Label lblNewSalary;

    @FXML
    private Label lblNonLeaveBonus;

    @FXML
    private Label lblOTHours;

    @FXML
    private Label lblOverTimePayment;

    @FXML
    private Label lblSalary;

    @FXML
    private Label lblWorkedHours;

    @FXML
    private Label lblWorkingDays;

    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private JFXTextField txtEmployeeNic;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnPrintPaySheetOnAction(ActionEvent event) {
        printPaySheet();

    }

    private void printPaySheet() {


    }


    @FXML
    void btnSearchOnAction(ActionEvent event) {
        setSalaryDetails(txtEmployeeNic.getText());

    }

    @FXML
    void txtEmployeeNicOnAction(ActionEvent event) {
        setSalaryDetails(txtEmployeeNic.getText());
    }

    private void setSalaryDetails(String nic) {
        EmployeeDTO employeeDTO=employeeService.searchByEmployerNic(nic);
        txtEmployeeName.setText(employeeDTO.getEmplyeeName());
        getEmployeeWorkingDetails();
        
        
        
    }

    private void getEmployeeWorkingDetails() {
        ObservableList<AttendenceDTO> attendenceDTOS=attendenceService.getAttendenceByNationaId(txtEmployeeNic.getText());

        AttedensVeiwDTO attedensVeiwDTO = attendenceService.getAttendenceInfo(attendenceDTOS);
        double hours=attedensVeiwDTO.getHours();
        double netSalary=salaryService.getNetSalary(hours);
        lblNewSalary.setText(String.format("%.2f",netSalary));
        lblWorkingDays.setText(String.format("%.2f",workingTimeCalculatorService.getDays(hours)));
        lblNonLeaveBonus.setText(String.format("%.2f",salaryService.nonLeaveBonus(hours)));
        lblEPF.setText(String.format("%.2f",salaryService.epfCalculator(netSalary)));
        lblETF.setText(String.format("%.2f",salaryService.etfCalculator(netSalary)));
        lblAllownce.setText(String.format("%.2f",salaryService.allownceCalculator(netSalary)));
        lblWorkedHours.setText(String.format("%.2f",hours));
        lblOTHours.setText(String.format("%.2f",salaryService.getOThours(hours)));
        lblOverTimePayment.setText(String.format("%.2f", salaryService.overTimeCalculator(hours)));
        generateTotalSalary();

    }

    private void generateTotalSalary() {
        double netSalary= Double.parseDouble(lblNewSalary.getText());
        double allowwance= Double.parseDouble(lblAllownce.getText());
        double otpay= Double.parseDouble(lblOverTimePayment.getText());
        double nonleaveBonus= Double.parseDouble(lblNonLeaveBonus.getText());
        double salary=netSalary+allowwance+otpay+nonleaveBonus;
        lblSalary.setText(String.valueOf(salary));
    }

}
