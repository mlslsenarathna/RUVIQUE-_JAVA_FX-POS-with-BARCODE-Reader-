package ecom.mlslsenarathna.controller.subControllers.items;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.service.ItemService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UpdateItemStockCountController {
    ItemService itemService=new ItemService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXTextField txtOldStock;

    @FXML
    private JFXTextField txtNewStock;

    @FXML
    private JFXTextField txtSerchInput;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        ItemDTO itemDTO=itemService.searchItemByID(txtSerchInput.getText());
        txtOldStock.setText(String.valueOf(itemDTO.getStockCount()));
        
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ItemDTO itemDTO=itemService.searchItemByID(txtSerchInput.getText());
        itemDTO.setStockCount(Integer.parseInt(txtNewStock.getText())+itemDTO.getStockCount());
        itemService.updateItemById(itemDTO);
        resetForm();
    }

    private void resetForm() {
        txtOldStock.setText(null);
        txtNewStock.setText(null);
        txtSerchInput.setText(null);
    }

    @FXML
    void txtSerchInputOnAction(ActionEvent event) {
        ItemDTO itemDTO=itemService.searchItemByID(txtSerchInput.getText());
        txtOldStock.setText(String.valueOf(itemDTO.getStockCount()));
    }

}
