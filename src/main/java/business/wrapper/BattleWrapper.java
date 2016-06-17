package business.wrapper;

import java.util.Calendar;

public class BattleWrapper {
	
	private int id;
	
	private String titulo;
	
	private String description;
	
	private String userChallenger;
	
	private String userChallenged;
	
	private String youtubeUrlChallenger;	
	
	private String youtubeUrlChallenged;
	
	private int votesVideoChallenger;
	
	private int votesVideoChallenged;
	
	private Calendar battleChallengeTime;

	public BattleWrapper() {

	}

	public BattleWrapper(int id, String titulo, String description, String userChallenger, String userChallenged,
			String youtubeUrlChallenger, String youtubeUrlChallenged, int votesVideoChallenger, int votesVideoChallenged, Calendar battleChallengeTime) {
		this.id = id;
		this.titulo = titulo;
		this.description = description;
		this.userChallenger = userChallenger;
		this.userChallenged = userChallenged;
		this.youtubeUrlChallenger = youtubeUrlChallenger;
		this.youtubeUrlChallenged = youtubeUrlChallenged;
		this.battleChallengeTime = battleChallengeTime;
		this.votesVideoChallenger = votesVideoChallenger;
		this.votesVideoChallenged = votesVideoChallenged;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserChallenger() {
		return userChallenger;
	}

	public void setUserChallenger(String userChallenger) {
		this.userChallenger = userChallenger;
	}

	public String getUserChallenged() {
		return userChallenged;
	}

	public void setUserChallenged(String userChallenged) {
		this.userChallenged = userChallenged;
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

	public int getVotesVideoChallenger() {
		return votesVideoChallenger;
	}

	public void setVotesVideoChallenger(int votesVideoChallenger) {
		this.votesVideoChallenger = votesVideoChallenger;
	}

	public int getVotesVideoChallenged() {
		return votesVideoChallenged;
	}

	public void setVotesVideoChallenged(int votesVideoChallenged) {
		this.votesVideoChallenged = votesVideoChallenged;
	}

	public Calendar getBattleChallengeTime() {
		return battleChallengeTime;
	}

	public void setBattleChallengeTime(Calendar battleChallengeTime) {
		this.battleChallengeTime = battleChallengeTime;
	}

	@Override
	public String toString() {
		return "BattleWrapper [id=" + id + ", titulo=" + titulo + ", description=" + description + ", userChallenger="
				+ userChallenger + ", userChallenged=" + userChallenged + ", youtubeUrlChallenger="
				+ youtubeUrlChallenger + ", youtubeUrlChallenged=" + youtubeUrlChallenged + ", votesVideoChallenger="
				+ votesVideoChallenger + ", votesVideoChallenged=" + votesVideoChallenged + ", battleChallengeTime="
				+ battleChallengeTime + "]";
	}

}
