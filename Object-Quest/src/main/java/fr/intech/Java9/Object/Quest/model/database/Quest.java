package fr.intech.Java9.Object.Quest.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questId;
    private String questName;

    public  Quest(){}
    public Quest(String questName) {
        this.questName = questName;
    }

    @Override
    public String toString(){
        return String.format("Quest[id=%d, Name = '%s']",
                questId, questName);
    }

    public Integer getQuestId() {
        return questId;
    }

    public String getQuestName() {
        return questName;
    }
    public void setQuestName(String questName) {
        this.questName = questName;
    }
}
