package ibf2022.tfip.ssf.day16workshopRedisBoardgame.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.tfip.ssf.day16workshopRedisBoardgame.model.Payload;

@Repository
public class PayloadRepo {
    public static final String HASH_KEY_NAME = "Payload_Item";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public Payload save(Payload payload) {
        redisTemplate.opsForHash().put(HASH_KEY_NAME, payload.getId(), payload);
        return payload;
    }

    // @SuppressWarnings("unchecked")
    public List<Payload> findAll() {
        // return redisTemplate.opsForHash().values(HASH_KEY_NAME);
        List<Payload> payloadList = redisTemplate
                .opsForHash()
                .values(HASH_KEY_NAME)
                .stream()
                .map(Payload.class::cast)
                .collect(Collectors.toList());

        return payloadList;
    }

    public Payload findPayloadById(Integer id) {
        return (Payload) redisTemplate.opsForHash().get(HASH_KEY_NAME, id);

    }

    public String deletePayloadById(Integer id) {
        Long lResult = redisTemplate.opsForHash().delete(HASH_KEY_NAME, id);

        if (lResult >= 0)
            return "Deleted";
        else
            return "Not Deleted";

    }
}
