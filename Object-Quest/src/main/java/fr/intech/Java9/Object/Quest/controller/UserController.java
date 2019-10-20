package fr.intech.Java9.Object.Quest.controller;


import fr.intech.Java9.Object.Quest.model.database.User;
import fr.intech.Java9.Object.Quest.model.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/score/{userId}")
    public int getUserScore( int userId){

        int score = userRepository.findByUserId(userId).getScore();
        return score;
    }


}
