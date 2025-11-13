package ecom.mlslsenarathna.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;



public class HomePageController implements Initializable {
    @FXML
    private BorderPane CustomerManagementBoarderLayout;

    @FXML
    private BorderPane HomePageViewBoarderPane;


    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnEmployees;

    @FXML
    private ImageView btnFacebook;

    @FXML
    private Button btnHome;

    @FXML
    private Button btlEmployees;

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
    private Label lblDateTime;
    @FXML
    private Label lblDateAsName;
    @FXML
    private Label lblWelcomNote;
    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        try {
            Parent customerContent = FXMLLoader.load(
                    getClass().getResource("/view/CustomerManagement.fxml")
            );

            HomePageViewBoarderPane.setCenter(customerContent);

        } catch (IOException e) {
            e.printStackTrace();

    }
        }

    @FXML
    void onMouseClickFacebook(MouseEvent event) {
        try {

            String url = "https://www.facebook.com/";


            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onMouseClickInster(MouseEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.Instergram.com/"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onMouseClickTiktok(MouseEvent event) {
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.Tiktok.com/"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnFacebookOnAction(MouseEvent event) {


    }

    @FXML
    void btlEmployeesOnAction(ActionEvent event) {

    }
    @FXML
    void btnHomeOnAction(ActionEvent event) {
        try {
            Parent homeContent = FXMLLoader.load(
                    getClass().getResource("/view/HomeContent.fxml")
            );

            HomePageViewBoarderPane.setCenter(homeContent);

        } catch (IOException e) {
            e.printStackTrace();

        }




    }

    @FXML
    void btnInsterOnAction(MouseEvent event) {

    }

    @FXML
    void btnItemsOnAction(ActionEvent event) {
        try {
            Parent customerContent = FXMLLoader.load(
                    getClass().getResource("/view/ItemManagement.fxml")
            );

            HomePageViewBoarderPane.setCenter(customerContent);

        } catch (IOException e) {
            e.printStackTrace();

        }

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
    void onEnteredEmployee(MouseEvent event) {
        btnEmployees.setStyle("-fx-background-color: Gray; -fx-text-fill: Black;");


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
    void onPressEmployee(MouseEvent event) {

        btnEmployees.setStyle("-fx-background-color: #35363A; -fx-text-fill: #E3B853;");


    }

    @FXML
    void onReleaseCustomer(MouseEvent event) {
        btnCustomer.setStyle("-fx-background-color: #35363A; -fx-text-fill: white;");

    }
    @FXML
    void onReleaseEmployee(MouseEvent event) {
        btnEmployees.setStyle("-fx-background-color: #35363A; -fx-text-fill: white;");

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
    private void setDateAndTime() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        Timeline clock = new Timeline(
                new KeyFrame(javafx.util.Duration.seconds(1), e -> {
                    String date = java.time.LocalDate.now().toString();
                    String time = java.time.LocalTime.now().format(timeFormatter);
                    lblDateTime.setText(date + "  " + time);
                })
        );
        clock.setCycleCount(Timeline.INDEFINITE);
        clock.play();
    }
    private  void setDataAsName(){
        LocalDate today = LocalDate.now();

        DayOfWeek dayOfWeek = today.getDayOfWeek();
        Month month=today.getMonth();


        String dayName = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        lblDateAsName.setText(dayName+","+month);

    }

    public static String getGreetingMessage() {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();

        if (hour >= 5 && hour < 12) {
            return "Good Morning 🌅";
        } else if (hour >= 12 && hour < 16) {
            return "Good Afternoon ☀️";
        } else if (hour >= 16 && hour < 20) {
            return "Good Evening 🌇";
        } else {
            return "Good Night 🌙";
        }

    }
    private void setWelCome(){
        lblWelcomNote.setText("");
        String text="Hello..    Master.."+getGreetingMessage();
        int speedMs = 10;

        Timeline timeline = new Timeline();
        final int[] index = {0};

        KeyFrame keyFrame = new KeyFrame(Duration.millis(speedMs), event -> {
            if (index[0] < text.length()) {
                lblWelcomNote.setText(lblWelcomNote.getText() + text.charAt(index[0]));
                index[0]++;
            }
        });

        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(text.length());
        timeline.play();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDateAndTime();
        setDataAsName();
        setWelCome();
        setCenterContent();
    }

    private void setCenterContent() {
        try {
            Parent homeContent = FXMLLoader.load(
                    getClass().getResource("/view/HomeContent.fxml")
            );

            HomePageViewBoarderPane.setCenter(homeContent);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
