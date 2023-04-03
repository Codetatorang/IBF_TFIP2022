package ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private Integer customerId;
    private LocalDateTime orderDate;
    private LocalDateTime shippedDate;
    private String shipName;
}


