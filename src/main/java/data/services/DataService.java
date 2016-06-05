package data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.api.exceptions.InvalidFieldException;
import data.daos.AuthorizationDao;
import data.daos.TokenDao;
import data.daos.UserDao;
import data.entities.Role;

@Service
public class DataService {

    @Autowired
    private Populate populate;
    
    @Autowired
    private AuthorizationDao authorizationDao;
    
    @Autowired
    private TokenDao tokenDao;
    
    @Autowired
    private UserDao userDao;
    

    public void deleteAllExceptAdmin(){
        authorizationDao.deleteAll();
        tokenDao.deleteAll();
        userDao.deleteAll();
        populate.createDefaultUser("admin", Role.ADMIN);
        populate.createDefaultUser("player", Role.PLAYER);
    }
    
	public void validateField(Object field, String msg) throws InvalidFieldException {
        if (field == null || field.toString().isEmpty()) {
            throw new InvalidFieldException(msg);
        }
    }

}
