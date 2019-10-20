package com.t.objectquest.database.entity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;

import com.t.objectquest.model.User;

@Dao
public interface UserDao {

    @Insert
    void saveUser(User user);

    @Update
    void updateUser( User user);
}
