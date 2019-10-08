package fr.intech.Java9.Object.Quest.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer objectId;
    private String objectName;
    private  int point;
    private Integer questId;

    protected Object(){}

    public Object(String objectName, int point, Integer questId) {
        this.objectName = objectName;
        this.point = point;
        this.questId = questId;
    }

    @Override
    public String toString(){
        return String.format("Object[objectId = %d, Name = '%s', score = %d",
                objectId, objectName, point);
    }

    public Integer getObjectId() {
        return objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public int getPoint() {
        return point;
    }

    public Integer getQuestId() {
        return questId;
    }
}
