package fr.intech.Java9.Object.Quest.model.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {


    List<User> findByUserName(String userName);

    User findByUserId(Integer userId);

    void updateScore(Integer score);

}
