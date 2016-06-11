package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.controllers.PlayerController;
import business.wrapper.PlayerWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.PLAYERS)
public class PlayerResource {
	
	public PlayerController playerController;
	
	@Autowired
    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public PlayerWrapper showPlayer(@AuthenticationPrincipal User activeUser) {
		return playerController.showPlayer(activeUser.getUsername());
	}
	
	@RequestMapping(value = Uris.SUGGESTIONS, method = RequestMethod.GET)
	public List<String> getSuggestionsNames(@AuthenticationPrincipal User activeUser, @RequestParam String playerName) {
		return playerController.getSuggestionsNames(activeUser.getUsername(), playerName);
	}

}
