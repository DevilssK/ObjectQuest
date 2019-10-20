package com.t.objectquest.model;

public class User {
    int userId;
    String username;
    int score;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public User(int userId, String username, int score) {
        this.userId = userId;
        this.username = username;
        this.score = score;
    }
}
