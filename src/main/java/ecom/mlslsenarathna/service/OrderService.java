package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.OrderDTO;
import ecom.mlslsenarathna.model.entity.OrderEntity;
import ecom.mlslsenarathna.repository.OrderRepository;
import ecom.mlslsenarathna.repository.impl.OrderRepositoryImpl;


public class OrderService {
    OrderRepository orderRepository=new OrderRepositoryImpl();

    public String setOrderId() {
        OrderEntity orderEntity = orderRepository.getlastOrder();
        return generateNextOrderId(new OrderDTO(
                orderEntity.getOrderId(),
                orderEntity.getOrderDateandTime(),
                orderEntity.getCustomerMobile(),
                orderEntity.getTotalPrice()
        ));


    }

    private String generateNextOrderId(OrderDTO orderDTO) {
        if(orderDTO!=null){
            Long lastId=orderDTO.getOrderId();
            return String.valueOf(lastId+1);
        }
        return null;
    }
    public void placeNewOrder(OrderDTO orderDTO){
        orderRepository.placeNewOrder(new OrderEntity(
                orderDTO.getOrderId(),
                orderDTO.getOrderDateandTime(),
                orderDTO.getCustomerMobile(),
                orderDTO.getTotalPrice()
        ));
    }
}
