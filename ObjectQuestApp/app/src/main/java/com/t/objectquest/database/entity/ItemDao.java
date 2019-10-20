package com.t.objectquest.database.entity;

import androidx.room.Insert;
import androidx.room.Query;

import com.t.objectquest.model.Item;

import java.util.List;

public interface ItemDao {

    @Query("select * from item")
    List<Item> getItemList();

    @Insert
    void saveItem();


}
