package fr.intech.Java9.Object.Quest.service;

import fr.intech.Java9.Object.Quest.model.database.Item;
import fr.intech.Java9.Object.Quest.model.database.User;
import fr.intech.Java9.Object.Quest.model.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreManagerImp implements ScoreManager {


    @Autowired
    UserRepository userRepository;


    public void updateScoreAndFoundObjects(User user, Item foundItem){
        updateScore( user, foundItem);
        updateFoundObjects( user, foundItem);

        userRepository.save(user);
    }

    public void updateScore(User user, Item foundItem){

        int score = user.getScore();
        score = score + foundItem.getPoint();
        userRepository.save(user);
    }

    public void updateFoundObjects(User user, Item foundItem){

        user.addFoundObject(foundItem);
        userRepository.save(user);
    }

}
