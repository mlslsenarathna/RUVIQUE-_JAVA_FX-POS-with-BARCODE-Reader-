package ecom.mlslsenarathna.controller.subControllers.items;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.service.ItemService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class DeleteItemController {
    ItemService itemService=new ItemService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXTextField txtColor;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtManufacturePrice;

    @FXML
    private JFXTextField txtSerchInput;

    @FXML
    private JFXTextField txtStockCount;

    @FXML
    private JFXTextField txtSupplierID;

    @FXML
    private JFXTextField txtSupplierPrice;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        if(itemService.isItemId(txtSerchInput.getText())) {
           ItemDTO itemDTO= itemService.searchItemByID(txtSerchInput.getText());
           setFeilds(itemDTO);
        }

    }

    private void setFeilds(ItemDTO itemDTO) {
        txtItemName.setText(itemDTO.getItemName());
        txtSupplierID.setText(itemDTO.getSupplierId());
        txtColor.setText(itemDTO.getColor());
        txtStockCount.setText(String.valueOf(itemDTO.getStockCount()));
        txtManufacturePrice.setText(itemDTO.getManufactureCountry());
        txtSupplierPrice.setText(String.valueOf(itemDTO.getSellingPrice()));
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if(itemService.isItemId(txtSerchInput.getText())) {
            ItemDTO itemDTO= itemService.searchItemByID(txtSerchInput.getText());
           itemService.deleteItemById(itemDTO);
        }
        resetFields();
    }

    private void resetFields() {
        txtColor.setText(null);
        txtItemName.setText(null);
        txtManufacturePrice.setText(null);
        txtSerchInput.setText(null);
        txtStockCount.setText(null);
        txtSupplierID.setText(null);
        txtSupplierPrice.setText(null);
    }

    @FXML
    void txtSerchInputOnAction(ActionEvent event) {
        if(itemService.isItemId(txtSerchInput.getText())) {
            ItemDTO itemDTO= itemService.searchItemByID(txtSerchInput.getText());
            setFeilds(itemDTO);
        }
    }

}
