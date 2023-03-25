package ibf2022.tfip.ssf.day16workshopRedisBoardgame.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("boardgame")
public class Boardgame implements Serializable {
    @Id
    private Integer id;

    private Integer count;    
}