package SpringSemester.budgetsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SpringSemester.budgetsystem.beans.ApplicationData;
import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserInfo;
import SpringSemester.budgetsystem.beans.UserLogin;
import SpringSemester.budgetsystem.services.BudgettingService;
import SpringSemester.budgetsystem.services.UserManagementServices;
import SpringSemester.budgetsystem.services.UtilitiesServices;
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

@Controller
@RequestMapping("/user")
public class UserManagementController {

	@Autowired
	UserManagementServices userManagementServices;

	@Autowired
	UtilitiesServices utilityservices;

	@Autowired
	BudgettingService budgettingService;

	public UserManagementController() {
		System.out.println("User management controller -- initiated()");

	}

	@RequestMapping(value = "/validateUser", method = RequestMethod.POST)
	public void validateUser(HttpServletRequest httpServletRequest, HttpServletResponse response) {
		System.out.println("Validate user servlet");
		Map<String, Double> incomeMap = new HashMap<>();
		Map<String, Double> expenseMap = new HashMap<>();

		try {
			String username = httpServletRequest.getParameter("uname").toString();
			String password = httpServletRequest.getParameter("psw").toString();
			UserLogin logincreds = new UserLogin();
			logincreds.setUsername(username);
			logincreds.setPassword(password);
			SessionInfo session = userManagementServices.validateUser(logincreds);
			if (!session.equals(null)) {
				ApplicationUtilities.setSession(session);
				List<HashMap<String, Double>> currentMonthData = budgettingService.getCurrentMonthBudget(session);
				if (!currentMonthData.isEmpty()) {
					System.out.println("Servlet--" + currentMonthData.size());
					incomeMap = currentMonthData.get(0);
					expenseMap = currentMonthData.get(1);
					httpServletRequest.setAttribute("expenseMapData", expenseMap);
					httpServletRequest.setAttribute("incomeMapData", incomeMap);
				}
				Cookie userIDCookie = new Cookie("userid", session.getUserName());
				Cookie userNameCookie = new Cookie("username", session.getFname() + session.getLname());
				httpServletRequest.setAttribute("session_Info", session);
				response.addCookie(userIDCookie);
				response.addCookie(userNameCookie);
				httpServletRequest.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(httpServletRequest,
						response);
			} else {
				httpServletRequest.setAttribute("errormessage", "Invalid username or password");
				httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(httpServletRequest,
						response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@RequestMapping(value = "/newUserRegistration", method = RequestMethod.GET)
	public String userRegistration(ModelMap model) {

		List<ApplicationData> securityQues = utilityservices.getSecurityQuestion();
		model.addAttribute("UserInfo", new UserInfo());
		model.addAttribute("securityQues", securityQues);
		return "userregistration";
	}

	@RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
	public void processRegistration(@ModelAttribute UserInfo userinfo, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String userdata = userManagementServices.addNewUser(userinfo);
		if (!userdata.equals(null)) {
			SessionInfo session = new SessionInfo();
			System.out.println("NewUser-->" + userinfo);
			session.setUserName(userdata);
			session.setFname(userinfo.getUser_fname());
			session.setLname(userinfo.getUser_lname());
			ApplicationUtilities.setSession(session);
			displayHome(request, response);
		}

	}

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public void displayHome(HttpServletRequest httpServletRequest, HttpServletResponse response) {
		System.out.println("Validate user servlet");
		Map<String, Double> incomeMap = new HashMap<>();
		Map<String, Double> expenseMap = new HashMap<>();
		SessionInfo session = new SessionInfo();
		try {
			session=ApplicationUtilities.getSession();
			System.out.println("outside" + session.getUserName());
			List<HashMap<String, Double>> currentMonthData = budgettingService.getCurrentMonthBudget(session);
			if (!currentMonthData.isEmpty()) {
				incomeMap = currentMonthData.get(0);
				expenseMap = currentMonthData.get(1);
				httpServletRequest.setAttribute("expenseMapData", expenseMap);
				httpServletRequest.setAttribute("incomeMapData", incomeMap);
			}
			Cookie userIDCookie = new Cookie("userid", session.getUserName());
			httpServletRequest.setAttribute("session_Info", session);
			response.addCookie(userIDCookie);
			httpServletRequest.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(httpServletRequest, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
