package ibf2022.tfip.paf.day24workshopcustomerOrderDetails.services;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models.Order;
import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models.OrderResult;
import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Transactional(rollbackFor = Exception.class)
    public OrderResult createOrder(Order order){
        // String orderId = UUID.randomUUID().toString().substring(0, 8);
        // order.setId(orderId);

        //get current date
        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);
        //convert the date back as a sql date
        order.setOrderDate(sqlDate);

        orderRepo.insertOrder(order);

        //check order > 3 throw exception
        if (order.getOrderDetails().size() > 3) {
            throw new RuntimeException("Order details cannot be more than 3");
        }

        //insert records
        orderRepo.insertOrderDetails(order.getOrderDetails(), order.getId());
        OrderResult r = new OrderResult();
        return r;
    }
}
