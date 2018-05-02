package SpringSemester.budgetsystem.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SpringSemester.budgetsystem.beans.UserEvent;
import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

@Repository
@Qualifier("eventreminder")
public class EventReminderDaoImpl implements SpringSemester.budgetsystem.dao.UserEventReminderDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public EventReminderDaoImpl() {
	}

	@Override
	public boolean insertNewUserEvent(List<UserEvent> reminder, SessionInfo session) {
		int rowcount = 0;
		boolean status = false;

		try {
			String insertQuery = "insert into scheduled_event_details (event_id,user_id,event_desc,event_start_date,created_on) values (?,?,?,?,?)";
			for (UserEvent userEvent : reminder) {
				rowcount = +jdbcTemplate.update(insertQuery,
						new Object[] { ApplicationUtilities.getReminderID(), session.getUserName(),
								userEvent.getEvent_desc(), userEvent.getEvent_start_date(),
								ApplicationUtilities.getCurrentDate() });
			}
			status = rowcount > 0 ? true : false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	@Override
	public boolean updateReminderEvent(UserEvent reminder, SessionInfo session) {
		int rowcount = 0;
		boolean status = false;
		try {
			String updateQuery = "update scheduled_event_details set event_desc=?,event_start_date=?,created_on=? where user_id=? and event_id=?";
			rowcount = jdbcTemplate.update(updateQuery,
					new Object[] { reminder.getEvent_desc(), reminder.getEvent_start_date(),
							ApplicationUtilities.getCurrentDate(), session.getUserName(), reminder.getEventid() });
			status = rowcount > 0 ? true : false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	@Override
	public boolean deleteReminderEvent(UserEvent reminder, SessionInfo session) {
		int rowcount = 0;
		boolean status = false;
		try {
			String deleteQuery = "delete from scheduled_event_details where user_id=? and event_id=?";
			rowcount = jdbcTemplate.update(deleteQuery, new Object[] { session.getUserName(), reminder.getEventid() });
			status = rowcount > 0 ? true : false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	@Override
	public List<UserEvent> getAllUserEvents(SessionInfo session) {
		List<UserEvent> userReminders = new ArrayList<>();
		try {
			String selectQuery = "select event_id,user_id,event_desc,event_start_date,created_on from scheduled_event_details where user_id=?";
			userReminders = jdbcTemplate.queryForObject(selectQuery, new Object[] { session.getUserName() },
					new ReminderDataMapper());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return userReminders;
	}

	class ReminderDataMapper implements RowMapper<List<UserEvent>> {

		private List<UserEvent> userReminders = new ArrayList<>();

		public List<UserEvent> mapRow(ResultSet result, int arg1) throws SQLException {
			if (result.first()) {
				do {
					UserEvent reminder = new UserEvent();
					reminder.setEventid(result.getString("event_id"));
					reminder.setUserid(result.getString("user_id"));
					reminder.setEvent_start_date(result.getString("event_start_date"));
					reminder.setEvent_desc(result.getString("event_desc"));
					reminder.setCreated_on(result.getString("created_on"));
					userReminders.add(reminder);
				} while (result.next());
			}
			return userReminders;

		}

	}
}
