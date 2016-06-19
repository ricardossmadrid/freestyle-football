package business.wrapper;

public class MessageInputWrapper {
	
	private int conversationId;
	
	private String message;

	public MessageInputWrapper() {
		
	}

	public MessageInputWrapper(int conversationId, String message) {
		this.conversationId = conversationId;
		this.message = message;
	}

	public int getConversationId() {
		return conversationId;
	}

	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageInputWrapper [conversationId=" + conversationId + ", message=" + message + "]";
	}

}
