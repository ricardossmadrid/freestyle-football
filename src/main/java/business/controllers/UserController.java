package business.controllers;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrapper.UserWrapper;
import data.daos.AuthorizationDao;
import data.daos.UserDao;
import data.entities.Authorization;
import data.entities.Role;
import data.entities.User;

@Controller
public class UserController {
	
	private UserDao userDao;
	
	private AuthorizationDao authorizationDao;
	
	@Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
	
	@Autowired
	public void setAuthorizationDao(AuthorizationDao authorizationDao) {
		this.authorizationDao = authorizationDao;
	}

	public boolean registration(UserWrapper userWrapper) {
		if (null == userDao.findByUsernameOrEmail(userWrapper.getUserName())) {
            User user = new User(userWrapper.getUserName(), userWrapper.getEmail(), userWrapper.getPassword(), userWrapper.getBirthDate(), userWrapper.getStartingYear(), userWrapper.getSummary(), changeImageFormat(userWrapper.getProfilePicture()));
            userDao.save(user);
            authorizationDao.save(new Authorization(user, Role.PLAYER));
            return true;
        } else {
            return false;
        }
	}
	
	private byte[] changeImageFormat(File image) {
		
		FileInputStream fileInputStream=null;
	
		byte[] bImage = new byte[(int) image.length()];
        
        try {
        	fileInputStream = new FileInputStream(image);
        	fileInputStream.read(bImage);
        	fileInputStream.close();
        } catch(Exception e){
        	e.printStackTrace();
        }
        return bImage;
	}

}
