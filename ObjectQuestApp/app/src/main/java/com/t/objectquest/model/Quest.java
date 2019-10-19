package com.t.objectquest.model;

import java.util.List;

public class Quest {

    private Integer questId;
    private String questName;

    private List<Item> items;

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
