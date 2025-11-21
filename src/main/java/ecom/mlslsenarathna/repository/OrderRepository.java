package ecom.mlslsenarathna.repository;

import ecom.mlslsenarathna.model.entity.OrderEntity;

public interface OrderRepository {
    OrderEntity getlastOrder();

    void placeNewOrder(OrderEntity orderEntity);
}
