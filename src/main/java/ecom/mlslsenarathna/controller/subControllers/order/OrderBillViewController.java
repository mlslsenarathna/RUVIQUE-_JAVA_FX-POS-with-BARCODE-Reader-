package ecom.mlslsenarathna.controller.subControllers.order;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.TextArea;

public class OrderBillViewController {

    @FXML
    private JFXButton btnBack;

    @FXML
    private JFXButton btnPrint;

    @FXML
    private TextArea txtOrderBillArea;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }
    public void setBillContent(String content) {
        txtOrderBillArea.setText(content);
    }

    @FXML
    void btnPrintonAction(ActionEvent event) {
        Printer printer = Printer.getDefaultPrinter();
        if (printer != null) {
            PrinterJob job = PrinterJob.createPrinterJob(printer);
            if (job != null && job.showPrintDialog(txtOrderBillArea.getScene().getWindow())) {

                // Print the content of the TextArea
                boolean printed = job.printPage(txtOrderBillArea);

                if (printed) {
                    job.endJob();
                }
            }
        } else {
            System.err.println("No default printer found.");
        }
    }
    }


