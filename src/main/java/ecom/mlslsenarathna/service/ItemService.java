package ecom.mlslsenarathna.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.model.dto.ItemOutOfStockDTO;
import ecom.mlslsenarathna.model.dto.SupplierDTO;
import javafx.embed.swing.SwingFXUtils;
import ecom.mlslsenarathna.model.entity.ItemEntity;
import ecom.mlslsenarathna.repository.ItemRepository;
import ecom.mlslsenarathna.repository.impl.ItemRepositoryImpl;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.print.PrinterJob;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Properties;


public class ItemService {
    ItemRepository itemRepository = new ItemRepositoryImpl();
    SupplierService supplierService = new SupplierService();

    public String setNewItemId() {
        ItemEntity itemEntity = itemRepository.getLastItem();

        System.out.println(itemRepository.getLastItem());
        if (itemEntity.getItemId() != null) {
            String lastId = String.valueOf(itemRepository.getLastItem().getItemId());
            lastId = lastId.split("[A-Z]")[1]; // C001==> 001
            lastId = String.format("I%04d", (Integer.parseInt(lastId) + 1));
            return lastId;

        }
        return "I0001";


    }

    public void registerItem(ItemDTO itemDTO) {
        itemRepository.registerNewItem(new ItemEntity(
                itemDTO.getItemId(),
                itemDTO.getItemName(),
                itemDTO.getSupplierId(),
                itemDTO.getDescription(),
                itemDTO.getColor(),
                itemDTO.getSize(),
                itemDTO.getStockCount(),
                itemDTO.getManufactureCountry(),
                itemDTO.getSupplierPrice(),
                itemDTO.getSellingPrice()
        ));
    }

    public ItemDTO searchItemByID(String text) {
        ItemEntity itemEntity = itemRepository.getItemByID(text);
        return new ItemDTO(
                itemEntity.getItemId(),
                itemEntity.getItemName(),
                itemEntity.getSupplierId(),
                itemEntity.getDescription(),
                itemEntity.getColor(),
                itemEntity.getSize(),
                itemEntity.getStockCount(),
                itemEntity.getManufactureCountry(),
                itemEntity.getSupplierPrice(),
                itemEntity.getSellingPrice()
        );
    }

    public void updateItemById(ItemDTO itemDTO) {
        itemRepository.updateItemById(
                new ItemEntity(
                        itemDTO.getItemId(),
                        itemDTO.getItemName(),
                        itemDTO.getSupplierId(),
                        itemDTO.getDescription(),
                        itemDTO.getColor(),
                        itemDTO.getSize(),
                        itemDTO.getStockCount(),
                        itemDTO.getManufactureCountry(),
                        itemDTO.getSupplierPrice(),
                        itemDTO.getSellingPrice()
                ));
    }

    public boolean isItemId(String input) {
        if (input.matches("^I\\d{4}$")) {
            return true;

        } else if (input.matches("^i\\d{4}$")) {
            return true;
        } else {
            return false;
        }

    }


    public void deleteItemById(ItemDTO itemDTO) {
        itemRepository.deleteById(new ItemEntity(
                itemDTO.getItemId(),
                itemDTO.getItemName(),
                itemDTO.getSupplierId(),
                itemDTO.getDescription(),
                itemDTO.getColor(),
                itemDTO.getSize(),
                itemDTO.getStockCount(),
                itemDTO.getManufactureCountry(),
                itemDTO.getSupplierPrice(),
                itemDTO.getSellingPrice()
        ));
    }

    public List<ItemDTO> getItemList() {
        List<ItemEntity> itemEntityList = itemRepository.getItemsList();
        ObservableList<ItemDTO> items = FXCollections.observableArrayList();
        for (ItemEntity itemEntity : itemEntityList) {
            items.add(new ItemDTO(
                    itemEntity.getItemId(),
                    itemEntity.getItemName(),
                    itemEntity.getSupplierId(),
                    itemEntity.getDescription(),
                    itemEntity.getColor(),
                    itemEntity.getSize(),
                    itemEntity.getStockCount(),
                    itemEntity.getManufactureCountry(),
                    itemEntity.getSupplierPrice(),
                    itemEntity.getSellingPrice()
            ));

        }
        return items;
    }

