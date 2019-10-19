package fr.intech.Java9.Object.Quest;

import fr.intech.Java9.Object.Quest.model.database.Quest;
import fr.intech.Java9.Object.Quest.model.database.QuestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class QuestTests {

    @Autowired
    QuestRepository questRepository;

    @Test
    public void check_defaut_quests_number(){

        List<Quest> quests = (List)questRepository.findAll();
        assertEquals(quests.size(), 7);

    }
}
