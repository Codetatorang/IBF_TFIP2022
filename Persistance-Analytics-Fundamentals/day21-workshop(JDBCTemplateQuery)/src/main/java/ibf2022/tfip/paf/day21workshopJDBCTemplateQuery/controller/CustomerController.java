package ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.model.Customer;
import ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.model.Order;
import ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService custSvc;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return custSvc.getAllCustomers();
    }

    @GetMapping(path = "/limit")
    public List<Customer> getAllCustomers(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
        return custSvc.getAllCustomersWithLimitOffset(limit, offset);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") int id){
        return custSvc.getCustomerById(id);
    }

    @GetMapping(path = "/{customer_id}/orders")
    public List<Order> getOrderbyCustomerId(@PathVariable("customer_id") int id){
        return custSvc.getOrderByCustomerId(id);
    }
}
