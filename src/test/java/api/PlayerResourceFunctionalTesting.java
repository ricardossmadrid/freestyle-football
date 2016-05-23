package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import business.api.Uris;
import business.wrapper.PlayerWrapper;

public class PlayerResourceFunctionalTesting {
	
	private String token;
	
	@Before
	public void createUser() {
		token = new RestService().registerAndLoginPlayer();
	}
	
	@Test
	public void showUserTest() {
		PlayerWrapper player = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).basicAuth(token, "").clazz(PlayerWrapper.class).get().build();
		assertEquals(player.getUserName(), "u0");
	}
	
	@Test
	public void noAuthenticatedRequest() {
		try {
			new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).clazz(PlayerWrapper.class).get().build();
			fail();
		} catch (HttpClientErrorException httpError) {
			assertEquals(HttpStatus.UNAUTHORIZED, httpError.getStatusCode());
		}
	}
	
	@After
    public void deleteAll() {
        new RestService().deleteAll();
    }

}
