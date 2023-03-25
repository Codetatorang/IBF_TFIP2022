package ibf2022.tfip.ssf.day16workshopRedisJSON.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.tfip.ssf.day16workshopRedisJSON.model.Order;

@Repository
public class OrderRepo {
    @Autowired @Qualifier("my-redis")
    private RedisTemplate<String, String> redisTemplate;

    public void insertOrder(Order order){
    }
}
