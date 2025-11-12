package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.ItemEntity;

public interface ItemRepository {
    ItemEntity getLastItem();

    void registerNewItem(ItemEntity itemEntity);

    ItemEntity getItemByID(String text);

    void updateItemById(ItemEntity itemEntity);
}
