package ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.model.Customer;
import ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.model.Order;
import ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository custRepo;

    public List<Customer> getAllCustomers() {
        return custRepo.getAllCustomers();
    }

    public List<Customer> getAllCustomersWithLimitOffset(Integer limit, Integer offset){
        return custRepo.getAllCustomersWithLimitOffset(limit, offset);
    }

    public Customer getCustomerById(int id){
        return custRepo.getCustomerById(id);
    }

    public List<Order> getOrderByCustomerId(Integer customer_id){
        return custRepo.getOrderByCustomerId(customer_id);
    }
}
