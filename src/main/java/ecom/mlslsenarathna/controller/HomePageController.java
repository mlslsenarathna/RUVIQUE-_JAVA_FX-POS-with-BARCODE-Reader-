package ecom.mlslsenarathna.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML
    private Button btnCustomer;

    @FXML
    private ImageView btnFacebook;

    @FXML
    private Button btnHome;

    @FXML
    private ImageView btnInster;

    @FXML
    private Button btnItems;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSuppilers;

    @FXML
    private ImageView btnTiktok;

    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        Stage stage= (Stage) btnCustomer.getScene().getWindow();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerManagement.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnFacebookOnAction(MouseEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        Stage stage= (Stage) btnHome.getScene().getWindow();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/HomePageView.fxml"))));
            stage.setMaximized(true);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }

    @FXML
    void btnInsterOnAction(MouseEvent event) {

    }

    @FXML
    void btnItemsOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnSettingsOnAction(ActionEvent event) {

    }

    @FXML
    void btnSuppilersOnAction(ActionEvent event) {

    }

    @FXML
    void btnTiktokOnAction(MouseEvent event) {

    }

    @FXML
    void onEnteredCustomer(MouseEvent event) {
        btnCustomer.setStyle("-fx-background-color: Gray; -fx-text-fill: Black;");

    }

    @FXML
    void onEnteredHome(MouseEvent event) {
        btnHome.setStyle("-fx-background-color: Gray; -fx-text-fill: Black;");


    }

    @FXML
    void onEnteredItems(MouseEvent event) {
        btnItems.setStyle("-fx-background-color: Gray; -fx-text-fill: Black;");

    }

    @FXML
    void onEnteredOrder(MouseEvent event) {
        btnOrder.setStyle("-fx-background-color: Gray; -fx-text-fill: Black;");

    }

    @FXML
    void onEnteredSettings(MouseEvent event) {
        btnSettings.setStyle("-fx-background-color: Gray; -fx-text-fill: Black;");



    }

    @FXML
    void onEnteredSupplier(MouseEvent event) {
        btnSuppilers.setStyle("-fx-background-color: Gray; -fx-text-fill: Black;");


    }

    @FXML
    void onPressCustomer(MouseEvent event) {

        btnCustomer.setStyle("-fx-background-color: #35363A; -fx-text-fill: #E3B853;");

    }

    @FXML
    void onPressHome(MouseEvent event) {
        btnHome.setStyle("-fx-background-color: #35363A; -fx-text-fill: #E3B853;");
    }

    @FXML
    void onPressItems(MouseEvent event) {

        btnItems.setStyle("-fx-background-color: #35363A; -fx-text-fill: #E3B853;");


    }

    @FXML
    void onPressOrder(MouseEvent event) {
        btnOrder.setStyle("-fx-background-color: #35363A; -fx-text-fill: #E3B853;");
    }

    @FXML
    void onPressSettings(MouseEvent event) {

        btnSettings.setStyle("-fx-background-color: #35363A; -fx-text-fill: #E3B853;");
    }

    @FXML
    void onPressSupplier(MouseEvent event) {

        btnSuppilers.setStyle("-fx-background-color: #35363A; -fx-text-fill: #E3B853;");


    }

    @FXML
    void onReleaseCustomer(MouseEvent event) {
        btnCustomer.setStyle("-fx-background-color: #35363A; -fx-text-fill: white;");

    }

    @FXML
    void onReleaseHome(MouseEvent event) {
        btnHome.setStyle("-fx-background-color: #35363A; -fx-text-fill: white;");

    }

    @FXML
    void onReleaseItems(MouseEvent event) {
        btnItems.setStyle("-fx-background-color: #35363A; -fx-text-fill: white;");

    }

    @FXML
    void onReleaseOrder(MouseEvent event) {
        btnOrder.setStyle("-fx-background-color: #35363A; -fx-text-fill: white;");

    }

    @FXML
    void onReleaseSettings(MouseEvent event) {
        btnSettings.setStyle("-fx-background-color: #35363A; -fx-text-fill: white;");

    }

    @FXML
    void onReleaseSupplier(MouseEvent event) {
        btnSuppilers.setStyle("-fx-background-color: #35363A; -fx-text-fill: white;");
    }

}
