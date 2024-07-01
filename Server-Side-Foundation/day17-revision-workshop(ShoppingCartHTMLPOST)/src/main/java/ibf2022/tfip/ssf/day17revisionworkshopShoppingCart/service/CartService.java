package ibf2022.tfip.ssf.day17revisionworkshopShoppingCart.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.ssf.day17revisionworkshopShoppingCart.repositiory.CartRepository;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public void addToCart(String name, List<String> cart){
        //convert string to csv
        String items = cart.stream().collect(Collectors.joining(","));

        System.out.printf("Service %s, %s\n", name, items);
        //add to cart
        cartRepository.addToCart(name, items);
    }

    public List<String> getFromCart(String name) {
        Optional<String> opt = cartRepository.getFromCart(name);

        List<String> cart = new LinkedList<>();

        //if box is empty, return an empty list
        if(opt.isEmpty())
            return cart;
        
        //get the value from the box
        String value = opt.get();
        String[] items = value.split(",");

        cart.addAll(Arrays.asList(items));

        return cart;
        
    }
}
