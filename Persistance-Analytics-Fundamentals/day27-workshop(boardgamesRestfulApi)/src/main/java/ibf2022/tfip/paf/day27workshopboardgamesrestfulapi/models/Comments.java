package ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.models;

import java.util.Date;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Comments {
    private String user;
    private int rating;
    private String comment;
    private int gid;
    private Date posted;
    private String name;
    private String[] edited;
}
