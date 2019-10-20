package fr.intech.Java9.Object.Quest.model.database;

import javax.persistence.*;
import java.util.List;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questId;
    private String questName;

    @ElementCollection(fetch = FetchType.EAGER )
    private List<Item> items;

    public  Quest(){}

    public Quest(String questName, List<Item> items) {
        this.questName = questName;
        this.items = items;
    }

    @Override
    public String toString(){
        return String.format("Quest[id=%d, Name = '%s']",
                questId, questName);
    }

    @Transient
    @ElementCollection(fetch = FetchType.EAGER)
    public List<Item> getItems(){
        return items;
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

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
