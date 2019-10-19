package fr.intech.Java9.Object.Quest.service;
import fr.intech.Java9.Object.Quest.model.RequestResponse;
import fr.intech.Java9.Object.Quest.model.database.Item;
import fr.intech.Java9.Object.Quest.model.database.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectRecognitionImp  implements ObjectRecognition{

    @Autowired
    private ItemRepository itemRepository;


    public Item reconizeObject(RequestResponse requestResponse){

        List<Item> items = (List) itemRepository.findAll();

        Item obj = new Item();

        for(Item item : items){

            if(areSimilare(requestResponse.getDescriptions(), item.getLabels())){
                return item;
            }
            else{
                return obj;
            }
        }

        return obj;
    }

    public  boolean areSimilare(List<String> responseAnnotations, List<String> objAnnotations ){
        int same = 0;
        for (String annotation: objAnnotations) {
            if(responseAnnotations.contains(annotation)){
                same++;
            }
            else same = same;
        }
        same = (same*100)/objAnnotations.size();

        if(same>= 70){
            return true;
        }
        else {return false;}
    }
}
