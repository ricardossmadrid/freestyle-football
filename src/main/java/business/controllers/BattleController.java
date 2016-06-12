package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.api.exceptions.NotFoundUserNameException;
import business.wrapper.BattleChallengeWrapper;
import data.daos.BattleDao;
import data.daos.UserDao;
import data.entities.Battle;
import data.entities.User;

@Controller
public class BattleController {
	
	private BattleDao battleDao;
	
	private UserDao userDao;
	
	@Autowired
	public void setBattleDao(BattleDao battleDao) {
		this.battleDao = battleDao;
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void battleChallenge(String userNameChallenger, BattleChallengeWrapper videoChallengeWrapper) throws NotFoundUserNameException {
		User userChallenger = userDao.findByUsernameOrEmail(userNameChallenger),
				userChallenged = userDao.findByUsernameOrEmail(videoChallengeWrapper.getUserChallenged());
		if (userChallenged != null && userChallenger != null) {
			List<User> players = new ArrayList<User>();
			players.add(userChallenger);
			players.add(userChallenged);
			Battle battle = new Battle(videoChallengeWrapper.getTitle(), videoChallengeWrapper.getDescription(), players, videoChallengeWrapper.getYoutubeUrl());
			battleDao.save(battle);
		} else {
			throw new NotFoundUserNameException("UserName not found");
		}
		
	}

}
