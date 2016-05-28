package business.wrapper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserWrapper {
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private Calendar birthDate;
	
	private int startingYear;
	
	private String summary;

	public UserWrapper() {
	}

	public UserWrapper(String userName, String email, String password, Calendar birthDate, int startingYear,
			String summary) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.startingYear = startingYear;
		this.summary = summary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public int getStartingYear() {
		return startingYear;
	}

	public void setStartingYear(int startingYear) {
		this.startingYear = startingYear;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		String time = null;
		if (this.birthDate != null)
			time = new SimpleDateFormat("dd-MMM-yyyy ").format(this.birthDate.getTime());
		return "UserWrapper [userName=" + userName + ", email=" + email + ", password=" + password + ", birthDate="
				+ time + ", startingYear=" + startingYear + ", summary=" + summary + "]";
	}

	

}
