package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.PlayerWrapper;
import data.daos.UserDao;
import data.entities.User;

@Controller
public class PlayerController {

	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
	
	public PlayerWrapper showPlayer(String username) {
		User user = userDao.findByUsernameOrEmail(username);
		return new PlayerWrapper(user.getUserName(), user.getBirthDate(), user.getStartingYear(), user.getSummary());
	}
	
}
