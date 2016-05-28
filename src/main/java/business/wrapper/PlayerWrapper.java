package business.wrapper;

import java.util.Calendar;

public class PlayerWrapper {
	
	private String userName;
	
	private Calendar age;
	
	private int startingYear;
	
	private String summary;

	public PlayerWrapper() {
		
	}

	public PlayerWrapper(String userName, Calendar age, int startingYear, String summary) {
		this.userName = userName;
		this.age = age;
		this.startingYear = startingYear;
		this.summary = summary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Calendar getAge() {
		return age;
	}

	public void setAge(Calendar age) {
		this.age = age;
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
		return "PlayerWrapper [userName=" + userName + ", age=" + age + ", startingYear=" + startingYear + ", summary="
				+ summary + "]";
	}

}
