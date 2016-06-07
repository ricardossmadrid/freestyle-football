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
public class VideoDaoITest {
	
	@Autowired
	private VideoDao videoDao;
	
	@Autowired
    private DaosService daosService;
	
	@Test
	public void findByPlayerTest() {
		daosService.saveVideo("u1", "1");
		daosService.saveVideo("u1", "2");
		daosService.saveVideo("u2", "3");
		assertEquals(2, videoDao.findByPlayerOrderBySendTimeDesc((User) daosService.getMap().get("u1")).size());
		assertEquals(1, videoDao.findByPlayerOrderBySendTimeDesc((User) daosService.getMap().get("u2")).size());
	}

}
