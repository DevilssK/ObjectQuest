package fr.intech.Java9.Object.Quest;

import fr.intech.Java9.Object.Quest.model.database.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class DaoTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void userDoa (){

        User user = new User( "axel" );
        userRepository.save(user);

        List<User>  sutList = userRepository.findByUserName("axel");

        assertEquals(1,sutList.size());
        assertEquals("axel", sutList.get(0).getUserName());
    }

    @Test
    public void questDao(){

//        Quest quest = new Quest("aggrapheuse");
//        questRepository.save(quest);
//
//        List<Quest> sutList = questRepository.findByQuestName("aggrapheuse");
//
//        assertEquals(1, sutList.size());
//        assertEquals("aggrapheuse", sutList.get(0).getQuestName());

    }

    @Test
    @Transactional
    public void objectDao(){

//        List<String> computerMouse = Arrays.asList(new String[]{"Electronic device", "Technology", "Computer hardware", "Mouse", "Input device", "Computer component", "Peripheral", "Wire"});
//        List<String> labels = Arrays.asList("Watch accessory", "Watch", "Analog watch", "Fashion accessory", "Jewellery", "Material property", "Strap", "Metal");

//        Object object = new Object("object", 10, 1, computerMouse);
//        Object object1 = new Object("object1", 20, 1, computerMouse);
//        Object object2 = new Object("object2", 10, 1, computerMouse);
//        Object object3 = new Object("object3", 30, 1, computerMouse);
//        Object object4 = new Object("object4", 40, 1, computerMouse);
//        Object object5 = new Object("object5", 50, 0, computerMouse);

//        List<Object> objects = Arrays.asList(object, object1,object2, object3, object4, object5);
//
//        objectRepository.save(object1);
//         Object sut =  objectRepository.findByObjectName("object1").get(0);
//
//        List<String> sutLabels = sut.getLabels();
//
//        System.out.println(sutLabels.size());
//

         //assertEquals(sutLabels.size(), labels.size());

        //objectRepository.saveAll(objects);

        //List<Object> sutList = objectRepository.findByQuestId(1);
//
//        assertEquals(5,sutList.size());
//        assertEquals("object", sutList.get(0).getObjectName());
//        Object sut = sutList.get(0);

       // System.out.println(sut.getLabels());

    }
}
