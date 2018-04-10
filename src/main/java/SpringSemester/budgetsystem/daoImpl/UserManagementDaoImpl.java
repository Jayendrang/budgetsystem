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
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

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
	
		try {
			String newUserInsertQuery="insert into user_information"
					+ "(user_id,user_first_name,user_lastname,user_type,email_id,"
					+ "mobile_contact,password,address,profile_creation_date,reset_temp_password,"
					+ "recovery_question_1,recovery_answer_1,recovery_question_2,recovery_answer_2,"
					+ "last_login_datetime,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			System.out.println("mobile contact"+userdata.getMobile_contact().length());
		
			int count = template.update(newUserInsertQuery, new Object[] {
					userdata.getUser_id(),
					userdata.getUser_fname(),
					userdata.getUser_lname(),
					userdata.getUser_type(),
					userdata.getEmail_id(),
					userdata.getMobile_contact().trim(),
					userdata.getPassword(),
					userdata.getAddress(),
					userdata.getProfile_creation_date(),
					userdata.getUser_temp_password(),
					userdata.getRec1_ques(),
					userdata.getRec1_ans(),
					userdata.getRec2_ques(),
					userdata.getRec2_ans(),
					userdata.getLast_log_time(),
					userdata.getStatus()});
			if(count>0) {
				return true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
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

