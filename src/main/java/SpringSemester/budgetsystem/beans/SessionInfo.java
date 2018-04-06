package SpringSemester.budgetsystem.beans;

import SpringSemester.budgetsystem.beans.UserLogin;

public class SessionInfo {

	private String sessionId,userName,fname,lname;
	private UserLogin loginUser;

	public SessionInfo() {
		
			System.out.println("Bean Session Info -- Loaded()");
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public  String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserLogin getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(UserLogin loginUser) {
		this.loginUser = loginUser;
	}	
}
