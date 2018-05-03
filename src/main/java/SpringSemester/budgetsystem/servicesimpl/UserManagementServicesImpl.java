package SpringSemester.budgetsystem.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserInfo;
import SpringSemester.budgetsystem.beans.UserLogin;
import SpringSemester.budgetsystem.dao.UserManagementDao;
import SpringSemester.budgetsystem.services.UserManagementServices;
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

@Service("usermanagementservice")
public class UserManagementServicesImpl implements UserManagementServices {

	@Autowired
	UserManagementDao usermanagementdao;
	
	public UserManagementServicesImpl() {
	System.out.println("User manager services -- started()");
	}
	
	@Override
	public SessionInfo validateUser(UserLogin login) {
		SessionInfo session = usermanagementdao.getUserLoginData(login); 
		return session;
	}

	@Override
	public UserInfo displayProfile(SessionInfo session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addNewUser(UserInfo info) {
		
		String userid = ApplicationUtilities.getRandomUserID(info.getUser_fname(),info.getUser_lname());
		
		info.setUser_id(userid);
		info.setProfile_creation_date( ApplicationUtilities.getCurrentDate());
		info.setStatus(ApplicationUtilities.ACTIVE_STATUS);
		info.setLast_log_time(ApplicationUtilities.getCurrentDateAndTime());
		info.setUser_type("GNUSR");
		boolean result=usermanagementdao.addNewUser(info);
		if(result) {
			return userid;
		}
		return null;
	}

	@Override
	public UserInfo updateProfile(UserInfo userInfo, SessionInfo session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean closeProfile(SessionInfo session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetPassword(SessionInfo session) {
		// TODO Auto-generated method stub
		return false;
	}

}
