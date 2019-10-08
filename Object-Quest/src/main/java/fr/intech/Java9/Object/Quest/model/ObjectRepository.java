package fr.intech.Java9.Object.Quest.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObjectRepository extends CrudRepository<Object, Long> {

    List<Object> findByName(String objectName);
    Object findById(long userId);
}
