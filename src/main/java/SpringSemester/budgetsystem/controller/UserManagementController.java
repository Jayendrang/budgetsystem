package SpringSemester.budgetsystem.controller;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserInfo;
import SpringSemester.budgetsystem.beans.UserLogin;
import SpringSemester.budgetsystem.services.UserManagementServices;
import SpringSemester.budgetsystem.services.UtilitiesServices;

@Controller
@RequestMapping("/user")
public class UserManagementController {

	@Autowired
	UserManagementServices userManagementServices;
	
	@Autowired
	UtilitiesServices utilityservices;
	
	public UserManagementController() {
		System.out.println("User management controller -- initiated()");
		
	}
	@RequestMapping(value="/validateUser", method=RequestMethod.GET )
	public String validateUser(@ModelAttribute UserLogin login,HttpServletRequest httpServletRequest, Model model) {
		System.out.println("Validate user servlet");
		if(login!=null) {
		SessionInfo session = userManagementServices.validateUser(login);
		model.addAttribute("session_Info",session);
		}
		return "welcome";
	}
	
	@RequestMapping(value="/newUserRegistration", method=RequestMethod.GET)
	public String userRegistration(ModelMap model) {
	
		String[] securityQues = utilityservices.getSecurityQuestion();
		model.addAttribute("UserInfo",new UserInfo());
		model.addAttribute("securityQues",securityQues);
		return "userregistration";
	}
	
	@RequestMapping(value="/processRegistration", method=RequestMethod.POST)
	public String processRegistration(@ModelAttribute UserInfo userinfo, Model  model) {
		boolean status = userManagementServices.addNewUser(userinfo);
		
		return null;
	}
}
