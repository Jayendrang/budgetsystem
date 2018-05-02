package SpringSemester.budgetsystem.dao;

import java.util.List;

import SpringSemester.budgetsystem.beans.UserEvent;
import SpringSemester.budgetsystem.beans.SessionInfo;

public interface UserEventReminderDao {

	public boolean insertNewUserEvent(List<UserEvent> reminder, SessionInfo session);
	public boolean updateReminderEvent(UserEvent reminder, SessionInfo session);
	public boolean deleteReminderEvent(UserEvent reminder, SessionInfo session);
	public List<UserEvent> getAllUserEvents(SessionInfo session);
	
}
