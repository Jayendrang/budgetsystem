package SpringSemester.budgetsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/expenses")
public class ExpensesController {

	@RequestMapping(value="/showexpenses", method=RequestMethod.GET)
	public String getExpenses(Model model) {
		
		return "exepenses";
	}
}
