package ibf2022.tfip.paf.day24workshopcustomerOrderDetails.repositories;

import static ibf2022.tfip.paf.day24workshopcustomerOrderDetails.repositories.Queries.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models.Order;
import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models.OrderDetails;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public boolean insertOrder(Order order){
        return jdbcTemplate.update(INSERT_ORDER,
                order.getOrderDate(), 
                order.getCustomerName(),
                order.getShipAddress(),
                order.getNotes() ) > 0;
    }

    public void insertOrderDetails(List<OrderDetails> orderDetails, int i){
        List<Object[]> data = orderDetails.stream().map(li->{
            Object[] obj = new Object[5];
            obj[0] = i;
            obj[1] = li.getProduct();
            obj[2] = li.getUnitPrice();
            obj[3] = li.getDiscount();
            obj[4] = li.getQuantity();
            return obj;
        }).toList();

        jdbcTemplate.batchUpdate(INSERT_ORDER_DETAILS, data);
    }
}
