package fr.intech.Java9.Object.Quest.service;


import fr.intech.Java9.Object.Quest.model.RequestResponse;
import fr.intech.Java9.Object.Quest.model.database.Item;

public interface ObjectRecognition {

    public Item reconizeObject(RequestResponse requestResponse);

}
