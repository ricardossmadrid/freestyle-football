package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.PlayerWrapper;
import business.wrapper.VideoOutputWrapper;
import data.daos.UserDao;
import data.daos.VideoDao;
import data.entities.User;
import data.entities.Video;

@Controller
public class PlayerController {

	private UserDao userDao;
	
	private VideoDao videoDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
	
	@Autowired
	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
	public PlayerWrapper showPlayer(String username) {
		User user = userDao.findByUsernameOrEmail(username);
		return new PlayerWrapper(user.getUserName(), user.getBirthDate(), user.getStartingYear(), user.getSummary(), getVideoWrappers(videoDao.findByPlayerOrderBySendTimeDesc(user)));
	}

	private List<VideoOutputWrapper> getVideoWrappers(List<Video> videosEntity) {
		List<VideoOutputWrapper> videosWrapper = new ArrayList<VideoOutputWrapper>();
		for (int i = 0; i < videosEntity.size(); i++) {
			videosWrapper.add(new VideoOutputWrapper(videosEntity.get(i).getTitle(), videosEntity.get(i).getPlace(), videosEntity.get(i).getYoutubeUrl(), videosEntity.get(i).getSendTime()));
		}
		return videosWrapper;
	}
	
}
