package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.model.dto.ItemOutOfStockDTO;
import ecom.mlslsenarathna.model.dto.SupplierDTO;
import ecom.mlslsenarathna.model.dto.ViewCustomerDTO;
import ecom.mlslsenarathna.model.entity.AddressEntity;
import ecom.mlslsenarathna.model.entity.CustomerEntity;
import ecom.mlslsenarathna.model.entity.ItemEntity;
import ecom.mlslsenarathna.repository.ItemRepository;
import ecom.mlslsenarathna.repository.impl.ItemRepositoryImpl;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Properties;


public class ItemService {
    ItemRepository itemRepository = new ItemRepositoryImpl();
    SupplierService supplierService=new SupplierService();

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
        for(ItemDTO itemDTO:itemDTOList){
            SupplierDTO supplierDTO=supplierService.searchBySupplierId(itemDTO.getSupplierId());
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
    public void sendEmailOutOfStockReminder(SupplierDTO supplierDTO,ItemDTO itemDTO){

        String from = "ruviquepos@gmail.com";
        String password = "owrz jlkw qqdf smdu";





        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String email="lakshansenarathna0229@gmail.com";
        // 4️⃣ Login to the mail post office
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
            message.setText("Dear "+supplierDTO.getSupplierName()+"\n" +
                    "\n" +
                    "This is a friendly reminder that the following item is currently out of stock:\n" +
                    "\n" +
                    "Item:"+ itemDTO.getItemName()+"\n" +
                    "Item ID:"+itemDTO.getItemId()+"\n" +
                    "\n" +
                    "Please arrange a new shipment at your earliest convenience.\n" +
                    "\n" +
                    "Thank you,\n" +
                    "Ruvique Master PVT.LTD\n" +
                    "Inventory Management System");

            Transport.send(message);

            System.out.println("🎉 Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
