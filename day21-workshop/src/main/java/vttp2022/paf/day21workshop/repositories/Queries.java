package vttp2022.paf.day21workshop.repositories;

public class Queries {
    
    public static final String SQL_SELECT_ALL_CUSTOMERS = 
        "select id, company, last_name, first_name, email_address, job_title, business_phone, home_phone, mobile_phone, address, state_province from customers limit ?, ?";

    public static final String SQL_SELECT_CUSTOMER_BY_ID =  
        "select * from customers where id = ? ";

    public static final String SQL_SELECT_CUSTOMER_ORDERS_BY_ID = 
        "select * from orders join customers on orders.customer_id = customers.id where customers.id = ? ";
}
