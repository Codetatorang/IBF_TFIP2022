package ibf2022.tfip.ssf.day16workshopRedisJSON.model;


import jakarta.json.Json;
import jakarta.json.JsonObject;

public class OrderResponse {
    private String orderId;
    private String message;

    public String getOrderId() {return orderId;}
    public void setOrderId(String orderId) {this.orderId = orderId;}

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}

    public JsonObject toJson(){
        return Json.createObjectBuilder()
                .add("orderId", orderId)
                .add("message", message)
                .build();
    }
}
