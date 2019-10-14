package fr.intech.Java9.Object.Quest;

import fr.intech.Java9.Object.Quest.model.database.Object;
import fr.intech.Java9.Object.Quest.model.database.ObjectRepository;
import fr.intech.Java9.Object.Quest.model.database.Quest;
import fr.intech.Java9.Object.Quest.model.database.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.management.QueryEval;
import java.util.Arrays;
import java.util.List;

@Component
public class Initiliazer {

    @Autowired
    private ObjectRepository objectRepository;

    @Autowired
    private QuestRepository questRepository;

    @PostConstruct
    public  void init(){

//        List<String> computerMouse = Arrays.asList("Electronic device", "Technology", "Mouse");
//        List<String> watch = Arrays.asList( "Watch accessory", "Watch");
//        List<String> cup = Arrays.asList("Cup", "Drinkware");
//        List<String> headset = Arrays.asList("Headphones", "Audio equipment", "Technology", "Electronic device", "Headset", "Ear");
//
//        Quest quest = new Quest("quest");
//        Quest techQuest = new Quest("Tech Piece");
//
//        questRepository.save(techQuest);
//
//
//        Object computerMouseObj  = new Object("Computer Mouse",  10, techQuest, computerMouse);
//        Object headsetObj = new Object("Headset", 10, techQuest, headset);
//        Object watchObj = new Object( "Watch", 10, techQuest, watch);
//        Object cupObj =  new Object( "DrinkWare", 10, techQuest, cup);
//
//        List<Object> objects = Arrays.asList(computerMouseObj, headsetObj, watchObj, cupObj);
//
//        objectRepository.saveAll(objects);
    }
}
