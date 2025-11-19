package ecom.mlslsenarathna.controller.subControllers.supplier;

import com.jfoenix.controls.JFXButton;
import ecom.mlslsenarathna.model.dto.SupplierVeiwDTO;
import ecom.mlslsenarathna.service.SupplierService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierViewController implements Initializable {
    SupplierService supplierService=new SupplierService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colCountry;

    @FXML
    private TableView<SupplierVeiwDTO> tblSupplierView;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        this.colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.colCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        loadSuppliers();

    }

    private void loadSuppliers() {
        ObservableList<SupplierVeiwDTO> suppliers=supplierService.getAllSuppliers();
        tblSupplierView.setItems(suppliers);
    }
}
