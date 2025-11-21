package ecom.mlslsenarathna.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import ecom.mlslsenarathna.controller.subControllers.order.OrderBillViewController;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.model.dto.OrderCartItemDTO;
import ecom.mlslsenarathna.model.dto.OrderDTO;
import ecom.mlslsenarathna.model.dto.OrderInfoDTO;
import ecom.mlslsenarathna.service.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class OrdersManagementController implements Initializable {
    ItemService itemService=new ItemService();
    CustomerService customerService=new CustomerService();
    OrderService orderService=new OrderService();
    DiscountService discountService=new DiscountService();

    OrderInfoService orderInfoService=new OrderInfoService();


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
        setNetTotal(total);
        return total;

    }

    private void setNetTotal(double total) {

    }

    @FXML
    void btnPrintBillOnAction(ActionEvent event) {

        placeOrder();
       double total=calculateOrderTotal();

        OrderDTO orderDTO = new OrderDTO(
                Long.parseLong(lblOrderId.getText()),
                LocalDateTime.now(),
                txtCustomerMobile.getText(),
                total

        );

        orderService.placeNewOrder(new OrderDTO(
                null,
                orderDTO.getOrderDateandTime(),
                orderDTO.getCustomerMobile(),
                orderDTO.getTotalPrice()
        ));
        tbtOrdersList.getItems();
        List<OrderCartItemDTO> cartItems = tbtOrdersList.getItems();

        String billContent = generateBillContent(orderDTO, cartItems);
        clearCart();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/OrderBillView.fxml"));
            Parent root = loader.load();


            OrderBillViewController controller = loader.getController();
            controller.setBillContent(billContent);

            Stage popupStage = new Stage();
            popupStage.setTitle("Delete Supplier");
            popupStage.setScene(new Scene(root));
            popupStage.initModality(Modality.APPLICATION_MODAL); // Blocks interaction with main window
            popupStage.setResizable(false);
            popupStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void placeOrder() {
        ObservableList<OrderCartItemDTO> itemsList = this.tbtOrdersList.getItems();
        Iterator var3 = itemsList.iterator();

        while(var3.hasNext()) {
            OrderCartItemDTO item = (OrderCartItemDTO)var3.next();
            ItemDTO itemDTO=itemService.searchItemByID(item.getId());
            if (this.txtQty != null) {
                this.orderService.updatStockCount(item.getId(), item.getQuantity());
                this.orderInfoService.registerOrderInfo(new OrderInfoDTO(
                       Long.parseLong(lblOrderId.getText()),
                        item.getId(),
                        item.getQuantity(),
                        itemDTO.getSellingPrice()
                ));
            } else {
                JOptionPane.showMessageDialog((Component)null, "Please Select items");
            }
        }



    }
    public void clearCart(){
        this.tbtOrdersList.getItems().clear();
        this.calculateOrderTotal();
        setOrderID();
    }




    public String generateBillContent(OrderDTO orderDTO, List<OrderCartItemDTO> itemsList) {
        StringBuilder bill = new StringBuilder();

        bill.append("=========================================\n");
        bill.append("          Ruvique_Aperals PVT,LTD        \n");
        bill.append("=========================================\n");
        bill.append(String.format("Bill ID: %s\n", orderDTO.getOrderId()));
        bill.append(String.format("Date:    %s\n", orderDTO.getOrderDateandTime()));
        bill.append("-----------------------------------------\n");
        bill.append(String.format("%-5s %-20s %5s %10s\n", "QTY", "ITEM", "PRICE", "TOTAL"));
        bill.append("-----------------------------------------\n");

        double grandTotal = 0;
        for (OrderCartItemDTO item : itemsList) {
            double itemTotal = item.getPrice();
            grandTotal += itemTotal;

            bill.append(String.format("%-5d %-20s %5.2f %10.2f\n",
                    item.getQuantity(),
                    item.getName(),
                    itemService.getSellingPriceById(item.getId()),
                    itemTotal));
        }

        double netTotal=grandTotal*discountService.getDiscount(txtCustomerMobile.getText());

        bill.append("-----------------------------------------\n");
        bill.append(String.format("%-31s %10.2f\n", "TOTAL:", grandTotal));
        bill.append("=========================================\n");
        bill.append(String.format("%-31s %10.2f\n", "Net Total:", grandTotal-netTotal));
        bill.append("=========================================\n");

        return bill.toString();
    }

    @FXML
    void btnCancleOnAction(ActionEvent event) {

    }

    @FXML
    void btnCheckOnAction(ActionEvent event) {
        txtDiscount.setText(String.valueOf(discountService.getDiscount(txtCustomerMobile.getText())));

    }

    @FXML
    void btnDeleteItemOnAction(ActionEvent event) {
        OrderCartItemDTO selectedItem = (OrderCartItemDTO) this.tbtOrdersList.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            this.tbtOrdersList.getItems().remove(selectedItem);
            this.calculateOrderTotal();
        } else {
            JOptionPane.showMessageDialog((Component)null, "No item Selected..");
        }
    }

    @FXML
    void btnDiscountOnAction(ActionEvent event) {
        double discount=discountService.getDiscount(txtCustomerMobile.getText());
        double netTotal=Double.parseDouble(txtTotalPeice.getText())*discount;
        txtNetTotal.setText("Rs."+netTotal+"0");

    }

    @FXML
    void btnResetOrderOnAction(ActionEvent event) {
        this.tbtOrdersList.getItems().clear();
       txtDiscount.setText(null);
       txtTotalPeice.setText(null);
       txtCustomerMobile.setText(null);
       txtNetTotal.setText(null);
       txtItenCode.setText(null);
        setOrderID();
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
