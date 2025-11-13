package ecom.mlslsenarathna.controller.subControllers.items;

import com.jfoenix.controls.JFXButton;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.model.dto.ItemOutOfStockDTO;
import ecom.mlslsenarathna.model.dto.SupplierDTO;
import ecom.mlslsenarathna.model.dto.ViewCustomerDTO;
import ecom.mlslsenarathna.service.ItemService;
import ecom.mlslsenarathna.service.SupplierService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ItemOutOfStockController implements Initializable {
    ItemService itemService=new ItemService();
    SupplierService supplierService=new SupplierService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSendAlert;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colStock;
    @FXML
    private TableColumn<?, ?> colSupplierEmail;

    @FXML
    private TableColumn<?, ?> colSupplierContact;

    @FXML
    private TableColumn<?, ?> colSupplierName;

    @FXML
    private TableView<ItemOutOfStockDTO> tblOutofStock;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnSendAlertOnAction(ActionEvent event) {

        ItemOutOfStockDTO selected = tblOutofStock.getSelectionModel().getSelectedItem();
        ItemDTO itemDTO=itemService.searchItemByID(selected.getItemId());
        SupplierDTO supplierDTO=supplierService.searchBySupplierId(itemDTO.getSupplierId());
        if (selected != null) {
            setSelectedItem(selected);
            System.out.println(selected.getSupplierName());
            itemService.sendEmailOutOfStockReminder(supplierDTO,itemDTO);


        } else {
            System.out.println("No item selected!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        this.colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        this.colItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        this.colSupplierName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        this.colSupplierContact.setCellValueFactory(new PropertyValueFactory<>("supplierContactNo"));
        this.colSupplierEmail.setCellValueFactory(new PropertyValueFactory<>("supplierEmail"));
        this.colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        this.loadOutOfStockData();


    }

    private void setSelectedItem(ItemOutOfStockDTO newValue) {


    }

    private void loadOutOfStockData() {
        ObservableList<ItemOutOfStockDTO> customers =(ObservableList<ItemOutOfStockDTO>) getOutOfStockItems();
        this.tblOutofStock.setItems(customers);
    }

    private List<ItemOutOfStockDTO> getOutOfStockItems() {
        return itemService.getOutOfStockItems();
    }

}
