package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.ItemDTO;
import ecom.mlslsenarathna.model.entity.ItemEntity;
import ecom.mlslsenarathna.repository.ItemRepository;
import ecom.mlslsenarathna.repository.impl.ItemRepositoryImpl;

import java.util.Locale;

public class ItemService {
    ItemRepository itemRepository=new ItemRepositoryImpl();
    public String setNewItemId() {
        ItemEntity itemEntity=itemRepository.getLastItem();

        System.out.println(itemRepository.getLastItem());
        if(itemEntity.getItemId()!=null){
            String lastId= String.valueOf(itemRepository.getLastItem().getItemId());
            lastId = lastId.split("[A-Z]")[1]; // C001==> 001
            lastId= String.format("I%04d",(Integer.parseInt(lastId)+1));
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
       ItemEntity itemEntity= itemRepository.getItemByID(text);
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
}
