package SpringSemester.budgetsystem.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserInfo;
import SpringSemester.budgetsystem.beans.UserLogin;
import SpringSemester.budgetsystem.services.UserManagementServices;

@Controller
@RequestMapping("/user")
public class UserManagementController {

	@Autowired
	UserManagementServices userManagementServices;
	
	public UserManagementController() {
		System.out.println("User management controller -- initiated()");
		
	}
	@RequestMapping(value="/validateUser", method=RequestMethod.GET )
	public String validateUser(@ModelAttribute UserLogin login, Model model) {
		System.out.println("Validate user servlet");
		if(login!=null) {
		SessionInfo session = userManagementServices.validateUser(login);
		model.addAttribute("session",session);
		}
		return "welcome";
	}
	
	@RequestMapping(value="/newUserRegistration", method=RequestMethod.GET)
	public String userRegistration(Model model) {
		model.addAttribute("UserInfo",new UserInfo());
		return "userregistration";
	}
	
	@RequestMapping(value="/processRegistration", method=RequestMethod.POST)
	public String processRegistration(@ModelAttribute UserInfo userinfo, Model  model) {
		boolean status = userManagementServices.addNewUser(userinfo);
		System.out.println("User Add status::"+status);
		return null;
	}
}
