package ecom.mlslsenarathna.controller.subControllers.employee;

import com.jfoenix.controls.JFXButton;
import ecom.mlslsenarathna.model.dto.EmployeeVeiwDTO;
import ecom.mlslsenarathna.service.EmployeeService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeesViewController implements Initializable {
    EmployeeService employeeService=new EmployeeService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colAddress;


    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<EmployeeVeiwDTO> tblEmployees;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.colMobile.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        this.colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));

        loadEmployees();
    }

    private void loadEmployees() {
        ObservableList<EmployeeVeiwDTO> employeeVeiwDTOS=employeeService.getAllEmployeeViewDetails();
        tblEmployees.setItems(employeeVeiwDTOS);
    }
}
