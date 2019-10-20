package com.t.objectquest.database.entity;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.t.objectquest.model.Quest;

import java.util.List;

public interface QuestDao {

    @Query("select * from quest")
    List<Quest> getQuestList();

    @Insert
    void saveQuest(Quest quest);

    @Update
    void udpateQuest( Quest quest);

    @Delete
    void deleteQuest(Quest quest);

}
