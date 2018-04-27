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
		System.out.println("service"+session.getUserName());
		return session;
	}

	@Override
	public UserInfo displayProfile(SessionInfo session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addNewUser(UserInfo info) {
		
		info.setUser_id(ApplicationUtilities.getRandomUserID(info.getUser_fname(),info.getUser_lname()));
		info.setProfile_creation_date( ApplicationUtilities.getCurrentDate());
		info.setStatus(ApplicationUtilities.ACTIVE_STATUS);
		info.setLast_log_time(ApplicationUtilities.getCurrentDateAndTime());
		info.setUser_type("GNUSR");
		
		return usermanagementdao.addNewUser(info);
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
