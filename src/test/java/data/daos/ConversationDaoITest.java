package data.daos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import data.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class ConversationDaoITest {
	
	@Autowired
    private DaosService daosService;
	
	@Autowired
	private ConversationDao conversationDao;
	
	@Test
	public void findByPlayersOrderByIdTest() {
		daosService.createConversation("u1", "u2");
		daosService.createConversation("u1", "u3");
		daosService.createConversation("u1", "u4");
		daosService.createConversation("u2", "u4");
		assertEquals(conversationDao.findByPlayersOrderById((User) daosService.getMap().get("u1")).size(), 3);
		assertEquals(conversationDao.findByPlayersOrderById((User) daosService.getMap().get("u2")).size(), 2);
		assertEquals(conversationDao.findByPlayersOrderById((User) daosService.getMap().get("u3")).size(), 1);
		assertEquals(conversationDao.findByPlayersOrderById((User) daosService.getMap().get("u4")).size(), 2);
	}

}
