package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import business.api.Uris;
import business.controllers.PlayerController;
import business.wrapper.PlayerWrapper;

public class PlayerResourceFunctionalTesting {
	
	RestService restService = new RestService();
	
	private String token;
	
	@Before
	public void createUser() {
		token = new RestService().registerAndLoginPlayer();
	}
	
	@Test
	public void showUserTest() {
		PlayerWrapper player = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).param("playerName", "u0").basicAuth(token, "").clazz(PlayerWrapper.class).get().build();
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
	
	@Test
	public void getSuggestionsNamesTest() {
		restService.registerSomePLayers(6);
		List<String> suggestedUserNames = Arrays.asList(new RestBuilder<String[]>(RestService.URL).path(Uris.PLAYERS + Uris.SUGGESTIONS).param("playerName", "u").basicAuth(token, "").clazz(String[].class).get().build());
		assertTrue(suggestedUserNames.size() <= PlayerController.MAX_SUGGESTIONS);
		suggestedUserNames = Arrays.asList(new RestBuilder<String[]>(RestService.URL).path(Uris.PLAYERS + Uris.SUGGESTIONS).param("playerName", "Z").basicAuth(token, "").clazz(String[].class).get().build());
		assertEquals(suggestedUserNames.size(), 0);
	}
	
	@After
    public void deleteAll() {
        new RestService().deleteAll();
    }

}
