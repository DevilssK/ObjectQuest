package fr.intech.Java9.Object.Quest.model.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {


    List<User> findByUserName(String userName);

    User findByUserId(Integer userId);
}
