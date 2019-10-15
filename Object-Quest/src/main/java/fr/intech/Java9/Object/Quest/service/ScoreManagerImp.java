package fr.intech.Java9.Object.Quest.service;

import fr.intech.Java9.Object.Quest.model.database.Object;
import fr.intech.Java9.Object.Quest.model.database.User;
import fr.intech.Java9.Object.Quest.model.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreManagerImp implements ScoreManager {


    @Autowired
    UserRepository userRepository;


    public void updateScoreAndFoundObjects(User user, Object foundObject){
        updateScore( user, foundObject);
        updateFoundObjects( user, foundObject);

        userRepository.save(user);
    }

    public void updateScore(User user, Object foundObject){

        int score = user.getScore();
        score = score + foundObject.getPoint();
        userRepository.save(user);
    }

    public void updateFoundObjects(User user, Object foundObject){

        user.addFoundObject(foundObject);
        userRepository.save(user);
    }

}
