package fr.intech.Java9.Object.Quest.model.database;

import javax.persistence.Entity;

@Entity
public class UserPassword {


 private User user;
 private String password;

    public UserPassword() {
    }

    public UserPassword(User user, String password) {
        this.user = user;
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
