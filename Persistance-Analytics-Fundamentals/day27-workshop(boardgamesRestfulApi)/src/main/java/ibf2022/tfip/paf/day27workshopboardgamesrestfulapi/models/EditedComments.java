package ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EditedComments {
    private String comment;
    private int rating;
}
