package SpringSemester.budgetsystem.services;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserInfo;
import SpringSemester.budgetsystem.beans.UserLogin;

public interface UserManagementServices {

	public SessionInfo validateUser(UserLogin login);
	public UserInfo displayProfile(SessionInfo session);
	
}
