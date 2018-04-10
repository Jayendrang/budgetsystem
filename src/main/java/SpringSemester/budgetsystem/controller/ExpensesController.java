package SpringSemester.budgetsystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import SpringSemester.budgetsystem.beans.Expenses;
import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.services.ExpensesServices;
import SpringSemester.budgetsystem.services.UtilitiesServices;

@Controller
@RequestMapping(value="/expenses")
public class ExpensesController {

	@Autowired
	ExpensesServices expensesservices;
	
	@Autowired
	UtilitiesServices utilityservices;
	
	@RequestMapping(value="/expenseshome", method=RequestMethod.GET)
	public String getExpensesHome(ModelMap model) {
		try{
		List<Expenses> listofExpenses = new ArrayList<>();
		model.addAttribute("expensesobject",new Expenses());
		model.addAttribute("expensestype",utilityservices.getExpensesLists());
		model.addAttribute("listofExpenses",listofExpenses);
		return "exepenses";
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		//Error page
		return null;
	}
	
	@RequestMapping(value="/getallexpenses", method=RequestMethod.GET)
	public String getExpenses(@ModelAttribute SessionInfo session,Model model) {
		List<Expenses> expenseslist = expensesservices.getAllExpenses(session);
		model.addAttribute("expenseslist",expenseslist);
		return null;
	}
	
	@RequestMapping(value="/getexpensesbydate", method=RequestMethod.GET)
	public String getExpensesByDate(@ModelAttribute String[] dates,@ModelAttribute SessionInfo session,Model model) {
		List<Expenses> expensesList = expensesservices.getExpensesByDate(dates[0],dates[1],session);
		model.addAttribute("expenseslist",expensesList);
		return null;
	}
	
	@RequestMapping(value="/removeexpenses", method=RequestMethod.POST)
	public String removeExpenses(@ModelAttribute List<Expenses> expenseslist,SessionInfo session) {
		try {
			boolean status = expensesservices.removeListOfExpenses(expenseslist,session);
			if(status) {
				//redirect to home page
				redirectController("");
				return null;
			}else {
				//redirect to error page
				redirectController("");
			}
			
				}catch(Exception ex) {
			ex.printStackTrace();
			}
		return null;
	}
	
	@RequestMapping(value="/addexpenses", method=RequestMethod.POST)
	public String addExpenses(@ModelAttribute List<Expenses> expenses,@ModelAttribute SessionInfo session,Model model ) {
	boolean result=expensesservices.addExpenses(expenses,session);
	if(result) {
		//calling get expenses servlet for routing
		getExpenses(session, model);
			
	}else {
		//redirect to error page
		redirectController("");
	}
	return null;
	}

	
	@RequestMapping(value="/modifyexpenses", method=RequestMethod.POST)
	public String modifyExpenses(@ModelAttribute Expenses expenses, @ModelAttribute SessionInfo session, Model model) {
	
		boolean status=false;
		try {
		status = expensesservices.modifyExpenses(expenses,session);
		
		//calling get expenses servlet for routing
		getExpenses(session, model);
		}catch(Exception ex) {
		}
		
		return null;
		
	}
//	public String addExpeses(@ModelAttribute("listofexpenses") List<Expenses> expenses, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.getRequestDispatcher("/welcome.jsp");
//		request.setAttribute("name", "");
//		
//		return null;
	
	public ModelAndView redirectController(String url) {
		return new ModelAndView(url);
	}

}
