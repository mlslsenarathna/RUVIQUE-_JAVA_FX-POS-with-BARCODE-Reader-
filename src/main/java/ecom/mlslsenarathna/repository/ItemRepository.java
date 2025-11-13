package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.ItemEntity;

import java.util.List;

public interface ItemRepository {
    ItemEntity getLastItem();

    void registerNewItem(ItemEntity itemEntity);

    ItemEntity getItemByID(String text);

    void updateItemById(ItemEntity itemEntity);

    void deleteById(ItemEntity itemEntity);

    List<ItemEntity> getItemsList();
}
