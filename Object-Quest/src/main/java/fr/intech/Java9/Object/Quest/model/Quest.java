package fr.intech.Java9.Object.Quest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quest {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questId;

    private String questName;


    public Quest(String questName){
        this.questName = questName;
    }

    public Long getQuestId() {
        return questId;
    }

    public String getQuestName() {
        return questName;
    }
}
