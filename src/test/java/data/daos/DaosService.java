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
import data.entities.Role;
import data.entities.Token;
import data.entities.User;
import data.services.DataService;

@Service
public class DaosService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private AuthorizationDao authorizationDao;

    @Autowired
    private DataService genericService;

    private Map<String, Object> map;

    @PostConstruct
    public void populate() {
    	map = new HashMap<>();
        User[] players = this.createUser(0, 4, Role.PLAYER);
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

    public Map<String, Object> getMap() {
        return map;
    }

    public void deleteAll() {
        genericService.deleteAllExceptAdmin();
    }
}
