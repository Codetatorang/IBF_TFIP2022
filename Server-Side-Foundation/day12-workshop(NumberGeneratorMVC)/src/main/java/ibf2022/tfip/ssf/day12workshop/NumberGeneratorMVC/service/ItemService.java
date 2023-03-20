package ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.model.Item;
import ibf2022.tfip.ssf.day12workshop.NumberGeneratorMVC.repository.ItemRepo;

@Service
public class ItemService {
    @Autowired
    ItemRepo itemRepo;

    public List<Item> retrieveItemsList() {
        return itemRepo.getCartItems();
    }
}
