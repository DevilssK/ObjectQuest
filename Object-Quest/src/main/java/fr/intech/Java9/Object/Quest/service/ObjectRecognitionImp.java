package fr.intech.Java9.Object.Quest.service;
import fr.intech.Java9.Object.Quest.model.RequestResponse;
import fr.intech.Java9.Object.Quest.model.database.Object;
import fr.intech.Java9.Object.Quest.model.database.ObjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ObjectRecognitionImp  implements ObjectRecognition{

    private RequestResponse requestResponse;
    private ObjectRepository objectRepository;

    List<String> computerMouse = Arrays.asList(new String[]{"Electronic device", "Technology", "Computer hardware", "Mouse", "Input device", "Computer component", "Peripheral", "Wire"});
    List<String> watch = Arrays.asList(new String[]{"Watch accessory", "Watch", "Analog watch", "Fashion accessory", "Jewellery", "Material property", "Strap", "Metal"});
    List<String> headset = Arrays.asList(new String[] {"Headphones", "Audio equipment", "Technology", "Electronic device", "Headset", "Gadget", "Ear", "Circle"});
    List<String> glass = Arrays.asList(new String[]{"Cup", "Drinkware"});

    public ObjectRecognitionImp() {
    }

    public ObjectRecognitionImp(RequestResponse requestResponse,ObjectRepository objectRepository) {
        this.requestResponse = requestResponse;
        this.objectRepository = objectRepository;
    }

    public String ObjectIs(RequestResponse requestResponse){
//        if(isWatch(requestResponse)){
//            return "watch";
//        }
//        if(isMouse(requestResponse)){
//            return "computerMouse";
//        }
//        if(isCup(requestResponse)){ return "cup";}
//        if(isHeadset(requestResponse)){return "headset";}
//
//        else{ return "not Found";}
        return "true";
    }

    public String reconizeObject(RequestResponse requestResponse){
        Iterable<Object> objects = objectRepository.findAll();

        return objects.toString();
    }




    public  boolean isMouse( RequestResponse requestResponse ){

        int same = 0;
        List<String> descriptions =  requestResponse.getDescriptions();

        for (String description: descriptions
        ) {
            if (computerMouse.contains(description)){
                same++;
            }
        }
        int percentage = (same*100)/computerMouse.size();

        if(percentage > 70){
            return true;
        }
        else{return false;}
    }

    public  boolean isWatch( RequestResponse requestResponse ){

        int same = 0;
        List<String> descriptions =  requestResponse.getDescriptions();

        for (String description: descriptions
        ) {
            if (watch.contains(description)){
                same++;
            }
        }
        int percentage = (same*100)/watch.size();

        if(percentage > 70){
            return true;
        }
        else{return false;}
    }

    public boolean isCup(RequestResponse requestResponse){

        return false;
    }


}
