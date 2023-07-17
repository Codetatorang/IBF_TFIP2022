package ibf2022.tfip.paf.day26workshopboardgamesMongoDB.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GameDetails {
    private float gid;
    private String name;
    private float year;
    private float ranking;
    private float average;
    private float users_rated;
    private String url;
    private String thumbnail;
    private String timestamp;
}
