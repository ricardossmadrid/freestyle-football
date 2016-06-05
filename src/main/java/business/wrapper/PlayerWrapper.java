package business.wrapper;

import java.util.Calendar;
import java.util.List;

public class PlayerWrapper {
	
	private String userName;
	
	private Calendar age;
	
	private int startingYear;
	
	private String summary;
	
	private List<VideoWrapper> videos;

	public PlayerWrapper() {
		
	}

	public PlayerWrapper(String userName, Calendar age, int startingYear, String summary, List<VideoWrapper> videos) {
		this.userName = userName;
		this.age = age;
		this.startingYear = startingYear;
		this.summary = summary;
		this.videos = videos;
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

	public List<VideoWrapper> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoWrapper> videos) {
		this.videos = videos;
	}

	@Override
	public String toString() {
		return "PlayerWrapper [userName=" + userName + ", age=" + age + ", startingYear=" + startingYear + ", summary="
				+ summary + ", videos=" + videos + "]";
	}


}
