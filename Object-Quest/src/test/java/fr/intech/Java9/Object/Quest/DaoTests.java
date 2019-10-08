package fr.intech.Java9.Object.Quest;

import fr.intech.Java9.Object.Quest.model.*;
import fr.intech.Java9.Object.Quest.model.Object;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private ObjectRepository objectRepository;

    @Test
    public void userDoa (){

        User user = new User( "axel" );
        userRepository.save(user);

        List<User>  sutList = userRepository.findByUserName("axel");

        assertEquals(1,sutList.size());
        assertEquals("axel", sutList.get(0).getUserName());
    }

    @Test
    public void QuestDao(){

        Quest quest = new Quest("aggrapheuse");
        questRepository.save(quest);

        List<Quest> sutList = questRepository.findByQuestName("aggrapheuse");

        assertEquals(1, sutList.size());
        assertEquals("aggrapheuse", sutList.get(0).getQuestName());

    }

    @Test
    public void ObjectDao(){

        Object object = new Object("object", 10, 1);
        Object object1 = new Object("object1", 20, 1);
        Object object2 = new Object("object2", 10, 1);
        Object object3 = new Object("object3", 30, 1);
        Object object4 = new Object("object4", 40, 1);
        Object object5 = new Object("object5", 50, 0);

        List<Object> objects = Arrays.asList(new Object[]{object, object1,object2, object3, object4, object5});

        objectRepository.saveAll(objects);

        List<Object> sutList = objectRepository.findByQuestId(1);

        assertEquals(5,sutList.size());
        assertEquals("object", sutList.get(0).getObjectName());
    }
}
