package data.daos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TokenDaoITest.class,
    UserDaoITest.class,
    AuthorizationDaoITest.class,
    VideoDaoITest.class,
    BattleDaoITest.class,
    ConversationDaoITest.class,
    MessageDaoITest.class
})
public class AllDaosITests {

}
