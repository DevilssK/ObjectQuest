package fr.intech.Java9.Object.Quest.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {


    List<User> findByUserName(String userName);

    User findById(long userId);

}
