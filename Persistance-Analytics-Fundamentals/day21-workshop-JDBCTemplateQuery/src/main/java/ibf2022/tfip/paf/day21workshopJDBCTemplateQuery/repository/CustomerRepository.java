package ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.model.Customer;
import ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.model.Order;

@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String findallSQL = "select id, first_name, last_name, company, address from customers";

    private final String findAllSQLLimitOffset = "select * from customers limit ? offset ?;";

    private final String findById = "select * from customers where id = ?";

    private final String findOrderByCustomerSQL = "select id, customer_id, order_date, shipped_date, ship_name from orders where customer_id = ?";

    public List<Customer> getAllCustomers() {
        final List<Customer> customersList = new ArrayList<Customer>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findallSQL);

        while (rs.next()) {
            Customer cust = new Customer();
            cust.setId(rs.getInt("id"));
            cust.setCompany(rs.getString("company"));
            cust.setFirstName(rs.getString("first_name"));
            cust.setLastName(rs.getString("last_name"));
            cust.setAddress(rs.getString("address"));
            customersList.add(cust);

        }
        return Collections.unmodifiableList(customersList);
    }

    public List<Customer> getAllCustomersWithLimitOffset(Integer limit, Integer offset) {
        final List<Customer> customersList = new ArrayList<Customer>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllSQLLimitOffset, limit, offset);

        while (rs.next()) {
            Customer cust = new Customer();
            cust.setId(rs.getInt("id"));
            cust.setCompany(rs.getString("company"));
            cust.setFirstName(rs.getString("first_name"));
            cust.setLastName(rs.getString("last_name"));
            cust.setAddress(rs.getString("address"));
            customersList.add(cust);

        }
        return Collections.unmodifiableList(customersList);
    }

    public Customer getCustomerById(int id){
        return jdbcTemplate.queryForObject(findById, BeanPropertyRowMapper.newInstance(Customer.class), id);
    }

    public List<Order> getOrderByCustomerId(Integer customer_id){
        final List<Order> orderList = new ArrayList<Order>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findOrderByCustomerSQL, customer_id);

        while(rs.next()) {
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setCustomerId(rs.getInt("customer_id"));
            order.setOrderDate((LocalDateTime) rs.getObject("order_date"));
            order.setShippedDate((LocalDateTime) rs.getObject("shipped_date"));
            order.setShipName(rs.getString("ship_name"));
            orderList.add(order);
        }

        return Collections.unmodifiableList(orderList);
    }

}
