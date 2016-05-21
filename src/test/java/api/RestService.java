package api;

import business.api.Uris;
import business.wrapper.TokenWrapper;
import business.wrapper.UserWrapper;
import business.wrapper.UserWrapperBuilder;

public class RestService {

    public static final String URL = "http://localhost:8080/freestyle-football.0.0.1-SNAPSHOT" + Uris.SERVLET_MAP;

	public String registerAndLoginPlayer() {
		UserWrapper player = new UserWrapperBuilder().build();
        new RestBuilder<Object>(URL).path(Uris.USERS).body(player).post().build();
        TokenWrapper token = new RestBuilder<TokenWrapper>(URL).path(Uris.TOKENS).basicAuth(player.getUserName(), player.getPassword())
                .clazz(TokenWrapper.class).post().build();
        return token.getToken();
	}

    public void deleteAll() {
        
    }

}
