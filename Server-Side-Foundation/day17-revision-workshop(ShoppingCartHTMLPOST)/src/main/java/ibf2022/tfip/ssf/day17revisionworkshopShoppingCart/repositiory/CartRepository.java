package ibf2022.tfip.ssf.day17revisionworkshopShoppingCart.repositiory;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {
    @Autowired @Qualifier("my-redis")
    private RedisTemplate<String, String> redisTemplate;

    public void addToCart(String name, String cart){
        System.out.printf("added to cart: %s, %s \n", name, cart);
        redisTemplate.opsForValue().set(name, cart);;
    }

    public Optional<String> getFromCart(String name) {
        String value = redisTemplate.opsForValue().get(name);
        System.out.printf("get from cart: %s \n", name);
        //if the value is empty, return an empty box
        if(null == value)
            return Optional.empty();
        
        //fill the box and return the value
        return Optional.of(value);
        
    }
}
