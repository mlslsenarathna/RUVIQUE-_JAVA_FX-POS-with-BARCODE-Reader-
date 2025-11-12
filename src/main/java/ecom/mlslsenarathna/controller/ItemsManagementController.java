package ecom.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.service.ItemService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemsManagementController implements Initializable {
    ItemService itemService=new ItemService();

    @FXML
    private JFXButton btnAddItem;

    @FXML
    private JFXButton btnBarcodegenerator;

    @FXML
    private JFXButton btnCancle;

    @FXML
    private JFXButton btnDeleteItem;

    @FXML
    private JFXButton btnOutofStock;

    @FXML
    private JFXButton btnResetForm;

    @FXML
    private JFXButton btnUpdatePrice;

    @FXML
    private JFXButton btnUpdateStock;

    @FXML
    private JFXButton btnViewItems;

    @FXML
    private Label lblItemId;

    @FXML
    private JFXTextField txtColor;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtManufactureCountry;

    @FXML
    private JFXTextField txtSellingPrice;

    @FXML
    private JFXTextField txtSize;

    @FXML
    private JFXTextField txtStockCount;

    @FXML
    private JFXTextField txtSuppilerPrice;

    @FXML
    private JFXTextField txtSupplierId;

    @FXML
    void btnAdditemOnAction(ActionEvent event) {
       ItemDTO itemDTO=registerNewItem();
       itemService.registerItem(itemDTO);


    }

    @FXML
    void btnBarcodegeneratoronAction(ActionEvent event) {

    }

    @FXML
    void btnCancleOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteItemonAction(ActionEvent event) {

    }

    @FXML
    void btnOutofStockOnAcrion(ActionEvent event) {

    }

    @FXML
    void btnResetFormOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdatePriceOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UpdateItemPrice.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Update Price");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnUpdateStockonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/UpdateStockCount.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Update Stock Count");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnViewItemsonAction(ActionEvent event) {

    }
    private ItemDTO registerNewItem(){
        return  new ItemDTO(
                lblItemId.getText(),
                txtItemName.getText(),
                txtSupplierId.getText(),
                txtDescription.getText(),
                txtColor.getText(),
                txtSize.getText(),
                Integer.parseInt(txtStockCount.getText()),
                txtManufactureCountry.getText(),
                Double.parseDouble(txtSuppilerPrice.getText()),
                Double.parseDouble(txtSellingPrice.getText())
        );
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblItemId.setText(itemService.setNewItemId());
    }
}
