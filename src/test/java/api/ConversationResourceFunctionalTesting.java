package api;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import business.api.Uris;
import business.wrapper.ConversationWrapper;
import business.wrapper.MessageInputWrapper;

public class ConversationResourceFunctionalTesting {
	
	RestService restService = new RestService();
	
	@Test
	public void testConversation() {
		
		restService.registerSomePLayers(3);
		List<String> tokens = restService.loginSomePlayers(3);
		
		ConversationWrapper conversation1 = new RestBuilder<ConversationWrapper>(RestService.URL).path(Uris.CONVERSATIONS).param("conversationalist", "u2").basicAuth(tokens.get(0), "").clazz(ConversationWrapper.class).get().build();
		ConversationWrapper conversation2 = new RestBuilder<ConversationWrapper>(RestService.URL).path(Uris.CONVERSATIONS).param("conversationalist", "u3").basicAuth(tokens.get(0), "").clazz(ConversationWrapper.class).get().build();
		
		new RestBuilder<Object>(RestService.URL).path(Uris.CONVERSATIONS + Uris.MESSAGE).body(new MessageInputWrapper(conversation1.getConversationId(), "Hola")).basicAuth(tokens.get(0), "").post().build();
		new RestBuilder<Object>(RestService.URL).path(Uris.CONVERSATIONS + Uris.MESSAGE).body(new MessageInputWrapper(conversation1.getConversationId(), "Hola, ¿qué tal?")).basicAuth(tokens.get(1), "").post().build();
		new RestBuilder<Object>(RestService.URL).path(Uris.CONVERSATIONS + Uris.MESSAGE).body(new MessageInputWrapper(conversation1.getConversationId(), "Yo bien, ¿tú?")).basicAuth(tokens.get(0), "").post().build();
		new RestBuilder<Object>(RestService.URL).path(Uris.CONVERSATIONS + Uris.MESSAGE).body(new MessageInputWrapper(conversation1.getConversationId(), "Bien, gracias!")).basicAuth(tokens.get(1), "").post().build();

		new RestBuilder<Object>(RestService.URL).path(Uris.CONVERSATIONS + Uris.MESSAGE).body(new MessageInputWrapper(conversation2.getConversationId(), "¿De dónde eres?")).basicAuth(tokens.get(2), "").post().build();
		new RestBuilder<Object>(RestService.URL).path(Uris.CONVERSATIONS + Uris.MESSAGE).body(new MessageInputWrapper(conversation2.getConversationId(), "Madrid")).basicAuth(tokens.get(0), "").post().build();
		
		conversation1 = new RestBuilder<ConversationWrapper>(RestService.URL).path(Uris.CONVERSATIONS).param("conversationalist", "u2").basicAuth(tokens.get(0), "").clazz(ConversationWrapper.class).get().build();
		conversation2 = new RestBuilder<ConversationWrapper>(RestService.URL).path(Uris.CONVERSATIONS).param("conversationalist", "u3").basicAuth(tokens.get(0), "").clazz(ConversationWrapper.class).get().build();

		assertEquals(conversation1.getMessages().size(), 4);
		assertEquals(conversation2.getMessages().size(), 2);
		assertEquals(conversation1.getMessages().get(0).getMessage(), "Hola");
		assertEquals(conversation2.getMessages().get(1).getMessage(), "Madrid");
		
	}
	
	@After
    public void deleteAll() {
        new RestService().deleteAll();
    }

}
