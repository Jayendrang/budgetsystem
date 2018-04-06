package SpringSemester.budgetsystem.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserInfo;
import SpringSemester.budgetsystem.beans.UserLogin;
import SpringSemester.budgetsystem.dao.UserManagementDao;
import SpringSemester.budgetsystem.services.UserManagementServices;

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

}
