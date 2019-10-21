package com.t.objectquest.database.entity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.t.objectquest.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from user")
    List<User> getUserList();

    @Insert
    void saveUser(User user);

    @Update
    void updateUser( User user);
}