    public List<ItemDTO> getOutOfStockDTOItems() {
        List<ItemEntity> itemEntityList = itemRepository.getItemsList();
        ObservableList<ItemDTO> items = FXCollections.observableArrayList();
        ObservableList<ItemOutOfStockDTO> itemOutOfStockLists = FXCollections.observableArrayList();
        for (ItemEntity itemEntity : itemEntityList) {
            if (itemEntity.getStockCount() == 0) {
                items.add(new ItemDTO(
                        itemEntity.getItemId(),
                        itemEntity.getItemName(),
                        itemEntity.getSupplierId(),
                        itemEntity.getDescription(),
                        itemEntity.getColor(),
                        itemEntity.getSize(),
                        itemEntity.getStockCount(),
                        itemEntity.getManufactureCountry(),
                        itemEntity.getSupplierPrice(),
                        itemEntity.getSellingPrice()

                ));
            }
        }
        return items;
    }

    public List<ItemOutOfStockDTO> getOutOfStockItems() {
        List<ItemDTO> itemDTOList = getOutOfStockDTOItems();
        ObservableList<ItemOutOfStockDTO> outOfStockItems = FXCollections.observableArrayList();
        for (ItemDTO itemDTO : itemDTOList) {
            SupplierDTO supplierDTO = supplierService.searchBySupplierId(itemDTO.getSupplierId());
            outOfStockItems.add(new ItemOutOfStockDTO(
                    itemDTO.getItemId(),
                    itemDTO.getItemName(),
                    supplierDTO.getSupplierName(),
                    supplierDTO.getSupplierContactNo(),
                    supplierDTO.getSupplierEmail(),
                    itemDTO.getStockCount()

            ));

        }

        return outOfStockItems;
    }

    public void sendEmailOutOfStockReminder(SupplierDTO supplierDTO, ItemDTO itemDTO) {

        String from = "ruviquepos@gmail.com";
        String password = "owrz jlkw qqdf smdu";


        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String email = "lakshansenarathna0229@gmail.com";

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(supplierDTO.getSupplierEmail()));
            message.setSubject("Ruvique Master Stores PVT.LTD");
            message.setText("Dear " + supplierDTO.getSupplierName() + "\n" +
                    "\n" +
                    "This is a friendly reminder that the following item is currently out of stock:\n" +
                    "\n" +
                    "Item:" + itemDTO.getItemName() + "\n" +
                    "Item ID:" + itemDTO.getItemId() + "\n" +
                    "\n" +
                    "Please arrange a new shipment at your earliest convenience.\n" +
                    "\n" +
                    "Thank you,\n" +
                    "Ruvique Master PVT.LTD\n" +
                    "Inventory Management System");

            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<ItemDTO> getInStockItemsList() {
        List<ItemDTO> itemList = getItemList();
        ObservableList<ItemDTO> itemsInStock = FXCollections.observableArrayList();
        for (ItemDTO itemDTO : itemList) {
            if (itemDTO.getStockCount() > 0) {
                itemsInStock.add(itemDTO);
            }

        }
        return itemsInStock;

    }

    public String checkAvailability(ItemDTO itemDTO) {
        if (itemDTO.getStockCount() > 0) {
            return "Available";
        } else {
            return "Unvailable";
        }
    }

    public boolean isAvailabile(ItemDTO itemDTO) {
        if (itemDTO.getStockCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public Image generatNewBarcode(ItemDTO itemDTO) {
        try {

            String barcodeText = itemDTO.getItemId();
            Code128Writer barcodeWriter = new Code128Writer();
            BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.CODE_128, 300, 100);
            BufferedImage barcodeImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            // 2️⃣ Create a new image to include text + barcode
            int width = 350;
            int height = 180;
            BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = combined.createGraphics();

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);

            g.drawImage(barcodeImage, 25, 50, null);


            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("Item: " + itemDTO.getItemName(), 25, 20);
            g.drawString("Price: $" + itemDTO.getSellingPrice(), 25, 40);

            g.dispose();


            return SwingFXUtils.toFXImage(combined, null);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean printBarCode(Stage stage, Image fxImage) {
        ImageView imgView = new ImageView(fxImage);
        imgView.setFitWidth(300);
        imgView.setFitHeight(150);

        PrinterJob job = PrinterJob.createPrinterJob();

        if (job != null && job.showPrintDialog(stage)) {
            boolean success = job.printPage(imgView);

            if (success) {
                job.endJob();
                System.out.println("Printed successfully!");
            } else {
                System.out.println("Printing failed!");
            }
            return success;
        } else {
            System.out.println("Printer job cancelled or not available.");
            return false;
        }
    }
}
