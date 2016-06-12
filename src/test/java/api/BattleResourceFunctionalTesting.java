package api;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import business.api.Uris;
import business.wrapper.PlayerWrapper;

public class BattleResourceFunctionalTesting {
	
	public static final int NUM_BATTLES = 4;
	
	RestService restService = new RestService();
	
	@Test
	public void testBattleChallenge() {
		restService.registerSomePLayers(3);
		List<String> tokens = restService.loginSomePlayers(3);
		
		PlayerWrapper player1 = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).param("playerName", "").basicAuth(tokens.get(0), "").clazz(PlayerWrapper.class).get().build();
		assertEquals(0, player1.getBattles().size());
		
		restService.createSomeBattleChallenges(2, tokens.get(0), "u2", "1");
		restService.createSomeBattleChallenges(3, tokens.get(0), "u3", "2");
		restService.createSomeBattleChallenges(2, tokens.get(1), "u1", "3");
		
		player1 = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).param("playerName", "").basicAuth(tokens.get(0), "").clazz(PlayerWrapper.class).get().build();
		assertEquals(7, player1.getBattles().size());
		
		PlayerWrapper player2 = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).param("playerName", "").basicAuth(tokens.get(1), "").clazz(PlayerWrapper.class).get().build();
		assertEquals(4, player2.getBattles().size());
	}
	
	@After
    public void deleteAll() {
        new RestService().deleteAll();
    }

}