package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.VideoWrapper;
import data.daos.UserDao;
import data.daos.VideoDao;
import data.entities.Video;

@Controller
public class VideoController {
	
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

	public void uploadVideo(String username, VideoWrapper videoWrapper) {
		Video video = new Video(userDao.findByUsernameOrEmail(username), videoWrapper.getTitle(), videoWrapper.getPlace(), videoWrapper.getYoutubeUrl());
		videoDao.save(video);
	}

}
