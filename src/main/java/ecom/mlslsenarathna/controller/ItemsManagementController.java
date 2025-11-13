package ecom.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.service.ItemService;
import ecom.mlslsenarathna.service.SupplierService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemsManagementController implements Initializable {
    SupplierService supplierService=new SupplierService();
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
        if(supplierService.isSupplierId(txtSupplierId.getText())) {
            ItemDTO itemDTO = registerNewItem();
            itemService.registerItem(itemDTO);

        }else{
            JOptionPane.showMessageDialog(null,"Check supplier ID");
        }

    }




    @FXML
    void btnBarcodegeneratoronAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ItemBarCodeGenerator.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("BarCode Generator");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnCancleOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteItemonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DeleteItem.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Delete Item");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnOutofStockOnAcrion(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ItemOutOfStock.fxml"));
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
    void btnResetFormOnAction(ActionEvent event) {
        txtColor.setText(null);
        txtDescription.setText(null);
        txtItemName.setText(null);
        txtSize.setText(null);
        txtManufactureCountry.setText(null);
        txtSellingPrice.setText(null);
        txtSupplierId.setText(null);
        txtSellingPrice.setText(null);
        txtStockCount.setText(null);
        txtSuppilerPrice.setText(null);
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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewItems.fxml"));
            Parent root = loader.load();

            Stage popupStage = new Stage();
            popupStage.setTitle("Veiw Items");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
