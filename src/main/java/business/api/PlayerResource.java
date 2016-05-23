package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public PlayerWrapper showPlayer() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return playerController.showPlayer(name);
	}

}
