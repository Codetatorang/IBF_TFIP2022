package ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
}
