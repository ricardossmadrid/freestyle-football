package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import business.api.Uris;
import business.wrapper.BattleResponseWrapper;
import business.wrapper.BattleVoteWrapper;
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
	
	@Test
	public void testBattleResponse() {
		restService.registerSomePLayers(2);
		List<String> tokens = restService.loginSomePlayers(2);
		
		restService.createSomeBattleChallenges(1, tokens.get(0), "u2", "1");
		
		PlayerWrapper playerChallenged = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).param("playerName", "").basicAuth(tokens.get(1), "").clazz(PlayerWrapper.class).get().build();
		
		assertNull(playerChallenged.getBattles().get(0).getYoutubeUrlChallenged());
		
		new RestBuilder<>(RestService.URL).path(Uris.BATTLES + Uris.RESPONSE).body(new BattleResponseWrapper(playerChallenged.getBattles().get(0).getId(), "youtubeUrl2"))
				.basicAuth(tokens.get(1), "").post().build();
		
		playerChallenged = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).param("playerName", "").basicAuth(tokens.get(1), "").clazz(PlayerWrapper.class).get().build();
		
		assertNotNull(playerChallenged.getBattles().get(0).getYoutubeUrlChallenged());
	}
	
	@Test
	public void testBattleVote() {
		restService.registerSomePLayers(3);
		List<String> tokens = restService.loginSomePlayers(3);
		
		restService.createSomeBattleChallenges(1, tokens.get(0), "u2", "1");
		
		PlayerWrapper playerChallenged = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).param("playerName", "").basicAuth(tokens.get(1), "").clazz(PlayerWrapper.class).get().build();
		
		assertEquals(playerChallenged.getWins(), 0);
		assertEquals(playerChallenged.getNumberOfBattles(), 1);
		
		new RestBuilder<>(RestService.URL).path(Uris.BATTLES + Uris.RESPONSE).body(new BattleResponseWrapper(playerChallenged.getBattles().get(0).getId(), "youtubeUrl2"))
				.basicAuth(tokens.get(1), "").post().build();
		
		new RestBuilder<>(RestService.URL).path(Uris.BATTLES + Uris.VOTE).body(new BattleVoteWrapper(playerChallenged.getBattles().get(0).getId(), "u2"))
				.basicAuth(tokens.get(2), "").post().build();
		
		playerChallenged = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).param("playerName", "").basicAuth(tokens.get(1), "").clazz(PlayerWrapper.class).get().build();
		
		assertEquals(playerChallenged.getWins(), 1);
		assertEquals(playerChallenged.getNumberOfBattles(), 1);
		
	}
	
	@After
    public void deleteAll() {
        new RestService().deleteAll();
    }

}