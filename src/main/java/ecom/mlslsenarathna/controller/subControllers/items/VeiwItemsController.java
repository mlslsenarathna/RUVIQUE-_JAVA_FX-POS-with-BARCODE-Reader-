package ecom.mlslsenarathna.controller.subControllers.items;

import com.jfoenix.controls.JFXButton;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.model.dto.ViewCustomerDTO;
import ecom.mlslsenarathna.service.ItemService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VeiwItemsController implements Initializable {
    ItemService itemService=new ItemService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> colColor;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colManufactureCountry;

    @FXML
    private TableColumn<?, ?> colSellingPrice;

    @FXML
    private TableColumn<?, ?> colSize;

    @FXML
    private TableColumn<?, ?> colStockCount;

    @FXML
    private TableColumn<?, ?> colSupplierPrice;

    @FXML
    private TableColumn<?, ?> colitemsName;

    @FXML
    private TableColumn<?, ?> colsupplierId;

    @FXML
    private TableView<ItemDTO> tblItemsVeiw;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        this.colitemsName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        this.colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        this.colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        this.colManufactureCountry.setCellValueFactory(new PropertyValueFactory<>("manufactureCountry"));
        this.colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        this.colStockCount.setCellValueFactory(new PropertyValueFactory<>("stockCount"));
        this.colsupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        this.colSellingPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        this.colSupplierPrice.setCellValueFactory(new PropertyValueFactory<>("supplierPrice"));
        loadItemsInStocks();
    }

    private void loadItemsInStocks() {
        ObservableList<ItemDTO> itemsInStock =itemService.getInStockItemsList();
        this.tblItemsVeiw.setItems(itemsInStock);
    }
}
