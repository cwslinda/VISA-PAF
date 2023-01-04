package vttp2022.paf.day23workshop.models;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Order {
    private Integer id;
    private DateTime orderDate;
    private Integer customerId;
    private Double totalDiscountedAmount;
    private Double costPrice;

    public Integer getId() { return id;}
    public void setId(Integer id) { this.id = id;}
    
    public DateTime getOrderDate() { return orderDate;}
    public void setOrderDate(DateTime orderDate) { this.orderDate = orderDate;}
   
    public Integer getCustomerId() { return customerId;}
    public void setCustomerId(Integer customerId) { this.customerId = customerId;}
   
    public Double getTotalDiscountedAmount() { return totalDiscountedAmount;}
    public void setTotalDiscountedAmount(Double totalDiscountedAmount) { this.totalDiscountedAmount = totalDiscountedAmount;}
   
    public Double getCostPrice() { return costPrice;}
    public void setCostPrice(Double costPrice) { this.costPrice = costPrice;}


    public static Order create(SqlRowSet rs){
        Order o = new Order();
        o.setId(rs.getInt("order_id"));
        o.setOrderDate(new DateTime(
            DateTimeFormat.forPattern("dd/MM/yyyy")
                    .parseDateTime(rs.getString("order_date"))));
        o.setCustomerId(rs.getInt("customer_id"));
        o.setTotalDiscountedAmount(rs.getDouble("discounted_price"));
        o.setCostPrice(rs.getDouble("cost_price"));

        return o;
    }

    public JsonObject toJSON(){
        return Json.createObjectBuilder()
                .add("order_id", getId())
                .add("order_date", getOrderDate() != null ? getOrderDate().toString() : "")
                .add("customer_id", getCustomerId().toString())
                .add("duscounted_price", getCostPrice().toString())
                .build();
    }


    
}
