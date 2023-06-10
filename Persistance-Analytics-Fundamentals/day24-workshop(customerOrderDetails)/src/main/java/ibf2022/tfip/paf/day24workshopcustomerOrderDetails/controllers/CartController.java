package ibf2022.tfip.paf.day24workshopcustomerOrderDetails.controllers;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models.Order;
import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models.OrderDetails;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
    
    Logger logger = org.slf4j.LoggerFactory.getLogger(CartController.class);

    @PostMapping
    public String postCart(@RequestBody MultiValueMap<String, String> form, Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<OrderDetails> orderDetails = (List<OrderDetails>)session.getAttribute(("cart"));//get from session
        if(null == orderDetails) {
            orderDetails = new LinkedList<>();
            session.setAttribute("cart", orderDetails);
        }

        String item = form.getFirst("item");
        Integer quantity = Integer.parseInt(form.getFirst("quantity"));
        orderDetails.add(new OrderDetails(item, quantity));

        logger.info("Order Details: {}", orderDetails);

        Order order = new Order();
        order.setCustomerName(form.getFirst("name"));
        order.setNotes(form.getFirst("notes"));
        order.setOrderDetails(orderDetails);

        session.setAttribute("checkoutCart", order);
        model.addAttribute("orderDetails", orderDetails);
        return "cart";

    }
}
