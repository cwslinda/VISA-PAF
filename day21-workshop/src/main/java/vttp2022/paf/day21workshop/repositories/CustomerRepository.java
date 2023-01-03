package vttp2022.paf.day21workshop.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;


import vttp2022.paf.day21workshop.models.Customer;
import vttp2022.paf.day21workshop.models.Order;

import static vttp2022.paf.day21workshop.repositories.Queries.*;


@Repository
public class CustomerRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Customer> getAllCustomer(Integer offset, Integer limit){

        final List<Customer> customers = new LinkedList<>();

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_ALL_CUSTOMERS, offset, limit);

        while(rs.next()){
            customers.add(Customer.create(rs));
        }

        return customers;

    }

    public Customer getCustomerById(String id){

        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_CUSTOMER_BY_ID, id);

        Customer c = new Customer();
        if(!rs.next()){
            return null;
        } else {
            c = Customer.create(rs);
        }

        return c;
    }

    public List<Order> getCustomerOrdersById(String id){
         
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_CUSTOMER_ORDERS_BY_ID, id);

        final List<Order> orders = new LinkedList<>();

        while(rs.next()){
            Order o = Order.create(rs);
            orders.add(o);
        }

        return orders;

    }
}
