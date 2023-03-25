package ibf2022.tfip.ssf.day16workshopRedisBoardgame.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import ibf2022.tfip.ssf.day16workshopRedisBoardgame.model.Boardgame;

@Repository
public class BoardgameRepo {

    @Autowired @Qualifier("redisTemplateConfiguration")
    private RedisTemplate<Integer, Boardgame> redisTemplate;

    public Boardgame save(Boardgame boardgame) {
        ValueOperations<Integer, Boardgame> vo = redisTemplate.opsForValue();
        vo.set(boardgame.getId(), boardgame);

        return boardgame;
    }

    public Boardgame findBoardgameById(Integer id) {
        Boardgame bg = (Boardgame) redisTemplate.opsForValue().get(id);
        return bg;
    }

    public Boardgame update(Boardgame boardgame) {
        redisTemplate.opsForValue().setIfPresent(boardgame.getId(), boardgame);

        return boardgame;
    }
}