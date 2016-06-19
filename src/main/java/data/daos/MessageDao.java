package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Conversation;
import data.entities.Message;

public interface MessageDao extends JpaRepository<Message, Integer> {
	
	List<Message> findByConversation(Conversation conversation);

}
