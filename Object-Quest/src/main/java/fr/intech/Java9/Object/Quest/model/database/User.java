package fr.intech.Java9.Object.Quest.model.database;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    private int score;

    @ElementCollection
    private List<Quest> success;

    @ElementCollection
    private List<Item> foundItems;

    public User() {}

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString(){
        return String.format("User[id=%d, Name = '%s', score = %d]",
                userId, userName, score);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Quest> getSuccess() {
        return success;
    }

    public void setSuccess(List<Quest> success) {
        this.success = success;
    }

    public List<Item> getFoundItems() {
        return foundItems;
    }

    public void setFoundItems(List<Item> foundItems) {
        this.foundItems = foundItems;
    }

    public void addFoundObject(Item foundItem){
        foundItems.add(foundItem);
    }
}