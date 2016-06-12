package business.wrapper;

public class BattleChallengeWrapper {
	
	private String title;
	
	private String description;
	
	private String youtubeUrl;
	
	private String userChallenged;

	public BattleChallengeWrapper() {
		
	}

	public BattleChallengeWrapper(String title, String description, String youtubeUrl, String userChallenged) {
		this.title = title;
		this.description = description;
		this.youtubeUrl = youtubeUrl;
		this.userChallenged = userChallenged;
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

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}

	public String getUserChallenged() {
		return userChallenged;
	}

	public void setUserChallenged(String userChallenged) {
		this.userChallenged = userChallenged;
	}

	@Override
	public String toString() {
		return "VideoChallengeWrapper [title=" + title + ", description=" + description + ", youtubeUrl=" + youtubeUrl
				+ ", userChallenged=" + userChallenged + "]";
	}

}
