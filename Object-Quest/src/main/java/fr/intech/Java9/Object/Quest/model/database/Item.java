package fr.intech.Java9.Object.Quest.model.database;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;
    private String itemName;
    private int point;


    @ElementCollection
    private List<String> labels;

    public Item(){}

    public Item(String itemName, int point, List<String> labels) {
        this.itemName = itemName;
        this.point = point;
        this.labels = labels;
    }

    @Override
    public String toString(){
        return String.format("Object[objectId = %d, Name = '%s', score = %d, labels = (%s)",
                itemId, itemName, point, labels);
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
