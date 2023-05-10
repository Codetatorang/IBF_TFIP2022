package ibf2022.tfip.paf.day23workshopnorthwindSQLSearch.models;

import java.sql.Date;

public class Order {
    private Integer orderId;

    private Date orderDate;
    
    private Integer customerId;

    private Integer productId;

    private Float totalPrice;

    private Float costPrice;

    public Integer getOrderId() {return orderId;}
    public void setOrderId(Integer orderId) {this.orderId = orderId;}

    public Date getOrderDate() {return orderDate;}
    public void setOrderDate(Date orderDate) {this.orderDate = orderDate;}

    public Integer getCustomerId() {return customerId;}
    public void setCustomerId(Integer customerId) {this.customerId = customerId;}

    public Integer getProductId() {return productId;}
    public void setProductId(Integer productId) {this.productId = productId;}

    public Float getTotalPrice() {return totalPrice;}
    public void setTotalPrice(Float totalPrice) {this.totalPrice = totalPrice;}
    
    public Float getCostPrice() {return costPrice;}
    public void setCostPrice(Float costPrice) {this.costPrice = costPrice;}

    
}
