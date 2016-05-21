package data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.daos.AuthorizationDao;
import data.daos.UserDao;

@Service
public class DataService {
    
    @Autowired
    private AuthorizationDao authorizationDao;
    
    @Autowired
    private UserDao userDao;
    

    public void deleteAllExceptAdmin(){
        authorizationDao.deleteAll();
        userDao.deleteAll();
    }

}
