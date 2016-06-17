package business.wrapper;

import java.util.Calendar;
import java.util.List;

public class PlayerWrapper {
	
	private String userName;
	
	private Calendar age;
	
	private int startingYear;
	
	private String summary;
	
	private List<VideoOutputWrapper> videos;
	
	private List<BattleWrapper> battles;
	
	private int wins;
	
	private int numberOfBattles;
	
	private boolean ownPlayer;

	public PlayerWrapper() {
		
	}

	public PlayerWrapper(String userName, Calendar age, int startingYear, String summary, List<VideoOutputWrapper> videos, 
			List<BattleWrapper> battles, boolean ownPlayer, int wins) {
		this.userName = userName;
		this.age = age;
		this.startingYear = startingYear;
		this.summary = summary;
		this.videos = videos;
		this.battles = battles;
		this.ownPlayer = ownPlayer;
		this.wins = wins;
		this.numberOfBattles = battles.size();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Calendar getAge() {
		return age;
	}

	public void setAge(Calendar age) {
		this.age = age;
	}

	public int getStartingYear() {
		return startingYear;
	}

	public void setStartingYear(int startingYear) {
		this.startingYear = startingYear;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<VideoOutputWrapper> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoOutputWrapper> videos) {
		this.videos = videos;
	}

	public List<BattleWrapper> getBattles() {
		return battles;
	}

	public void setBattles(List<BattleWrapper> battles) {
		this.battles = battles;
	}

	public boolean isOwnPlayer() {
		return ownPlayer;
	}

	public void setOwnPlayer(boolean ownPlayer) {
		this.ownPlayer = ownPlayer;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getNumberOfBattles() {
		return numberOfBattles;
	}

	@Override
	public String toString() {
		return "PlayerWrapper [userName=" + userName + ", age=" + age + ", startingYear=" + startingYear + ", summary="
				+ summary + ", videos=" + videos + ", battles=" + battles + ", wins=" + wins + ", lost=" + numberOfBattles
				+ ", ownPlayer=" + ownPlayer + "]";
	}

}
