package data.daos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.entities.Authorization;
import data.entities.Battle;
import data.entities.Conversation;
import data.entities.Message;
import data.entities.Role;
import data.entities.Token;
import data.entities.User;
import data.entities.Video;
import data.services.DataService;

@Service
public class DaosService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private TokenDao tokenDao;
    
    @Autowired
    private VideoDao videoDao;
    
    @Autowired
    private BattleDao battleDao;
    
    @Autowired
    private ConversationDao conversationDao;
    
    @Autowired
    private MessageDao messageDao;

    @Autowired
    private AuthorizationDao authorizationDao;

    @Autowired
    private DataService genericService;

    private Map<String, Object> map;

    @PostConstruct
    public void populate() {
    	map = new HashMap<>();
        User[] players = this.createUser(0, 6, Role.PLAYER);
        putOnMapWithToken(players);
    }

	public void putOnMapWithToken(User[] users) {
    	
        for (User user : users) {
            map.put(user.getUserName(), user);
        }
        for (Token token : this.createTokens(users)) {
            map.put("t" + token.getUser().getUserName(), token);
        }
    }

    public User[] createUser(int initial, int size, Role role) {
        User[] users = new User[size];
        for (int i = 0; i < size; i++) {
            users[i] = new User("u" + (i + initial), "u" + (i + initial) + "@gmail.com", "p", Calendar.getInstance(), 2012, "");
            userDao.save(users[i]);
            authorizationDao.save(new Authorization(users[i], role));
        }
        return users;
    }
    
    public List<Token> createTokens(User[] users) {
        List<Token> tokenList = new ArrayList<>();
        Token token;
        for (User user : users) {
            token = new Token(user);
            tokenDao.save(token);
            tokenList.add(token);
        }
        return tokenList;
    }
    
    public void saveVideo(String userName, String videoSuffix) {
    	videoDao.save(new Video((User) getMap().get(userName), "title" + videoSuffix, "place" + videoSuffix, "url" + videoSuffix));
    }
    
    public void battleChallenge(String userNameChallenger, String userNameChallenged, String battleSuffix) {
    	List<User> players = new ArrayList<User>();
    	players.add((User) getMap().get(userNameChallenger));
    	players.add((User) getMap().get(userNameChallenged));
    	battleDao.save(new Battle("title" + battleSuffix, "description" + battleSuffix, players, "youtubeUrlChallenger" + battleSuffix));
    }
    
    public int createConversation(String conversationalist1, String conversationalist2) {
    	List<User> players = new ArrayList<User>();
    	players.add((User) getMap().get(conversationalist1));
    	players.add((User) getMap().get(conversationalist2));
    	return conversationDao.save(new Conversation(players)).getId();
    }
    
    public void sendMessage(String userNameWriter, String message, int conversation) {
    	messageDao.save(new Message(userNameWriter, message, conversationDao.findOne(conversation)));
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void deleteAll() {
        genericService.deleteAllExceptAdmin();
    }
}
