package paf.day24.repositories;

public class Queries {

    public static String SQL_INSERT_ORDER = 
        "INSERT INTO PURCHASE_ORDER(order_id, name, order_date) VALUES (?,?,?)";
    
    public static String SQL_INSERT_ITEM =
        "INSERT INTO ORDER_ITEM(description, quantity, order_id) VALUES (?,?,?)";
    
}
