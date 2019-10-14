package fr.intech.Java9.Object.Quest.controller;


import fr.intech.Java9.Object.Quest.model.database.User;
import fr.intech.Java9.Object.Quest.model.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping({"/user"})
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/create")
    public int userCreate(@RequestBody  User user){


        System.out.println(user.getUserName());
        System.out.println(user.getScore());
        int userId = userRepository.save(user).getUserId();

        return userId;
    }

    @RequestMapping(value = "/score")
    public int getUserScore(@RequestBody int userId){

        int score = userRepository.findByUserId(userId).getScore();
        return score;
    }

    @RequestMapping(value = "/scoreupdate")
    public void scoreUpdate(int userId, int aScore){

        User user = userRepository.findByUserId(userId);
        int score = user.getScore();
        aScore = aScore + user.getScore();

        userRepository.updateScore(aScore);

    }

}
