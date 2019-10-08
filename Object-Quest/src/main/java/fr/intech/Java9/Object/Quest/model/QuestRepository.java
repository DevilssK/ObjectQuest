package fr.intech.Java9.Object.Quest.model;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface QuestRepository extends CrudRepository<Quest, Integer> {

    List<Quest> findByQuestName(String questName );

    Quest findByQuestId(Integer questId);
}