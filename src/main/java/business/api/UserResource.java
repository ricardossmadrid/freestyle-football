package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.AlreadyExistUserFieldException;
import business.api.exceptions.InvalidFieldException;
import business.controllers.UserController;
import business.wrapper.UserWrapper;
import data.services.DataService;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.USERS)
public class UserResource {
	
	private UserController userController;
	
	private DataService dataService;
	
	@Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }
	
	@Autowired
	public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

	@RequestMapping(method = RequestMethod.POST)
    public void registration(@RequestBody UserWrapper userWrapper) throws InvalidFieldException, AlreadyExistUserFieldException {
		dataService.validateField(userWrapper.getUserName(), "userName");
		dataService.validateField(userWrapper.getEmail(), "email");
		dataService.validateField(userWrapper.getPassword(), "password");
		dataService.validateField(userWrapper.getBirthDate(), "birthDate");
		dataService.validateField(Integer.toString(userWrapper.getStartingYear()), "startingYear");
		dataService.validateField(userWrapper.getSummary(), "summary");
        if (!this.userController.registration(userWrapper)) {
            throw new AlreadyExistUserFieldException();
        }
	}
}
