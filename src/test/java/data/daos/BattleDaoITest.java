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
public class BattleDaoITest {
	
	@Autowired
	private BattleDao battleDao;
	
	@Autowired
    private DaosService daosService;
	
	@Test
	public void findByPlayersOrderByBattleChallengeTimeDescTest() {
		daosService.battleChallenge("u1", "u2", "1");
		daosService.battleChallenge("u1", "u2", "2");
		daosService.battleChallenge("u2", "u3", "3");
		daosService.battleChallenge("u2", "u1", "4");
		daosService.battleChallenge("u2", "u4", "5");
		assertEquals(5, battleDao.findByPlayersOrderByBattleChallengeTimeDesc((User) daosService.getMap().get("u2")).size());
		assertEquals(3, battleDao.findByPlayersOrderByBattleChallengeTimeDesc((User) daosService.getMap().get("u1")).size());
	}

}
