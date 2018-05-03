package SpringSemester.budgetsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserEvent;
import SpringSemester.budgetsystem.services.UserEventReminderService;
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

@Controller
@RequestMapping("/userEvent")
public class UserReminderController {

	public UserReminderController() {

		System.out.println("User Reminder Controller----Created");
	}

	@Autowired
	UserEventReminderService eventservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void showReminderHome(HttpServletRequest request, HttpServletResponse response) {
		try {

			getAllReminder(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/addEventReminder", method = RequestMethod.POST)
	public void addReminder(HttpServletRequest request, HttpServletResponse response) {
		boolean serviceresult = false;
		UserEvent reminder = new UserEvent();
		SessionInfo session ;
		List<UserEvent> userEvent = new ArrayList<>();

		try {
			String eventdesc = request.getParameter("event_desc").toString();
			String eventdate = request.getParameter("event_date").toString();
			session=ApplicationUtilities.getSession();
			reminder.setEvent_desc(eventdesc);
			reminder.setEvent_start_date(eventdate);
			userEvent.add(reminder);
			serviceresult = eventservice.addNewReminder(userEvent, session);
			System.out.println(serviceresult);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (serviceresult) {

			getAllReminder(request, response);
		} else {
			getAllReminder(request, response);
		}
	}

	@RequestMapping(value = "/deleteEventReminder", method = RequestMethod.POST)
	public void deleteReminder(HttpServletRequest request, HttpServletResponse response) {
		boolean serviceresult = false;
		UserEvent reminder = new UserEvent();
		SessionInfo session = new SessionInfo();

		try {
			String eventid = request.getAttribute("event_id").toString();
			// request.getSession().getAttribute("user_id").toString()
			session.setUserName("GuMPnZqYSe");
			reminder.setEventid(eventid);
			serviceresult = eventservice.deleteReminder(reminder, session);
		} catch (Exception ex) {
			ex.printStackTrace();

			if (serviceresult) {

			} else {

			}
		}
	}

	/*
	 * @RequestMapping(value = "/modifyEventReminder", method = RequestMethod.POST)
	 * public void updateReminder(HttpServletRequest request, HttpServletResponse
	 * response) { boolean serviceresult = false; UserEvent reminder = new
	 * UserEvent(); SessionInfo session = new SessionInfo();
	 * 
	 * try { String event_id, event_desc, event_date; event_id =
	 * request.getAttribute("").toString(); event_desc =
	 * request.getAttribute("").toString(); event_date =
	 * request.getAttribute("").toString(); //
	 * request.getSession().getAttribute("user_id").toString()
	 * session.setUserName("GuMPnZqYSe"); reminder.setEventid(event_id);
	 * reminder.setEvent_desc(event_desc); reminder.setEvent_start_date(event_date);
	 * serviceresult = eventservice.modifyReminder(reminder, session); } catch
	 * (Exception ex) { ex.printStackTrace(); } if (serviceresult) {
	 * 
	 * } else {
	 * 
	 * }
	 * 
	 * }
	 */

	@RequestMapping(value = "/getAllReminder")
	public void getAllReminder(HttpServletRequest request, HttpServletResponse response) {
		List<UserEvent> listofEvents = new ArrayList<>();

		SessionInfo session = ApplicationUtilities.getSession();
		try {
			// request.getSession().getAttribute("").toString();

			listofEvents = eventservice.getAllReminder(session);
			if (!listofEvents.equals(null)) {
				request.setAttribute("event_list", listofEvents);
				request.setAttribute("session_Info", session);
				request.getRequestDispatcher("/WEB-INF/views/reminder_home.jsp").forward(request, response);
			} else {
				request.setAttribute("session_Info", session);
				request.setAttribute("message", "No reminder available, Please set new events");
				request.getRequestDispatcher("/WEB-INF/views/reminder_home.jsp").forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
