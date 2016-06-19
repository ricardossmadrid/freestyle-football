package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.InvalidFieldException;
import business.api.exceptions.NotFoundConversationIdException;
import business.api.exceptions.NotFoundUserNameException;
import business.controllers.ConversationController;
import business.wrapper.ConversationWrapper;
import business.wrapper.MessageInputWrapper;
import data.services.DataService;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.CONVERSATIONS)
public class ConversationResource {
	
	
	public ConversationController conversationController;
	
	public DataService dataService;
	
	@Autowired
	public void setConversationController(ConversationController conversationController) {
		this.conversationController = conversationController;
	}
	
	@Autowired
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ConversationWrapper getConversation(@AuthenticationPrincipal User activeUser, @RequestParam String conversationalist) throws NotFoundUserNameException {
		return conversationController.getConversation(activeUser.getUsername(), conversationalist);
	}
	
	@RequestMapping(value = Uris.MESSAGE, method = RequestMethod.POST)
	public void sendMessage(@AuthenticationPrincipal User activeUser, @RequestBody MessageInputWrapper messageInputWrapper) throws InvalidFieldException, NotFoundConversationIdException {
		dataService.validateField(messageInputWrapper.getConversationId(), "conversationId");
		dataService.validateField(messageInputWrapper.getMessage(), "message");
		conversationController.sendMessage(activeUser.getUsername(), messageInputWrapper);
	}

}
