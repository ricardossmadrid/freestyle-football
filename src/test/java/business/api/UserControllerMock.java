package business.api;

import java.io.File;
import java.util.Calendar;

import business.controllers.UserController;
import business.wrapper.UserWrapper;

public class UserControllerMock extends UserController {

    private UserWrapper userWrapper= new UserWrapper("", "", "", Calendar.getInstance(), 0, "", new File("/home/ricardoss/Escritorio/Freestyle football/MagicDraw/Pantallazos/batalla.png"));

    @Override
    public boolean registration(UserWrapper userWrapper) {
        boolean result = !this.userWrapper.getUserName().equals(userWrapper.getUserName()) && !this.userWrapper.getEmail().equals(userWrapper.getEmail());
        this.userWrapper = userWrapper;
        return result;
    }

    public UserWrapper getUserWrapper() {
        return userWrapper;
    }

    public void setUserWrapper(UserWrapper userWrapper) {
        this.userWrapper = userWrapper;
    }

}
