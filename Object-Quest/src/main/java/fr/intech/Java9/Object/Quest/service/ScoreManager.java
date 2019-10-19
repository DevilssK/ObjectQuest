package fr.intech.Java9.Object.Quest.service;


import fr.intech.Java9.Object.Quest.model.database.Item;
import fr.intech.Java9.Object.Quest.model.database.User;

public interface ScoreManager {

    public void updateScore(User user, Item foundItem);
    public void updateFoundObjects(User user, Item foundItem);
    public void updateScoreAndFoundObjects(User user, Item foundItem);

}
