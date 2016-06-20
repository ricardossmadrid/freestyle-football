package api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	UserResourceFunctionalTesting.class, 
    TokenResourceFunctionalTesting.class,
    PlayerResourceFunctionalTesting.class,
    VideoResourceFunctionalTesting.class,
    BattleResourceFunctionalTesting.class,
    ConversationResourceFunctionalTesting.class
})
public class AllFunctionalTesting {

}
