package ecom.mlslsenarathna.controller;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeContentController implements Initializable {

    @FXML
    private Rectangle CardThree;

    @FXML
    private Rectangle cardOne;

    @FXML
    private Rectangle cardTwo;
    @FXML
    private Rectangle cardAlert;

    @FXML
    private Label lblCard1Header;

    @FXML
    private Label lblCard1Header1;

    @FXML
    private Label lblCard1Header11;

    @FXML
    private Label lblCard1Header12;

    @FXML
    private Label lblCard1Header2;

    @FXML
    private Label lblCard1Header21;

    @FXML
    private Label lblCard1Header3;

    @FXML
    private Label lblCard1Header31;

    @FXML
    private Label lblTodayIncome;

    @FXML
    private Label lblTodayProfit;

    @FXML
    private Label lblTotalProfit;

    @FXML
    private Label lblmonthlyIncome;

    @FXML
    private Label lblmonthlyProfit;

    @FXML
    void onCardOneMouseEntered(MouseEvent event) {
        zoomCard(cardOne, 1.1);
    }

    @FXML
    void onCardOneMouseExited(MouseEvent event) {
        zoomCard(cardOne, 1.0);
    }

    @FXML
    void onCardTwoMouseEntered(MouseEvent event) {
        zoomCard(cardTwo, 1.1);
    }

    @FXML
    void onCardTwoMouseExited(MouseEvent event) {
        zoomCard(cardTwo, 1.0);
    }

    @FXML
    void onCardThreeMouseEntered(MouseEvent event) {
        zoomCard(CardThree, 1.1);
    }

    @FXML
    void onCardThreeMouseExited(MouseEvent event) {
        zoomCard(CardThree, 1.0);
    }
    @FXML
    void onCardAlertMouseEntered(MouseEvent event) {
        zoomCard(cardAlert, 1.1);
    }

    @FXML
    void onCardAlertMouseExited(MouseEvent event) {
        zoomCard(cardAlert, 1.0);
    }

    @FXML
    void onCardTwoZoomFinished(ZoomEvent event) {
    }

    @FXML
    void onCardTwoZoomStarted(ZoomEvent event) {
    }

    @FXML
    void onZoomOneFinished(ZoomEvent event) {
    }

    @FXML
    void onZoomOneStart(ZoomEvent event) {
    }

    @FXML
    void onZoomThreeFinished(ZoomEvent event) {
    }
    @FXML
    void onZoomAlertStart(ZoomEvent event) {
    }

    @FXML
    void onZoomAlertFinished(ZoomEvent event) {
    }

    @FXML
    void onZoomThreeStart(ZoomEvent event) {
    }

    private void zoomCard(Rectangle card, double scale) {
        ScaleTransition st = new ScaleTransition(Duration.millis(200), card);
        st.setToX(scale);
        st.setToY(scale);
        st.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
