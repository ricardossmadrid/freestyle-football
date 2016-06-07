package business.wrapper;

import java.util.Calendar;

public class VideoOutputWrapper extends VideoWrapper {
	
	private Calendar sendTime;

	public VideoOutputWrapper() {
		super();
	}

	public VideoOutputWrapper(String title, String place, String youtubeUrl, Calendar sendTime) {
		super(title, place, youtubeUrl);
		this.sendTime = sendTime;
	}

	public Calendar getSendTime() {
		return sendTime;
	}

	public void setSendTime(Calendar sendTime) {
		this.sendTime = sendTime;
	}

	@Override
	public String toString() {
		return "VideoOutputWrapper [sendTime=" + sendTime + ", title=" + title + ", place=" + place + ", youtubeUrl="
				+ youtubeUrl + "]";
	}
	
	

}
