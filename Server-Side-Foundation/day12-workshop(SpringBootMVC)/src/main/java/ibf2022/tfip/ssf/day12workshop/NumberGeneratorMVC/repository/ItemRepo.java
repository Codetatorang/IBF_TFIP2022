package ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.model.Item;

@Repository
public class ItemRepo {
    private List<Item> itemList;

    public List<Item> getCartItems(){
        itemList = new ArrayList<Item>();

        //populate the list
        Item item = new Item();
        item.setName("Hermes");
        item.setQuantity(16);
        itemList.add(item);
        
        item = new Item();
        item.setName("Prada");
        item.setQuantity(30);
        itemList.add(item);

        item = new Item();
        item.setName("Chanel");
        item.setQuantity(10);
        itemList.add(item);
        
        item = new Item();
        item.setName("Louis Vuitton");
        item.setQuantity(20);
        itemList.add(item);
       
        item = new Item();
        item.setName("Charles & Keith");
        item.setQuantity(40);
        itemList.add(item);

        
        return itemList;
    }
}
