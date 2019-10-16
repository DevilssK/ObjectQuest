package fr.intech.Java9.Object.Quest.controller;

import fr.intech.Java9.Object.Quest.model.database.Quest;
import fr.intech.Java9.Object.Quest.model.database.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class QuestController {

        @Autowired
        QuestRepository questRepository;

        @GetMapping(value = "/getQuest")
        public Iterable<Quest> getQuests(){

                return questRepository.findAll();
        }

}
