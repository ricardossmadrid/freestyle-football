package data.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Video {
	
	@Id
    @GeneratedValue
	private int id;
	
	@ManyToOne
    @JoinColumn
	private User player;
	
	private String title;
	
	private String place;
	
	private String youtubeUrl;
	
	private Calendar sendTime;

	public Video() {
		
	}

	public Video(User player, String title, String place, String youtubeUrl) {
		this.sendTime = Calendar.getInstance();
		this.player = player;
		this.title = title;
		this.place = place;
		this.youtubeUrl = youtubeUrl;
	}

	public int getId() {
		return id;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
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

	public Calendar getSendTime() {
		return sendTime;
	}

	public void setSendTime(Calendar sendTime) {
		this.sendTime = sendTime;
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
        return id == ((Video) obj).id;
    }

	@Override
	public String toString() {
		return "Video [id=" + id + ", player=" + player + ", title=" + title + ", place=" + place + ", youtubeUrl="
				+ youtubeUrl + ", sendTime=" + sendTime + "]";
	}


}
