package data.entities;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Battle {
	
	@Id
    @GeneratedValue
	private int id;
	
	private String title;
	
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<User> players;
	
	private String youtubeUrlChallenger;
	
	private String youtubeUrlChallenged;
	
	private int votesVideoChallenger;
	
	private int votesVideoChallenged;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Map<Integer, String> playersVoters;
	
	private Calendar battleChallengeTime;
	
	public Battle() {
		
	}

	public Battle(String title, String description, List<User> players, String youtubeUrlChallenger) {
		this.battleChallengeTime = Calendar.getInstance();
		this.title = title;
		this.description = description;
		this.players = players;
		this.youtubeUrlChallenger = youtubeUrlChallenger;
		this.youtubeUrlChallenged = null;
		this.votesVideoChallenger = 0;
		this.votesVideoChallenged = 0;
		this.playersVoters = new HashMap<Integer, String>();
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getPlayers() {
		return players;
	}

	public void setPlayers(List<User> players) {
		this.players = players;
	}

	public String getYoutubeUrlChallenger() {
		return youtubeUrlChallenger;
	}

	public void setYoutubeUrlChallenger(String youtubeUrlChallenger) {
		this.youtubeUrlChallenger = youtubeUrlChallenger;
	}

	public String getYoutubeUrlChallenged() {
		return youtubeUrlChallenged;
	}

	public void setYoutubeUrlChallenged(String youtubeUrlChallenged) {
		this.youtubeUrlChallenged = youtubeUrlChallenged;
	}

	public Calendar getBattleChallengeTime() {
		return battleChallengeTime;
	}

	public void setBattleChallengeTime(Calendar battleChallengeTime) {
		this.battleChallengeTime = battleChallengeTime;
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
        return id == ((Battle) obj).id;
    }

	@Override
	public String toString() {
		return "Battle [id=" + id + ", title=" + title + ", description=" + description + ", players=" + players
				+ ", youtubeUrlChallenger=" + youtubeUrlChallenger + ", youtubeUrlChallenged=" + youtubeUrlChallenged
				+ ", battleChallengeTime=" + battleChallengeTime + "]";
	}

	public void vote(String userName, String playerVoted) {
		if (playerVoted.equals(players.get(0).getUserName())) {
			this.votesVideoChallenger++;
		} else {
			this.votesVideoChallenged++;
		}
		playersVoters.put(this.playersVoters.size(), userName);
	}

	public Map<Integer, String> getPlayersVoters() {
		return this.playersVoters;
	}
	
}
