package com.t.objectquest.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.t.objectquest.database.entity.ItemDao;
import com.t.objectquest.database.entity.QuestDao;
import com.t.objectquest.database.entity.UserDao;
import com.t.objectquest.model.Item;
import com.t.objectquest.model.Quest;
import com.t.objectquest.model.User;

@Database(entities = {Quest.class, Item.class, User.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "ObjectQuest_db";
    private static AppDatabase instance;

    public abstract QuestDao questDao();
    public abstract ItemDao itemDao();
    public abstract UserDao userDao();

    public static synchronized AppDatabase getIstance(Context context) {
        if(instance == null ){
            instance = Room.databaseBuilder( context.getApplicationContext(), AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }
}
