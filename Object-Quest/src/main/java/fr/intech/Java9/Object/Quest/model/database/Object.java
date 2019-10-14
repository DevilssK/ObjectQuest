package fr.intech.Java9.Object.Quest.model.database;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer objectId;
    private String objectName;
    private  int point;

    @OneToOne
    private Quest quest;

    @ElementCollection
    private List<String> labels;

    public Object(){}

    public Object(String objectName, int point, Quest quest, List<String> labels) {
        this.objectName = objectName;
        this.point = point;
        this.quest = quest;
        this.labels = labels;
    }

    @Override
    public String toString(){
        return String.format("Object[objectId = %d, Name = '%s', score = %d, labels = (%s)",
                objectId, objectName, point, labels);
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
