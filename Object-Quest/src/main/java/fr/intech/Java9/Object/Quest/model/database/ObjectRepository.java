package fr.intech.Java9.Object.Quest.model.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjectRepository extends CrudRepository<Object, Integer> {

    List<Object> findByObjectName(String objectName);
    List<Object> findByQuest(Quest quest);
    Object findByObjectId(Integer objectId);

}
