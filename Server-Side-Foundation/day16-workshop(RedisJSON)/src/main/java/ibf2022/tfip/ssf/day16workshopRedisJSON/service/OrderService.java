package ibf2022.tfip.ssf.day16workshopRedisJSON.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.ssf.day16workshopRedisJSON.model.Order;
import ibf2022.tfip.ssf.day16workshopRedisJSON.repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public String createNewOrder(Order order){
        //Generate the order id
        String orderId = UUID.randomUUID().toString().substring(0,8);
        order.setOrderId(orderId);

        //save the order id
        orderRepo.insertOrder(order);

        return orderId;
    }
}
