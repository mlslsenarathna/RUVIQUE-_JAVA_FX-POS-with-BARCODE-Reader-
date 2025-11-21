package ecom.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.model.dto.OrderCartItemDTO;
import ecom.mlslsenarathna.model.dto.OrderDTO;
import ecom.mlslsenarathna.model.entity.OrderEntity;
import ecom.mlslsenarathna.service.CustomerService;
import ecom.mlslsenarathna.service.ItemService;
import ecom.mlslsenarathna.service.OrderService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.ResourceBundle;

public class OrdersManagementController implements Initializable {
    ItemService itemService=new ItemService();
    CustomerService customerService=new CustomerService();
    OrderService orderService=new OrderService();
    ObservableList<OrderCartItemDTO> orderList= FXCollections.observableArrayList();

    @FXML
    private JFXButton btnAddItemtoList;

    @FXML
    private JFXButton btnCancle;

    @FXML
    private JFXButton btnCheck;

    @FXML
    private JFXButton btnDeleteItem;

    @FXML
    private JFXButton btnDiscount;

    @FXML
    private JFXButton btnPrintBill;

    @FXML
    private JFXButton btnResetOrder;

    @FXML
    private JFXButton btnVeiwOrders;

    @FXML
    private TableColumn<?, ?> colItemName;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableColumn<?, ?> colSize;
    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblOrderId1;

    @FXML
    private Label lblOrderId11;

    @FXML
    private Label lblOrderId111;

    @FXML
    private JFXToggleButton tglBarCodeScaner;

    @FXML
    private JFXTextField  txtItenCode;

    @FXML
    private JFXTextField txtCustomerMobile;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXTextField  txtQty;

    @FXML
    private JFXTextField txtNetTotal;

    @FXML
    private JFXTextField txtTotalPeice;
    @FXML
    private TableView<OrderCartItemDTO> tbtOrdersList;


    @FXML
    void btnAddItemtoListOnAction(ActionEvent event) {
        ItemDTO itemDTO=itemService.searchItemByID(txtItenCode.getText());
        int qty=Integer.parseInt(txtQty.getText());
        double price=itemDTO.getSellingPrice()*qty;
        Iterator var6 = this.tbtOrdersList.getItems().iterator();

        OrderCartItemDTO existing;
        do {
            if (!var6.hasNext()) {
                this.tbtOrdersList.getItems().add(new OrderCartItemDTO(itemDTO.getItemId(),itemDTO.getItemName(), itemDTO.getSize(),qty, price));
                this.calculateOrderTotal();
                this.txtQty.setText("");
                return;
            }

            existing = (OrderCartItemDTO )var6.next();
        } while(!existing.getId().equals(itemDTO.getItemId()));

        int newItenQTY = Integer.parseInt(this.txtQty.getText()) + existing.getQuantity();
        existing.setQuantity(newItenQTY);
        existing.setPrice(itemDTO.getSellingPrice() * (double)newItenQTY);
        this.tbtOrdersList.refresh();
        this.calculateOrderTotal();
        this.txtQty.clear();

    }

    private double calculateOrderTotal() {

        double total = this.tbtOrdersList.getItems().stream().mapToDouble(OrderCartItemDTO::getPrice).sum();
        this.txtTotalPeice.setText("Rs." + total + "0");
        return total;

    }

    @FXML
    void btnAdditemOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancleOnAction(ActionEvent event) {

    }

    @FXML
    void btnCheckOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnDiscountOnAction(ActionEvent event) {

    }

    @FXML
    void btnResetOrderOnAction(ActionEvent event) {
        this.tbtOrdersList.getItems().clear();
        this.calculateOrderTotal();
    }


    @FXML
    void  txtItenCodeOnAction(ActionEvent event) {

    }

    @FXML
    void btnVeiwOrdersOnAction(ActionEvent event) {

    }

    @FXML
    void tglBarCodeScanerOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setOrderID();
        this.colItemId.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.colItemName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        this.colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        this.colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    private void setOrderID() {
        lblOrderId.setText(orderService.setOrderId());
    }
}
