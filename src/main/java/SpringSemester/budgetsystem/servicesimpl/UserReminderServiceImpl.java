package SpringSemester.budgetsystem.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserEvent;
import SpringSemester.budgetsystem.dao.UserEventReminderDao;
import SpringSemester.budgetsystem.services.UserEventReminderService;

@Service("userreminderservice")
public class UserReminderServiceImpl implements UserEventReminderService{

	public UserReminderServiceImpl() {
		
	}
	@Autowired
	UserEventReminderDao userReminderDao;

	@Override
	public boolean addNewReminder(List<UserEvent> reminder, SessionInfo session) {
		boolean result=false;
		if(!reminder.equals(null)) {
			result=userReminderDao.insertNewUserEvent(reminder, session);
		}
		
		return result;
	}

	@Override
	public boolean modifyReminder(UserEvent reminder, SessionInfo session) {
		boolean result=false;
		
		if(!reminder.equals(null))
		{
			result=userReminderDao.updateReminderEvent(reminder, session);
		}
		return result;
	}

	@Override
	public boolean deleteReminder(UserEvent reminder, SessionInfo session) {
		boolean result=false;
		if(!reminder.equals(null)) {
			result=userReminderDao.deleteReminderEvent(reminder, session);
		}
		return result;
	}

	@Override
	public List<UserEvent> getAllReminder(SessionInfo session) {
		List<UserEvent> userReminders = new ArrayList<>();
		if(session.getUserName()!=null) {
			userReminders = userReminderDao.getAllUserEvents(session);
		}
		return userReminders;
	}

}
