package ecom.mlslsenarathna.controller.subControllers.customer;

import com.jfoenix.controls.JFXButton;
import ecom.mlslsenarathna.model.dto.CustomerDTO;
import ecom.mlslsenarathna.model.dto.ViewCustomerDTO;
import ecom.mlslsenarathna.service.AddressService;
import ecom.mlslsenarathna.service.CustomerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomersController implements Initializable {
    CustomerService customerService=new CustomerService();


    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colCustomerAddress;

    @FXML
    private TableColumn<?, ?> colCustomerMobile;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colCustomerPostalCode;

    @FXML
    private TableColumn<?, ?> colCustomerTotalVlue;

    @FXML
    private TableView<ViewCustomerDTO> tblCustomeOverView;

    @FXML
    private Label lblTotalCollections;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.colCustomerName.setCellValueFactory(new PropertyValueFactory("customerName"));
        this.colCustomerMobile.setCellValueFactory(new PropertyValueFactory("custMobileNumber"));
        this.colCustomerAddress.setCellValueFactory(new PropertyValueFactory("customerAddress"));
        this.colCustomerPostalCode.setCellValueFactory(new PropertyValueFactory("postalCode"));
        this.colCustomerTotalVlue.setCellValueFactory(new PropertyValueFactory("totalValue"));

        this.loadCustomerVeiwData();
        this.setTotal();
    }

    private void loadCustomerVeiwData() {
        ObservableList<ViewCustomerDTO> customers =(ObservableList<ViewCustomerDTO>) getCustomerVeiwData();
        this.tblCustomeOverView.setItems(customers);
    }


    private void setTotal() {
       double totalCollection=customerService.getTotalCustomers();
       lblTotalCollections.setText("Rs."+totalCollection+"0");
    }

    private List<ViewCustomerDTO> getCustomerVeiwData() {

        return customerService.getCustomersList();

    }
}
