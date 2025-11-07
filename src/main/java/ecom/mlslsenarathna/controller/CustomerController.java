package ecom.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import ecom.mlslsenarathna.model.dto.AddressDTO;
import ecom.mlslsenarathna.model.dto.CustomerDTO;
import ecom.mlslsenarathna.service.AddressService;
import ecom.mlslsenarathna.service.CustomerService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.time.format.DateTimeFormatter;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    CustomerService customerService=new CustomerService();
    AddressService addressService=new AddressService();

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
    private JFXComboBox<String> cmdSex;

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
        Stage stage= (Stage) btnCustomer.getScene().getWindow();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerManagement.fxml"))));
            stage.setMaximized(true);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnFacebookOnAction(MouseEvent event) {

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        Stage stage= (Stage) btnHome.getScene().getWindow();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/HomePageView.fxml"))));
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
    void btnRegisterOnAction(ActionEvent event) {
       CustomerDTO newCustomer=getNewRegisterCustomer();
        customerService.registerCustomer(newCustomer);
        resetForm();

    }

    private CustomerDTO getNewRegisterCustomer() {
        String custId=lblCustomerId.getText();
        String name=txtName.getText();
        String mobileNum=txtMobile.getText();
        String sex=cmdSex.getValue();
        String addressId= addressService.getAddressId();
        AddressDTO address=new AddressDTO(
                addressId,
                txtAddressLine1.getText(),
                txtAddressLine2.getText(),
                txtCity.getText(),
                txtDistrict.getText(),
                txtPostalCode.getText()

        );
        LocalDate dob=dobDate.getValue();
        addressService.registrationAddress(address);
        return new CustomerDTO(custId,name,mobileNum,sex,addressId,dob);

    }
    @FXML
    void btnResetFormOnAction(ActionEvent event) {
        resetForm();

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
        Stage stage= (Stage) btnUpdateMobileNumber.getScene().getWindow();

        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/UpdateMobile.fxml"))));
            stage.setMaximized(true);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setSexComboBox();
        setDateAndTime();
        lblCustomerId.setText(customerService.getCustomerID());

    }

    private void setSexComboBox() {
        cmdSex.getItems().addAll("Female","Male");
    }

    private void setDateAndTime() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        Timeline clock = new Timeline(
                new KeyFrame(javafx.util.Duration.seconds(1), e -> {
                    String date = java.time.LocalDate.now().toString();
                    String time = java.time.LocalTime.now().format(timeFormatter);
                    lblDateTime.setText(date + "  " + time);
                })
        );
        clock.setCycleCount(Timeline.INDEFINITE); // run forever
        clock.play(); // start clock
    }
    private  void resetForm(){
        lblCustomerId.setText(customerService.getCustomerID());
        txtName.setText(null);
        txtMobile.setText(null);
        cmdSex.setValue(null);
        txtAddressLine1.setText(null);
        txtAddressLine2.setText(null);
        txtCity.setText(null);
        txtDistrict.setText(null);
        txtPostalCode.setText(null);
        dobDate.setValue(null);
    }

}
