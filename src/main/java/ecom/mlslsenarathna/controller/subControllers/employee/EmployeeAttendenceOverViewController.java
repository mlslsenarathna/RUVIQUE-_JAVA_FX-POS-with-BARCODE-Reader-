package ecom.mlslsenarathna.controller.subControllers.employee;

import com.jfoenix.controls.JFXButton;
import ecom.mlslsenarathna.model.dto.AttedensVeiwDTO;
import ecom.mlslsenarathna.service.AttendenceService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeAttendenceOverViewController implements Initializable {
    AttendenceService attendenceService=new AttendenceService();


    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colWorkingDays;

    @FXML
    private TableColumn<?, ?> colWorkingHours;

    @FXML
    private TableView<AttedensVeiwDTO> tblAttendence;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        this.colWorkingDays.setCellValueFactory(new PropertyValueFactory<>("days"));
        this.colWorkingHours.setCellValueFactory(new PropertyValueFactory<>("hours"));
        loadTableData();
    }

    private void loadTableData() {
      tblAttendence.setItems(attendenceService.setEmployeeWorkigData());



    }
}
