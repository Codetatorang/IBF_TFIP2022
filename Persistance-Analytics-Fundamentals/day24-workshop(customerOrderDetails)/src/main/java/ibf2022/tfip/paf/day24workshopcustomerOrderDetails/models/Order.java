package ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private Date orderDate;
    private String customerName;
    private String shipAddress;
    private String notes;
    private float tax;

    private List<OrderDetails> orderDetails;
}
