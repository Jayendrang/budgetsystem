package SpringSemester.budgetsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/userEvent")
public class UserReminderController {

	public UserReminderController() {

		System.out.println("User Reminder Controller----Created");
	}

	@RequestMapping(value = "/addEventReminder", method = RequestMethod.POST)
	public void addReminder(HttpServletRequest request, HttpServletResponse response) {
		try {

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@RequestMapping(value = "/reminderHome", method = RequestMethod.GET)
	public void showReminderHome(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/views/addreminder.jsp").forward(request, response);;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
