package fr.intech.Java9.Object.Quest.service;


import fr.intech.Java9.Object.Quest.model.database.Object;
import fr.intech.Java9.Object.Quest.model.database.User;

public interface ScoreManager {

    public void updateScore(User user, Object foundObject);
    public void updateFoundObjects(User user, Object foundObject);
    public void updateScoreAndFoundObjects(User user, Object foundObject);

}
