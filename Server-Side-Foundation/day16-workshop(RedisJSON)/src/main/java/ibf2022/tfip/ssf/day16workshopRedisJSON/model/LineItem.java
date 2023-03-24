package ibf2022.tfip.ssf.day16workshopRedisJSON.model;

import jakarta.json.JsonObject;

public class LineItem {
    private String itemName;
    private int quantity;
    
    public String getItemName() { return itemName;}
    public void setItemName(String itemName) { this.itemName = itemName;}

    public int getQuantity() { return quantity;}
    public void setQuantity(int quantity) { this.quantity = quantity;}

    public static LineItem create(JsonObject jsonObj) {
        LineItem lineItem = new LineItem();
        lineItem.setItemName(jsonObj.getString("itemName"));
        lineItem.setQuantity(jsonObj.getInt("quantity"));
        return lineItem;
    }

    
}
