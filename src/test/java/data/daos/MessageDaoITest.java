package data.daos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class MessageDaoITest {

	@Autowired
	private ConversationDao conversationDao;
	
	@Autowired
	private MessageDao messageDao;

	@Autowired
    private DaosService daosService;
	
	@Test
	public void findByConversationTest() {
		int conversation1 = daosService.createConversation("u1", "u2"),
			conversation2 = daosService.createConversation("u1", "u3");
		daosService.sendMessage("u1", "hola", conversation1);
		daosService.sendMessage("u1", "Qué tal?", conversation1);
		daosService.sendMessage("u2", "Bien! tú?", conversation1);
		daosService.sendMessage("u1", "Bien, gracias!", conversation1);
		daosService.sendMessage("u1", "hola", conversation2);
		daosService.sendMessage("u3", "hola", conversation2);
		daosService.sendMessage("u3", "... y adiós", conversation2);
		assertEquals(messageDao.findByConversation(conversationDao.findOne(conversation1)).size(), 4);
		assertEquals(messageDao.findByConversation(conversationDao.findOne(conversation2)).size(), 3);
	}

}
