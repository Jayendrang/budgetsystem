package SpringSemester.budgetsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
@RequestMapping(value = "/expenses")
public class ExpensesController {

	@Autowired
	ExpensesServices expensesservices;

	@Autowired
	UtilitiesServices utilityservices;

	public ExpensesController() {
		System.out.println("Expenses Dao -- created()");
	}

	@RequestMapping(value = "/expenseshome", method = RequestMethod.GET)
	public String getExpensesHome(ModelMap model, HttpSession httpSession) {
		try {
			if (!httpSession.getAttribute("user_id").toString().isEmpty()) {
				List<Expenses> listofExpenses = new ArrayList<>();
				model.addAttribute("expenses_bean", new Expenses());
				model.addAttribute("expenses_list_type", utilityservices.getExpensesLists());
				model.addAttribute("expenses_list_bean", listofExpenses);
				return "exepensesHome";
			} else {
				//redirect:/
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// Error page
		return null;
	}

	@RequestMapping(value = "/getallexpenses", method = RequestMethod.GET)
	public String getExpenses(HttpSession httpSession, Model model) {
		if (!httpSession.getAttribute("user_id").toString().isEmpty()) {

			SessionInfo session = new SessionInfo();
			session.setUserName(httpSession.getAttribute("user_id").toString());
			List<Expenses> expenseslist = expensesservices.getAllExpenses(session);
			if (!expenseslist.isEmpty()) {
				model.addAttribute("expenseslist", expenseslist);
			} else {

			}
		} else {

		}
		return null;
	}

	@RequestMapping(value = "/getexpensesbydate", method = RequestMethod.GET)
	public String getExpensesByDate(@ModelAttribute String fromDate, @ModelAttribute String toDate,
			HttpSession httpSession, Model model) {
		if (!httpSession.getAttribute("user_id").toString().isEmpty()) {
			SessionInfo session = new SessionInfo();
			session.setUserName(httpSession.getAttribute("user_id").toString());
			List<Expenses> expensesList = expensesservices.getExpensesByDate(fromDate, toDate, session);
			if (!expensesList.isEmpty()) {
				model.addAttribute("expenses_list", expensesList);
			} else {

			}
		} else {

		}
		return null;
	}

	@RequestMapping(value = "/removeexpenses", method = RequestMethod.POST)
	public String removeExpenses(@ModelAttribute List<Expenses> expenseslist, HttpSession httpSession) {
		try {
			if(!httpSession.getAttribute("user_id").toString().isEmpty()) {
				SessionInfo session = new SessionInfo();
				session.setUserName(httpSession.getAttribute("user_id").toString());
			boolean status = expensesservices.removeListOfExpenses(expenseslist, session);
			if (status) {
				// redirect to home page
				redirectController("");
				return null;
			} else {
				// redirect to error page
				redirectController("");
			}
			}else {
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/addexpenses", method = RequestMethod.POST)
	public String addExpenses(@ModelAttribute List<Expenses> expenseslist,HttpSession httpSession,
			Model model) {
		
		if((!httpSession.getAttribute("user_id").toString().isEmpty())&&(!expenseslist.isEmpty())) {
			
			SessionInfo session = new SessionInfo();
			session.setUserName(httpSession.getAttribute("user_id").toString());
			boolean result = expensesservices.addExpenses(expenseslist, session);
		
		if (result) {
			// calling get expenses servlet for routing
			getExpenses(httpSession, model);

		} else {
			// redirect to error page
			redirectController("");
		}
		}else {
			
		}
		
		return null;
	}

	@RequestMapping(value = "/modifyexpenses", method = RequestMethod.POST)
	public String modifyExpenses(@ModelAttribute Expenses expenses,HttpSession httpSession, Model model) {

		boolean status = false;
		
		try {
			if(!httpSession.getAttribute("user_id").toString().isEmpty())
			{
				SessionInfo session = new SessionInfo();
				session.setUserName(httpSession.getAttribute("user_id").toString());
				status = expensesservices.modifyExpenses(expenses, session);
				if(status) {
					// calling get expenses servlet for routing
					getExpenses(httpSession, model);
				}else {
					
				}
			}
			
		} catch (Exception ex) {
		}

		return null;

	}
	

	public ModelAndView redirectController(String url) {
		return new ModelAndView(url);
	}

}
