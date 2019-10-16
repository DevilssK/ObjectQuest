package fr.intech.Java9.Object.Quest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LoginController {

    @PostMapping
    public void Login(@RequestBody int userId, String password){


    }
}
