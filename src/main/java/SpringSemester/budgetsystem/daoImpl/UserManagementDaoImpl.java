package SpringSemester.budgetsystem.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserInfo;
import SpringSemester.budgetsystem.beans.UserLogin;
import SpringSemester.budgetsystem.dao.UserManagementDao;

@Repository
@Qualifier("usermanagementdao")
public class UserManagementDaoImpl implements UserManagementDao {

	@Autowired
	JdbcTemplate template;
	
	public UserManagementDaoImpl() {
	
	System.out.println("User managemetn Dao Impl -- started()");
	}
	
	@Override
	public SessionInfo getUserLoginData(UserLogin login) {
		SessionInfo session;
		try {
			String searchQuery = "select user_id,user_first_name,user_lastname from user_information where user_id=? and password=?";
		    session = (SessionInfo) template.queryForObject(searchQuery,new Object[] {login.getUsername(),login.getPassword()},new LoginDataMapper());
			return session;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNewUser(UserInfo userdata) {
		// TODO Auto-generated method stub
		return false;
	}

	
	class LoginDataMapper implements org.springframework.jdbc.core.RowMapper<SessionInfo>{

		@Override
		public SessionInfo mapRow(ResultSet resultset, int arg1) throws SQLException {
			System.out.println("inside result set");
			SessionInfo session = new SessionInfo();
			UserLogin info = new UserLogin();
			info.setUsername(resultset.getString("user_id"));
			session.setLoginUser(info);
			session.setFname(resultset.getString("user_first_name"));
			session.setLname(resultset.getString("user_lastname"));
			System.out.println(session.getFname());
			System.out.println(session.getLname());
			
			return session;
		}
		
		
		
	}
	
}

