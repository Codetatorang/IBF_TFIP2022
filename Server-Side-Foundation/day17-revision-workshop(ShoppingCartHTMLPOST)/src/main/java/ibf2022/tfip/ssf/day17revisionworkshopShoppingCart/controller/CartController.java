package ibf2022.tfip.ssf.day17revisionworkshopShoppingCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.tfip.ssf.day17revisionworkshopShoppingCart.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public String landingPage(){
        return "index";
    }


    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postCart(@RequestBody MultiValueMap<String, String> form, Model model){
        String item = form.getFirst("item");
        String name = form.getFirst("name");

        //get the item from the database
        List<String> cart = cartService.getFromCart(name);
        cart.add(item);

        //save back to the database
        cartService.addToCart(name, cart);

        model.addAttribute("name", name);
        model.addAttribute("item", item);

        return "index";
    }
}
