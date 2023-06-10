package ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private int id;
    private String product;
    private float unitPrice;
    private float discount;
    private int quantity;

    public OrderDetails(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
