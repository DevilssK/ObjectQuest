package fr.intech.Java9.Object.Quest.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjectRepository extends CrudRepository<Object, Integer> {

    List<Object> findByObjectName(String objectName);
    List<Object> findByQuestId(Integer questId);
    Object findByObjectId(Integer objectId);

}
