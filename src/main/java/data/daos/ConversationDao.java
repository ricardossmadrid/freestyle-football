package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Conversation;
import data.entities.User;

public interface ConversationDao extends JpaRepository<Conversation, Integer> {
	
	List<Conversation> findByPlayersOrderById(User player);

}
