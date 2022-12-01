package paf.day24.models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PurchaseOrder {
    private String orderId;
    private String name;
    private Date orderDate;
    private List<Item> items = new LinkedList<>();


    public List<Item> getItem() { return items; }
    public void setItem(List<Item> items) { this.items = items; }
    public void addItem(Item item) { this.items.add(item);}

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getOrderDate() { return orderDate;}
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

}
