package SpringSemester.budgetsystem.dao;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserInfo;
import SpringSemester.budgetsystem.beans.UserLogin;

public interface UserManagementDao {

	public SessionInfo getUserLoginData(UserLogin login);
	public boolean addNewUser(UserInfo userdata);
	public UserInfo getUserProfile(SessionInfo session);
	public boolean updateUserProfile(SessionInfo session, UserInfo userdata);
	public boolean deleteUserProfile(SessionInfo session);
}
