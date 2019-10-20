package com.t.objectquest.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.t.objectquest.database.entity.ItemDao;
import com.t.objectquest.database.entity.QuestDao;
import com.t.objectquest.database.entity.UserDao;
import com.t.objectquest.model.Item;
import com.t.objectquest.model.Quest;

@Database(entities = {Quest.class, Item.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract QuestDao questDao();
    public abstract ItemDao itemDao();
    public abstract UserDao userDao();
}
