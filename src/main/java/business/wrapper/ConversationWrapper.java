package business.wrapper;

import java.util.List;

public class ConversationWrapper {
	
	private int conversationId;
	
	private List<MessageOutputWrapper> messages;

	public ConversationWrapper() {
		
	}

	public ConversationWrapper(int conversationId, List<MessageOutputWrapper> messages) {
		this.conversationId = conversationId;
		this.messages = messages;
	}

	public int getConversationId() {
		return conversationId;
	}

	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}

	public List<MessageOutputWrapper> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageOutputWrapper> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "ConversationWrapper [conversationId=" + conversationId + ", messages=" + messages + "]";
	}

}
