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

	public void battleChallenge(String userNameChallenger, BattleChallengeWrapper battleChallengeWrapper) throws NotFoundUserNameException {
		User userChallenger = userDao.findByUsernameOrEmail(userNameChallenger),
				userChallenged = userDao.findByUsernameOrEmail(battleChallengeWrapper.getUserChallenged());
		if (userChallenged != null && userChallenger != null && !userNameChallenger.equals(battleChallengeWrapper.getUserChallenged())) {
			List<User> players = new ArrayList<User>();
			players.add(userChallenger);
			players.add(userChallenged);
			Battle battle = new Battle(battleChallengeWrapper.getTitle(), battleChallengeWrapper.getDescription(), players, battleChallengeWrapper.getYoutubeUrl());
			battleDao.save(battle);
		} else {
			throw new NotFoundUserNameException("UserName not found");
		}
		
	}

}
