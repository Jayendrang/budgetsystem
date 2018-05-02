package SpringSemester.budgetsystem.services;

import java.util.List;

import SpringSemester.budgetsystem.beans.UserEvent;
import SpringSemester.budgetsystem.beans.SessionInfo;

public interface UserEventReminderService {

	public boolean addNewReminder(List<UserEvent> reminder, SessionInfo session);
	public boolean modifyReminder(UserEvent reminder, SessionInfo session);
	public boolean deleteReminder(UserEvent reminder, SessionInfo session);
	public List<UserEvent> getAllReminder(SessionInfo session);
	
}
