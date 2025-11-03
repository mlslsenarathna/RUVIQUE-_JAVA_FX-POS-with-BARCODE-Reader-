package ecom.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CustomerController {

    @FXML
    private JFXButton btnCancle;

    @FXML
    private Button btnCustomer;

    @FXML
    private JFXButton btnDeleteCustomer;

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
    private JFXButton btnRegister;

    @FXML
    private JFXButton btnResetForm;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSuppilers;

    @FXML
    private ImageView btnTiktok;

    @FXML
    private JFXButton btnUpdateAddress;

    @FXML
    private JFXButton btnUpdateMobileNumber;

    @FXML
    private JFXButton btnViewCustomers;

    @FXML
    private JFXComboBox<?> cmdSex;

    @FXML
    private DatePicker dobDate;

    @FXML
    private Label lblCustomerId;

    @FXML
    private Label lblDateTime;

    @FXML
    private JFXTextField txtAddressLine1;

    @FXML
    private JFXTextField txtAddressLine2;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXTextField txtDistrict;

    @FXML
    private JFXTextField txtMobile;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPostalCode;

    @FXML
    void btnCancleOnAction(ActionEvent event) {

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnFacebookOnAction(MouseEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {


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
    void btnRegisterOnAction(ActionEvent event) {

    }

    @FXML
    void btnResetFormOnAction(ActionEvent event) {

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
    void btnUpdateAddressOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateMobileNumberOnAction(ActionEvent event) {

    }

    @FXML
    void btnViewCustomersOnAction(ActionEvent event) {

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
