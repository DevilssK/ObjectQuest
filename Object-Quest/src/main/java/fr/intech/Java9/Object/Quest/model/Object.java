package fr.intech.Java9.Object.Quest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long objectId;
    private String name;
    private  int point;
    private Long questId;

    @Override
    public String toString(){
        return String.format("Object[objectId = %d, Name = '%s', score = %d",
                objectId, name, point);
    }

    public Long getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public Long getQuestId(){ return questId; }
}
