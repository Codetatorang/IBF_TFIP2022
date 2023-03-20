package ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.model.Item;
import ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.service.ItemService;

@Controller
@RequestMapping("/shoppingcart")
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping(produces = "text/html")   
    public String displayCart(Model model){
        List<Item> itemList = itemService.retrieveItemsList();
        model.addAttribute("cartItems", itemList);
        return "cart";
    }

    @GetMapping("{itemname}")
    public String filteredCart(@PathVariable("itemname") String itemName,Model model){
        List<Item> itemList = itemService.retrieveItemsList();
        List<Item> foundItem = itemList.stream().filter(item->item.getName().equalsIgnoreCase(itemName)).collect(Collectors.toList());
        model.addAttribute("cartItems", foundItem);
        return "cart";
    }
}
