package fr.intech.Java9.Object.Quest;

import fr.intech.Java9.Object.Quest.model.database.Item;
import fr.intech.Java9.Object.Quest.model.database.ItemRepository;
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
public class ItemTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void check_default_items_number(){

        List<Item> items = (List)itemRepository.findAll();
        assertEquals(items.size(), 20);
    }

    public void can_find_item_by_id(){

    }
}
