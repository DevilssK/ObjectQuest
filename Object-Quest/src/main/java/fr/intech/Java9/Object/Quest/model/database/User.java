package fr.intech.Java9.Object.Quest.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String userName;
    private int score;

    public User(){}
    public User(String userName){
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
    public String getUserName() { return userName; }
    public int getScore(){ return score; }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setScore(int score) {
        this.score = score;
    }
}