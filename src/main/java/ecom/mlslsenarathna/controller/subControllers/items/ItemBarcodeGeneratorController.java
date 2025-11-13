package ecom.mlslsenarathna.controller.subControllers.items;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.service.ItemService;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ItemBarcodeGeneratorController {
    ItemService itemService=new ItemService();

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnBarcodeGenerator;

    @FXML
    private JFXButton btnPrint;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private ImageView imgBarcode;

    @FXML
    private Label lblAvailability;

    @FXML
    private JFXTextField txtSerchInput;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnBarcodeGeneratorOnAction(ActionEvent event) {
        ItemDTO itemDTO=itemService.searchItemByID(txtSerchInput.getText());
      if(itemService.isAvailabile(itemDTO)){
          imgBarcode.setImage(itemService.generatNewBarcode(itemDTO));
      }else{
          JOptionPane.showMessageDialog(null,"This item Is not Available");
      }

    }

    @FXML
    void btnPrintOnAction(ActionEvent event) {
        if(imgBarcode.getImage()!=null){

            Image fxImage = imgBarcode.getImage();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            itemService.printBarCode(stage, fxImage);
            JOptionPane.showMessageDialog(null,"Print completed !!");
        }else{
            JOptionPane.showMessageDialog(null,"Generate Barcode Properly !");
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        ItemDTO itemDTO=itemService.searchItemByID(txtSerchInput.getText());
        lblAvailability.setText(itemService.checkAvailability(itemDTO));

    }

    @FXML
    void txtSerchInputOnAction(ActionEvent event) {
        ItemDTO itemDTO=itemService.searchItemByID(txtSerchInput.getText());
        lblAvailability.setText(itemService.checkAvailability(itemDTO));
    }

}
