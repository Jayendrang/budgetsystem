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
			String searchQuery = "select user_id,user_first_name,user_lastname from user_information where user_id=? and password=? and status=?";
			session = (SessionInfo) template.queryForObject(searchQuery,
					new Object[] { login.getUsername(), login.getPassword(),ApplicationUtilities.ACTIVE_STATUS }, new LoginDataMapper());
			return session;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNewUser(UserInfo userdata) {

		try {
			String newUserInsertQuery = "insert into user_information"
					+ "(user_id,user_first_name,user_lastname,user_type,email_id,"
					+ "mobile_contact,password,address,profile_creation_date,reset_temp_password,"
					+ "recovery_question_1,recovery_answer_1,recovery_question_2,recovery_answer_2,"
					+ "last_login_datetime,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			System.out.println("mobile contact" + userdata.getMobile_contact().length());

			int count = template.update(newUserInsertQuery,
					new Object[] { userdata.getUser_id(), userdata.getUser_fname(), userdata.getUser_lname(),
							userdata.getUser_type(), userdata.getEmail_id(), userdata.getMobile_contact().trim(),
							userdata.getPassword(), userdata.getAddress(), userdata.getProfile_creation_date(),
							userdata.getUser_temp_password(), userdata.getRec1_ques(), userdata.getRec1_ans(),
							userdata.getRec2_ques(), userdata.getRec2_ans(), userdata.getLast_log_time(),
							userdata.getStatus() });
			if (count > 0) {
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	@Override
	public UserInfo getUserProfile(SessionInfo session) {
		String selectQuery = "select user_first_name,user_lastname,email_id,mobile_contact,password,address,"
				+ "recovery_question_1,recovery_answer_1,recovery_question_2,recovery_answer_2 from user_information"
				+ " where"
				+ " user_id=?";
		try {
		UserInfo userInfo = template.queryForObject(selectQuery, new Object[] { session.getUserName() },
				new UserProfileDataMapper());
		if (!userInfo.equals(null)) {
			return userInfo;
		}}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUserProfile(SessionInfo session,UserInfo userdata) {
		String updateQuery = "update user_information set email_id=?,mobile_contact=?,password=?,address=?,"
				+ "recovery_question_1=?,recovery_answer_1=?,recovery_question_2=?,recovery_answer_2=? "
				+ "where user_id=?";
		boolean result=false;
		try {
			int count = template.update(updateQuery,new Object[] {
					userdata.getEmail_id(),
					userdata.getMobile_contact(),
					userdata.getPassword(),
					userdata.getAddress(),
					userdata.getRec1_ques(),
					userdata.getRec1_ans(),
					userdata.getRec2_ques(),
					userdata.getRec2_ans(),
					session.getUserName()
					});
			result = count>0?true:false;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteUserProfile(SessionInfo session) {
		String deleteQuery = "update user_information set status=? where user_id=?";
		boolean result=false;
		try {
			int count = template.update(deleteQuery,new Object[] {ApplicationUtilities.INACTIVE_STATUS,session.getUserName()});
			result=count>0?true:false;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	class UserProfileDataMapper implements org.springframework.jdbc.core.RowMapper<UserInfo> {
		public UserInfo mapRow(ResultSet resultset, int arg1) throws SQLException {
			UserInfo userInfo = new UserInfo();
			while (resultset.next()) {
				userInfo.setUser_fname(resultset.getString("user_frist_name"));
				userInfo.setUser_lname(resultset.getString("user_lastname"));
				userInfo.setEmail_id(resultset.getString("email_id"));
				userInfo.setMobile_contact(resultset.getString("mobile_contact"));
				userInfo.setPassword(resultset.getString("password"));
				userInfo.setAddress(resultset.getString("address"));
				userInfo.setRec1_ques(resultset.getString("recovery_question_1"));
				userInfo.setRec1_ans(resultset.getString("recovery_answer_1"));
				userInfo.setRec2_ques(resultset.getString("recovery_question_2"));
				userInfo.setRec2_ans(resultset.getString("recovery_answer_2"));
			}

			return userInfo;
		}

	}

	class LoginDataMapper implements org.springframework.jdbc.core.RowMapper<SessionInfo> {

		@Override
		public SessionInfo mapRow(ResultSet resultset, int arg1) throws SQLException {
			System.out.println("inside result set");
			SessionInfo session = new SessionInfo();
			UserLogin info = new UserLogin();
			info.setUsername(resultset.getString("user_id"));
			session.setLoginUser(info);
			session.setSessionId(resultset.getString("user_id"));
			session.setFname(resultset.getString("user_first_name"));
			session.setLname(resultset.getString("user_lastname"));

			return session;
		}

	}
}
