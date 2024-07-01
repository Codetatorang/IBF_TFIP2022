package ibf2022.tfip.ssf.day17revisionworkshopShoppingCart.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/session/cart")
public class CartSessionController {

    //logger for debugging
    // Logger logger = LoggerFactory.getLogger(CartSessionController.class);

    @PostMapping(path = "/checkout", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String checkout(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession session) {
        // String name = form.getFirst("name");
        String item = form.getFirst("item");

        @SuppressWarnings("unchecked")
        List<String> cart = (List<String>) session.getAttribute("cart");
        cart.add(item);

        for (String i : cart) {
            System.out.printf("item: %s\n", i);
        }

        // destroy the session, the next request will get a new session
        System.out.println("invalidating session");
        session.invalidate();

        return "redirect:/";
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postMapping(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession session) {

        String name = form.getFirst("name");
        String item = form.getFirst("item");

        @SuppressWarnings("unchecked")
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (null == cart) {
            
            cart = new LinkedList<>();
            session.setAttribute("cart", cart);
            session.setAttribute("name", name);
        }
        cart.add(item);
        
        model.addAttribute("cart", cart);
        model.addAttribute("item", item);
        
        return "index";
    }
}
