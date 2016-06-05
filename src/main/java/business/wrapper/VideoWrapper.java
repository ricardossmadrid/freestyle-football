package business.wrapper;

public class VideoWrapper {
	
	private String title;
	
	private String place;
	
	private String youtubeUrl;

	public VideoWrapper() {
	}

	public VideoWrapper(String title, String place, String youtubeUrl) {
		this.title = title;
		this.place = place;
		this.youtubeUrl = youtubeUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}

	@Override
	public String toString() {
		return "VideoWrapper [title=" + title + ", place=" + place + ", youtubeUrl=" + youtubeUrl + "]";
	}
	
	

}
