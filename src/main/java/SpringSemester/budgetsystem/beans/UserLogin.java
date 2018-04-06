package SpringSemester.budgetsystem.beans;


public class UserLogin {

	private String username,password,logintimestamp;

	
	public UserLogin() {
	System.out.println("Bean UserLogin -- Loaded()");
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogintimestamp() {
		return logintimestamp;
	}

	public void setLogintimestamp(String logintimestamp) {
		this.logintimestamp = logintimestamp;
	}
}
