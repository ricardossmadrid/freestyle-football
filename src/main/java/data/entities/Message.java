package data.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	
	@Id
    @GeneratedValue
	private int id;
	
	private String userNameWriter;
	
	private String message;
	
	private Calendar sendMessageTime;
	
	@ManyToOne
    @JoinColumn
    private Conversation conversation;

	public Message() {
		
	}

	public Message(String userNameWriter, String message, Conversation conversation) {
		this.userNameWriter = userNameWriter;
		this.message = message;
		this.conversation = conversation;
		this.sendMessageTime = Calendar.getInstance();
	}

	public String getUserNameWriter() {
		return userNameWriter;
	}

	public void setUserNameWriter(String userNameWriter) {
		this.userNameWriter = userNameWriter;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public Calendar getSendMessageTime() {
		return sendMessageTime;
	}
	
	@Override
    public int hashCode() {
        return id;
    }

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return id == ((Message) obj).id;
    }

	@Override
	public String toString() {
		return "Message [id=" + id + ", userNameWriter=" + userNameWriter + ", message=" + message
				+ ", sendMessageTime=" + sendMessageTime + ", conversation=" + conversation + "]";
	}

}
