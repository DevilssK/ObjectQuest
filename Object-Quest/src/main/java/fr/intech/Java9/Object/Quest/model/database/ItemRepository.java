package fr.intech.Java9.Object.Quest.model.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    List<Item> findByItemName(String objectName);
    Item findByItemId(Integer objectId);

}
