package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.InvalidFieldException;
import business.api.exceptions.NotFoundUserNameException;
import business.controllers.BattleController;
import business.wrapper.BattleChallengeWrapper;
import data.services.DataService;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.BATTLES)
public class BattleResource {
	
	public BattleController battleController;
	
	public DataService dataService;
	
	@Autowired
	public void setBattleController(BattleController battleController) {
		this.battleController = battleController;
	}
	
	@Autowired
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	@RequestMapping(value = Uris.CHALLENGE, method = RequestMethod.POST)
	public void battleChallenge(@AuthenticationPrincipal User activeUser, @RequestBody BattleChallengeWrapper videoChallengeWrapper) throws InvalidFieldException, NotFoundUserNameException {
		dataService.validateField(videoChallengeWrapper.getTitle(), "title");
		dataService.validateField(videoChallengeWrapper.getDescription(), "description");
		dataService.validateField(videoChallengeWrapper.getYoutubeUrl(), "youtubeUrl");
		dataService.validateField(videoChallengeWrapper.getUserChallenged(), "userChallenged");
		battleController.battleChallenge(activeUser.getUsername(), videoChallengeWrapper);
	}

}
