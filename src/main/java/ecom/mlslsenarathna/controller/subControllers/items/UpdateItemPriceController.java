package ecom.mlslsenarathna.controller.subControllers.items;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.service.ItemService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class UpdateItemPriceController {
    ItemService itemService=new ItemService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnSet;

    @FXML
    private JFXTextField txtNewPrice;

    @FXML
    private JFXTextField txtOldPrice;

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
        txtOldPrice.setText(String.valueOf(itemDTO.getSellingPrice()));


    }

    @FXML
    void btnSetOnAction(ActionEvent event) {
        ItemDTO itemDTO=itemService.searchItemByID(txtSerchInput.getText());
        itemDTO.setSellingPrice(Double.parseDouble(txtNewPrice.getText()));
        itemService.updateItemById(itemDTO);
        resetForm();
    }

    private void resetForm() {
        txtOldPrice.setText(null);
        txtSerchInput.setText(null);
        txtNewPrice.setText(null);
    }

    @FXML
    void txtSerchInputOnAction(ActionEvent event) {
        ItemDTO itemDTO=itemService.searchItemByID(txtSerchInput.getText());
        txtOldPrice.setText(String.valueOf(itemDTO.getSellingPrice()));
    }

}
