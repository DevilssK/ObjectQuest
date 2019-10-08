package fr.intech.Java9.Object.Quest;

import fr.intech.Java9.Object.Quest.model.Quest;
import fr.intech.Java9.Object.Quest.model.QuestRepository;
import fr.intech.Java9.Object.Quest.model.User;
import fr.intech.Java9.Object.Quest.model.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTests {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private QuestRepository questRepository;

    @Test
    public void userDoa (){


        User user = new User( "axel" );
        userRepository.save(user);

        List<User>  sutList = userRepository.findByUserName("axel");

        assertEquals(1,sutList.size());
        assertEquals("axel", sutList.get(0).getUserName());
    }

//    @Test
//    public void QuestDao(){
//        Quest quest = new Quest("aggrapheuse");
//        questRepository.save(quest);
//
//        List<Quest> sutList = questRepository.findByName("aggrapheuse");
//
//        assertEquals(1, sutList.size());
//        assertEquals("aggrapheuse", sutList.get(0).getQuestName());
//
//    }
}
