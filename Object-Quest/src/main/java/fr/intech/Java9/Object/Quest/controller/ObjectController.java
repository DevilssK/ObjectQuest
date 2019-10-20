package fr.intech.Java9.Object.Quest.controller;

import fr.intech.Java9.Object.Quest.model.database.Item;
import fr.intech.Java9.Object.Quest.model.database.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/item"})
public class ObjectController {

    @Autowired

    ItemRepository itemRepository;


    @GetMapping(value = "/getItems")
    public Iterable<Item> getQuests(){
        return itemRepository.findAll();
    }

}
