package SpringSemester.budgetsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SpringSemester.budgetsystem.beans.ApplicationData;
import SpringSemester.budgetsystem.services.UtilitiesServices;

@Controller
@RequestMapping("/utilities")
public class UtilitiesController {

	@Autowired
	UtilitiesServices utilityservices;
	
	public UtilitiesController() {
		System.out.println("Utility controller -- Start()");
	}
	@RequestMapping(value="/getExpensesType", method=RequestMethod.GET)
	public String getExpensesType() {
		Model model = null;
		List<ApplicationData> expensestype= utilityservices.getExpensesLists();
		model.addAttribute("expensestype",expensestype);
		return "expenses";
	}
	
	
}
