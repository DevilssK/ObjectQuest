package fr.intech.Java9.Object.Quest.service;
import fr.intech.Java9.Object.Quest.model.RequestResponse;
import fr.intech.Java9.Object.Quest.model.database.Object;
import fr.intech.Java9.Object.Quest.model.database.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ObjectRecognitionImp  implements ObjectRecognition{

    @Autowired
    private ObjectRepository objectRepository;


    public Object reconizeObject(RequestResponse requestResponse){

        List<Object> objects = (List)objectRepository.findAll();

        Object obj = new Object();

        for(Object object : objects){

            if(areSimilare(requestResponse.getDescriptions(), object.getLabels())){
                return object;
            }
            else{
                return obj;
            }
        }

        return obj;
    }

    public static boolean areSimilare(List<String> responseAnnotations, List<String> objAnnotations ){
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
