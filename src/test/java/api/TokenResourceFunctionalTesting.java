package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import business.api.Uris;

public class TokenResourceFunctionalTesting {

    @Test
    public void testLoginPlayer() {
        String token = new RestService().registerAndLoginPlayer();
        assertTrue(token.length() > 20);
        LogManager.getLogger(this.getClass()).info("testLoginPlayer (token:" + token + ")");
    }
    
    @Test
    public void testLogoutPlayer() {
    	String token = new RestService().registerAndLoginPlayer();
		new RestService().loginUser(token, "");
    	new RestBuilder<Object>(RestService.URL).path(Uris.TOKENS).basicAuth(token, "").delete().build();
    	try {
    		new RestService().loginUser(token, "");
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
