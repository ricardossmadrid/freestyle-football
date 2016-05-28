package data.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
	
	@Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private Calendar birthDate;
    
    private int startingYear;
    
    private String summary;
    
    public User() {
    }

	public User(String userName, String email, String password, Calendar birthDate, int startingYear, String summary) {
		this.userName = userName;
		this.email = email;
		this.password = new BCryptPasswordEncoder().encode(password);
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

	public int getId() {
		return id;
	}
	
	@Override
    public int hashCode() {
        return id;
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return id == ((User) obj).id;
    }

	@Override
	public String toString() {
        String date = new SimpleDateFormat("dd-MMM-yyyy ").format(birthDate.getTime());
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", birthDate=" + date + ", startingYear=" + startingYear + ", summary=" + summary
				+ "]";
	}
	
	

}
