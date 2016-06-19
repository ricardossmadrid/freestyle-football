package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.api.exceptions.NotFoundConversationIdException;
import business.api.exceptions.NotFoundUserNameException;
import business.wrapper.ConversationWrapper;
import business.wrapper.MessageInputWrapper;
import business.wrapper.MessageOutputWrapper;
import data.daos.ConversationDao;
import data.daos.MessageDao;
import data.daos.UserDao;
import data.entities.Conversation;
import data.entities.Message;
import data.entities.User;

@Controller
public class ConversationController {
	
	private ConversationDao conversationDao;
	
	private MessageDao messageDao;
	
	private UserDao userDao;
	
	@Autowired
	public void setConversationDao(ConversationDao conversationDao) {
		this.conversationDao = conversationDao;
	}
	
	@Autowired
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ConversationWrapper getConversation(String username, String conversationalist) throws NotFoundUserNameException {
		User conversationalist1 = userDao.findByUsernameOrEmail(username),
				conversationalist2 = userDao.findByUsernameOrEmail(conversationalist);
		if (conversationalist1 != null && conversationalist2 != null && !conversationalist1.equals(conversationalist2)){
			List<User> talkers = new ArrayList<User>();
			talkers.add(conversationalist1);
			talkers.add(conversationalist2);
			List<Conversation> conversations = conversationDao.findByPlayersOrderById(userDao.findByUsernameOrEmail(username));
			Conversation conversation = getConversationBetweenPlayers(talkers, conversations);
			if (conversation == null) {
				conversation = new Conversation(talkers);
				conversationDao.save(conversation);	
			}
			return new ConversationWrapper(conversation.getId(), getConversationWrappers(messageDao.findByConversation(conversation)));
		} else {
			throw new NotFoundUserNameException();
		}
	}

	private List<MessageOutputWrapper> getConversationWrappers(List<Message> messages) {
		List<MessageOutputWrapper> conversationWrappers = new ArrayList<MessageOutputWrapper>();
		for (int i = 0; i < messages.size(); i++) {
			conversationWrappers.add(new MessageOutputWrapper(messages.get(i).getUserNameWriter(), messages.get(i).getMessage(), messages.get(i).getSendMessageTime()));
		}
		return conversationWrappers;
	}

	private Conversation getConversationBetweenPlayers(List<User> talkers, List<Conversation> conversations) {
		int i = 0;
		while (i < conversations.size() && !conversations.get(i).getPlayers().containsAll(talkers)) {
			i++;
		}
		return i < conversations.size() ? conversations.get(i) : null;
	}

	public void sendMessage(String username, MessageInputWrapper messageInputWrapper) throws NotFoundConversationIdException {
		Conversation conversation = conversationDao.findOne(messageInputWrapper.getConversationId());
		if (conversation != null) {
			Message message = new Message(username, messageInputWrapper.getMessage(), conversation);
			message = messageDao.save(message);
		} else {
			throw new NotFoundConversationIdException();
		}
	}

}
