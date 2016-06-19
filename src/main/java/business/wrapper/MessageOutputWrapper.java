package business.wrapper;

import java.util.Calendar;

public class MessageOutputWrapper {
	
	private String playerName;
	
	private String message;
	
	private Calendar sendMessageTime;

	public MessageOutputWrapper() {
		
	}

	public MessageOutputWrapper(String playerName, String message, Calendar sendMessageTime) {
		this.playerName = playerName;
		this.message = message;
		this.sendMessageTime = sendMessageTime;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Calendar getSendMessageTime() {
		return sendMessageTime;
	}

	public void setSendMessageTime(Calendar sendMessageTime) {
		this.sendMessageTime = sendMessageTime;
	}

	@Override
	public String toString() {
		return "MessageOutputWrapper [playerName=" + playerName + ", message=" + message + ", sendMessageTime="
				+ sendMessageTime + "]";
	}

}
