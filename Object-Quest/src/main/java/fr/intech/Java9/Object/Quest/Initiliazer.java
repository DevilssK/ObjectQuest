package fr.intech.Java9.Object.Quest;

import fr.intech.Java9.Object.Quest.model.database.Item;
import fr.intech.Java9.Object.Quest.model.database.ItemRepository;
import fr.intech.Java9.Object.Quest.model.database.Quest;
import fr.intech.Java9.Object.Quest.model.database.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class Initiliazer {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private QuestRepository questRepository;

    @PostConstruct
    public  void init(){

        //Tech
        List<String> headset = Arrays.asList("Headphones", "Audio equipment", "Technology", "Electronic device", "Headset", "Ear");
        List<String> computerMouse = Arrays.asList("Electronic device", "Technology", "Mouse");
        List<String> computer = Arrays.asList("Laptop", "Electronic device", "Technology", "Personal computer", "Computer", "Computer hardware", "Laptop");
        List<String> phone = Arrays.asList("Electronic device", "Electronics", "Technology", "Electronics accessory", "Communication Device", "Mobile phone", "Smartphone", "Portable communications device");
        //Accessoires
        List<String> watch = Arrays.asList( "Watch accessory", "Watch");
        List<String> glasses = Arrays.asList("Eyewear", "Glasses", "Sunglasses");
        //Office
        List<String> pen = Arrays.asList("Pen", "Office supplies", "Material property", "Writing implement", "Writing instrument accessory", "Fountain pen");
        List<String> printer = Arrays.asList("Printer", "Electronic device", "Technology", "Inkjet printing", "Laser printing", "Office equipment", "Office supplies", "Photocopier");
        //In'Tech
        List<String> dist = Arrays.asList("Machine","Vending machine");
        List<String> trash = Arrays.asList("Waste container", "Waste containment", "Recycling bin");
        List<String> babyFoot = Arrays.asList("Indoor games and sports", "Table", "Games", "Sport venue", "Furniture", "Play", "Room", "Recreation", "Leisure", "Recreation room","Table", "Furniture", "Indoor games and sports", "Games", "Room", "Recreation room", "Recreation");
        List<String> ext = Arrays.asList("Fire extinguisher", "Gas");
        //Animals
        List<String> dog = Arrays.asList("Dog", "Dog breed", "Canidae","Carnivore");
        List<String> horse = Arrays.asList("Horse", "Stable", "Stall", "Stallion", "Mustang horse");
        List<String>  cat = Arrays.asList("Cat", "Felidae", "Carnivore");
        //Furniture
        List<String> couch = Arrays.asList("Furniture","Couch");
        List<String>  chair= Arrays.asList("Chair", "Furniture");
        //Kitchen
        List<String> knife = Arrays.asList("Knife", "Cold weapon", "Kitchen knife", "Blade", "Cutlery", "Table knife");
        List<String> fork = Arrays.asList("Tool","Kitchen utensil", "Tableware");
        List<String> microwave = Arrays.asList("Electronics","Product", "Microwave oven", "Technology", "Flooring", "Electronic device", "Room", "Material property", "Home appliance", "Electronics, Technology, Electronic device, Room, Home appliance","[Microwave oven, Electronics, Home appliance, Technology, Floor, Room, Electronic device, Kitchen appliance, Flooring, Small appliance");
        List<String> cup = Arrays.asList("Cup", "Drinkware", "Glass");

        //Tech
        Item computerMouseObj  = new Item("Computer Mouse",  10, computerMouse);
        Item headsetObj = new Item("Headset", 10, headset);
        Item computerObj = new Item("Computer", 10, computer);
        Item phoneObj = new Item("Phone", 10, phone);
        List<Item> techObjs = Arrays.asList(computerMouseObj, headsetObj, computerObj, phoneObj);

        //Accessoires
        Item watchObj = new Item( "Watch", 10,  watch);
        Item glassesObj = new Item("Glasses", 10, glasses);
        List<Item> accessoriesObj = Arrays.asList(watchObj, glassesObj);

        //In'Tech
        Item babyFootObj = new Item("babyFoot", 10, babyFoot);
        Item distObj = new Item("Vending Machine", 10, dist);
        Item trashcan = new Item("TrashCan", 10, trash);
        List<Item> intechObjs = Arrays.asList(babyFootObj, distObj, trashcan);

        //Animals
        Item catObj  = new Item("cat", 10,  cat);
        Item dogObj  =new Item("Dog", 10, dog);
        Item horseObj = new Item("Horse", 10, horse);
        List<Item> animalObjs = Arrays.asList(catObj, dogObj, horseObj);

        //Kitchen
        Item cupObj =  new Item( "DrinkWare", 10,  cup);
        Item forkObj = new Item("Fork", 10, fork);
        Item knifeObj = new Item("Knife", 10, knife);
        Item microwaveObj = new Item("Microwave", 10, microwave);
        List<Item> kitchenObjs = Arrays.asList(cupObj, forkObj, knifeObj, microwaveObj);

        //Furniture
        Item couchObj =new Item("couch", 10,  couch);
        Item chairObj = new Item("chair", 10,  chair);
        List<Item> furnitureObjs = Arrays.asList(couchObj, chairObj);

        //Office
        Item penObj = new Item("Pen", 10, pen);
        Item printerObj = new Item("Printer", 10, printer);
        List<Item> officeObjs = Arrays.asList(penObj, printerObj);



        List<Item> items = Arrays.asList(babyFootObj,computerMouseObj, headsetObj, watchObj, cupObj, glassesObj,catObj, chairObj, couchObj, microwaveObj, knifeObj, forkObj,horseObj, dogObj, trashcan, distObj, computerObj, phoneObj, penObj, printerObj);

        itemRepository.saveAll(items);


        Quest techQuest = new Quest("Tech Piece", techObjs );
        Quest accessoryQuest = new Quest("Accessories", accessoriesObj);
        Quest office = new Quest("Office", officeObjs);
        Quest intech = new Quest("Intech", intechObjs);
        Quest animals = new Quest("animals", animalObjs);
        Quest furniture = new Quest("Furniture", furnitureObjs);
        Quest kitchen = new Quest("Kitchen", kitchenObjs);

        List<Quest> questList = Arrays.asList(techQuest, accessoryQuest, office,intech, animals, furniture, kitchen);
        questRepository.saveAll(questList);
    }
}
