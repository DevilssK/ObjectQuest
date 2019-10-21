package com.t.objectquest.database.entity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.t.objectquest.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user WHERE userName = :search")
    public List<User> findUserByName(String search);

    @Insert
    void saveUser(User user);

    @Update
    void updateUser( User user);

    @Query("SELECT * FROM user WHERE userId = :search")
    User findByUserId(int  search);
}
