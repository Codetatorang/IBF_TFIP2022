package ibf2022.tfip.paf.day23workshopnorthwindSQLSearch.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.paf.day23workshopnorthwindSQLSearch.models.Order;
import ibf2022.tfip.paf.day23workshopnorthwindSQLSearch.repositiories.OrderRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderApiController {
    @Autowired
    OrderRepository orderRepo;

    @GetMapping("/{order-id}")
    public ResponseEntity<List<Order>> findOrderById(@PathVariable("order-id") Integer id){
        List<Order> orders = orderRepo.findOrderById(id);
        
        if(orders.size() > 0)
            return new ResponseEntity<>(orders, HttpStatus.OK);
        else
            return new ResponseEntity<>(orders, HttpStatus.NO_CONTENT);
    }
}
