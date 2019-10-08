package fr.intech.Java9.Object.Quest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private Long score;

    protected User(){}

    public User(String userName){
        this.userName = userName;
    }

    @Override
    public String toString(){
        return String.format("User[id=%d, Name = '%s', score = %d]",
                userId, userName, score);
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() { return userName; }

    public Long getScore(){ return score; }

}