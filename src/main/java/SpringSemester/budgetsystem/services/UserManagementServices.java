package SpringSemester.budgetsystem.services;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserInfo;
import SpringSemester.budgetsystem.beans.UserLogin;

public interface UserManagementServices {

	public SessionInfo validateUser(UserLogin login);
	public String addNewUser(UserInfo info);
	public UserInfo displayProfile(SessionInfo session);
	public UserInfo updateProfile(UserInfo userInfo,SessionInfo session);
	public boolean closeProfile(SessionInfo session);
	public boolean resetPassword(SessionInfo session);
	
}
