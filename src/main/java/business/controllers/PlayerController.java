package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.PlayerWrapper;
import business.wrapper.VideoOutputWrapper;
import data.daos.AuthorizationDao;
import data.daos.UserDao;
import data.daos.VideoDao;
import data.entities.Role;
import data.entities.User;
import data.entities.Video;

@Controller
public class PlayerController {
	
	public static final int MAX_SUGGESTIONS = 5;

	private UserDao userDao;
	
	private AuthorizationDao authorizationDao;
	
	private VideoDao videoDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
	
	@Autowired
	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
	@Autowired
	public void setAuthorizationDao(AuthorizationDao authorizationDao) {
		this.authorizationDao = authorizationDao;
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

	public List<String> getSuggestionsNames(String ownUserName, String userName) {
		List<User> suggestionsUsersList = userDao.findByUserNameIgnoreCaseContaining(userName);
		List<String> suggestionsUserNamesList = new ArrayList<String>();
		int i = 0;
		while (i < suggestionsUsersList.size() && suggestionsUserNamesList.size() < MAX_SUGGESTIONS) {
			if (isPlayer(suggestionsUsersList.get(i)) && !suggestionsUsersList.get(i).getUserName().equals(ownUserName)) {
				suggestionsUserNamesList.add(suggestionsUsersList.get(i).getUserName());
			}
			i++;
		}
		return suggestionsUserNamesList;
	}

	private boolean isPlayer(User user) {
		List<Role> roles = authorizationDao.findRoleByUser(user);
		int i = 0;
		while (i < roles.size() && !roles.get(i).roleName().equals("ROLE_" + Role.PLAYER)) {
			i++;
		}
		return i < roles.size();
	}
	
}
