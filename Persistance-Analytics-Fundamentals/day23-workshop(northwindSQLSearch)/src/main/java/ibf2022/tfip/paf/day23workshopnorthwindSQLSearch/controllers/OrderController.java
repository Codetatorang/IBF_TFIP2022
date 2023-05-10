package ibf2022.tfip.paf.day23workshopnorthwindSQLSearch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.tfip.paf.day23workshopnorthwindSQLSearch.models.Order;
import ibf2022.tfip.paf.day23workshopnorthwindSQLSearch.payloads.SearchRequest;
import ibf2022.tfip.paf.day23workshopnorthwindSQLSearch.services.OrderRestTemplateService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderRestTemplateService orts;

    @GetMapping()
    public String searchOrder(Model model){
        SearchRequest sr = new SearchRequest();
        model.addAttribute("searchObject", sr);
        return "searchorder";
    }    

    @PostMapping("/search")
    public String processSearch(@ModelAttribute("searchObject") SearchRequest searchReq, Model model, BindingResult result){
        List<Order> orders = orts.findOrderById(searchReq.getOrderId());
        model.addAttribute("orders", orders);
        return "orderlist";
    }
}


