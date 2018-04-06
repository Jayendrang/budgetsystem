package SpringSemester.budgetsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SpringSemester.budgetsystem.beans.UserLogin;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	public HomeController() {

		System.out.println("Home controller");

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("userLogin",new UserLogin());
		return "index";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("userLogin", new UserLogin());
		return "index";
	}

}
