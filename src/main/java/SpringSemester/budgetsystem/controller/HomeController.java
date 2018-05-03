package SpringSemester.budgetsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.beans.UserLogin;
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	public HomeController() {

		System.out.println("Home controller");

	}

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public void home(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public void index(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	@RequestMapping(value="/contactus")
	public void contactus(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/views/contactus.jsp").forward(request, response);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@RequestMapping(value="/aboutus")
	public void aboutus(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/views/about.jsp").forward(request, response);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@RequestMapping(value="/logout")
	public void signoff(HttpServletRequest request, HttpServletResponse response) {
		try {
			SessionInfo session  =  new SessionInfo();
			ApplicationUtilities.setSession(session);
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
