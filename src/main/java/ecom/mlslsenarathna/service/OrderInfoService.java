package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.OrderInfoDTO;
import ecom.mlslsenarathna.model.entity.OrderInfoEntity;
import ecom.mlslsenarathna.repository.OrderInfoRepository;
import ecom.mlslsenarathna.repository.impl.OrderInfoRepositoryImpl;

public class OrderInfoService {

    OrderInfoRepository orderInfoRepository=new OrderInfoRepositoryImpl();

    public void registerOrderInfo(OrderInfoDTO orderInfoDTO){
        orderInfoRepository.insertOrderInfo(new OrderInfoEntity(
                orderInfoDTO.getOrderId(),
                orderInfoDTO.getItemId(),
                orderInfoDTO.getQuantity(),
                orderInfoDTO.getSellingPrice()
        ));

    }
}
