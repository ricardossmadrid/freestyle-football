package api;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import business.api.Uris;
import business.wrapper.PlayerWrapper;
import business.wrapper.VideoWrapper;

public class VideoResourceFunctionalTesting {
	
	RestService restService = new RestService();
	
	@Test
	public void testSendVideo() {
		String tokenValue = restService.loginUser("player", "player");
		PlayerWrapper player = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).param("playerName", "player").basicAuth(tokenValue, "").clazz(PlayerWrapper.class).get().build();
		assertEquals(0, player.getVideos().size());
		restService.sendVideo(tokenValue, new VideoWrapper("title1", "place1", "url1"));
		player = new RestBuilder<PlayerWrapper>(RestService.URL).path(Uris.PLAYERS).param("playerName", "player").basicAuth(tokenValue, "").clazz(PlayerWrapper.class).get().build();
		assertEquals(1, player.getVideos().size());
	}
	
	@After
    public void deleteAll() {
        new RestService().deleteAll();
    }

}
