package vttp2022.paf.day21workshop.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.day21workshop.models.Customer;
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
}
