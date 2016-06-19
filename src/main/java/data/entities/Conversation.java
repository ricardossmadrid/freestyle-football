package data.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Conversation {
	
	@Id
    @GeneratedValue
	private int id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<User> players;

	public Conversation() {
		
	}

	public Conversation(List<User> players) {
		this.players = players;
	}

	public List<User> getPlayers() {
		return players;
	}

	public void setPlayers(List<User> players) {
		this.players = players;
	}

	public int getId() {
		return id;
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
        return id == ((Conversation) obj).id;
    }

	@Override
	public String toString() {
		return "Conversation [id=" + id + ", players=" + players + "]";
	}

}
