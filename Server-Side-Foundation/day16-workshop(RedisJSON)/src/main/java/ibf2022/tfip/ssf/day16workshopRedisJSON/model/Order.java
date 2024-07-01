package ibf2022.tfip.ssf.day16workshopRedisJSON.model;

import java.util.LinkedList;
import java.util.List;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

public class Order {
    private String orderId;
    private String name;
    private String email;
    private String deliveryDate;
    private List<LineItem> lineItems = new LinkedList<>();

    public String getOrderId() { return orderId;}
    public void setOrderId(String orderId) { this.orderId = orderId;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}

    public String getDeliveryDate() { return deliveryDate;}
    public void setDeliveryDate(String deliveryDate) { this.deliveryDate = deliveryDate;}

    public List<LineItem> getOrderItems() { return lineItems;}
    public void setlineItems(List<LineItem> lineItems) { this.lineItems = lineItems;}
    public void addlineItem(LineItem li) { this.lineItems.add(li);}

    public static Order create(JsonObject jsonObj){
        Order order = new Order();
        if(jsonObj.containsKey("orderId"))
            order.setOrderId(jsonObj.getString("orderId"));

        order.setName(jsonObj.getString("name"));
        order.setEmail(jsonObj.getString("email"));
        order.setDeliveryDate(jsonObj.getString("deliveryDate"));

        JsonArray JsonArr = jsonObj.getJsonArray("lineItems");
        for(int i = 0; i < JsonArr.size(); i++){
            JsonObject jo = JsonArr.getJsonObject(i);
            LineItem li = LineItem.create(jo);
            order.addlineItem(li);
        }
        return order;
    }
    
}
