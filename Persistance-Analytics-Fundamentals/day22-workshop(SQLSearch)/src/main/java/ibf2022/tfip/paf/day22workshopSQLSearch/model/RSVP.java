package ibf2022.tfip.paf.day22workshopSQLSearch.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RSVP {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Date confirmationDate;
    private String text;
}
