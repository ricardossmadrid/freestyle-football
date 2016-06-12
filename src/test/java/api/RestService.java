package api;

import java.util.ArrayList;
import java.util.List;

import business.api.Uris;
import business.wrapper.BattleChallengeWrapper;
import business.wrapper.BattleWrapper;
import business.wrapper.TokenWrapper;
import business.wrapper.UserWrapper;
import business.wrapper.UserWrapperBuilder;
import business.wrapper.VideoWrapper;

public class RestService {

    public static final String URL = "http://localhost:8080/freestyle-football.0.0.1-SNAPSHOT" + Uris.SERVLET_MAP;
    
    public String loginUser(String user, String pass) {
        TokenWrapper token = new RestBuilder<TokenWrapper>(URL).path(Uris.TOKENS).basicAuth(user, pass).clazz(TokenWrapper.class)
                .post().build();
        return token.getToken();
    }
    
    public void registerSomePLayers(int size) {
    	for (int i = 1; i <= size; i++) {
    		UserWrapper player = new UserWrapperBuilder(i).build();
            new RestBuilder<Object>(URL).path(Uris.USERS).body(player).post().build();
    	}
    }
    
    public List<String> loginSomePlayers(int size) {
    	List<String> tokens = new ArrayList<String>();
    	for (int i = 1; i <= size; i++) {
    		tokens.add(loginUser("u" + i, "u" + i));
    	}
    	return tokens;
    }

	public String registerAndLoginPlayer() {
		UserWrapper player = new UserWrapperBuilder().build();
        new RestBuilder<Object>(URL).path(Uris.USERS).body(player).post().build();
        TokenWrapper token = new RestBuilder<TokenWrapper>(URL).path(Uris.TOKENS).basicAuth(player.getUserName(), player.getPassword())
                .clazz(TokenWrapper.class).post().build();
        return token.getToken();
	}
	
	public void sendVideo(String tokenValue, VideoWrapper videoWrapper) {
		new RestBuilder<Object>(URL).path(Uris.VIDEOS).body(videoWrapper).basicAuth(tokenValue, "").post().build();
	}

	public void createSomeBattleChallenges(int size, String tokenValue, String playerChallenged, String suffix) {
		BattleChallengeWrapper battleChallengeWrapper;
		for (int i = 0; i < size; i++) {
			battleChallengeWrapper = new BattleChallengeWrapper("title" + suffix + i, "description" + suffix + i, "youtubeUrl" + suffix + i, playerChallenged);
			new RestBuilder<BattleWrapper>(RestService.URL).path(Uris.BATTLES + Uris.CHALLENGE).body(battleChallengeWrapper).basicAuth(tokenValue, "").clazz(BattleWrapper.class).post().build();
		}
	}

    public void deleteAll() {
    	new RestBuilder<TokenWrapper>(RestService.URL).path(Uris.ADMINS).basicAuth(this.loginUser("admin", "admin"), "").delete().build();
    }

}
