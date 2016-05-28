package business.wrapper;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class UserWrapperBuilder {

    private UserWrapper userWrapper;

    public UserWrapperBuilder(int suffix) {
        userWrapper = new UserWrapper("u" + suffix, "u" + suffix + "@gmail.com", "u" + suffix, new GregorianCalendar(1990, 01, 14), 
        		2012, "Blablablabla");
    }

    public UserWrapperBuilder() {
        this(0);
    }

    public UserWrapperBuilder username(String username) {
        userWrapper.setUserName(username);
        return this;
    }

    public UserWrapperBuilder email(String email) {
        userWrapper.setEmail(email);
        return this;
    }

    public UserWrapperBuilder password(String password) {
        userWrapper.setPassword(password);
        return this;
    }

    public UserWrapperBuilder birthDate(Calendar birthDate) {
        userWrapper.setBirthDate(birthDate);
        return this;
    }

    public UserWrapper build() {
        return userWrapper;
    }

}
