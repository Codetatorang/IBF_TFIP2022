package ibf2022.tfip.paf.day24workshopcustomerOrderDetails.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models.Order;
import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models.OrderDetails;
import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.models.OrderResult;
import ibf2022.tfip.paf.day24workshopcustomerOrderDetails.services.OrderService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private OrderService orderSvc;

    @PostMapping
    public String confirmCheckout(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<OrderDetails> orderDetails = (List<OrderDetails>)session.getAttribute(("cart"));
        Order order = (Order)session.getAttribute(("checkoutCart"));
        @SuppressWarnings("unused")
        OrderResult r = orderSvc.createOrder(order);
        session.invalidate();
        model.addAttribute("total", orderDetails.size());
        return "checkout";
    }
}
