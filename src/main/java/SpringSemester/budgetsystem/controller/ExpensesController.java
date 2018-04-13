package SpringSemester.budgetsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public String getExpensesHome(ModelMap model, HttpServletRequest httpRequest) {
		try {
			HttpSession httpSession = httpRequest.getSession();

			if (!httpSession.getAttribute("user_id").toString().isEmpty()) {
				List<Expenses> listofExpenses = new ArrayList<>();
				model.addAttribute("expenses_bean", new Expenses());
				model.addAttribute("expenses_list_type", utilityservices.getExpensesLists());
				model.addAttribute("expenses_list_bean", listofExpenses);
				return "exepensesHome";
			} else {
				// redirect:/
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// Error page
		return null;
	}

	@RequestMapping(value = "/getallexpenses", method = RequestMethod.GET)
	public String getExpenses(HttpServletRequest httpRequest, ModelMap model) {
		try {
			HttpSession httpSession = httpRequest.getSession();

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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/getexpensesbydate", method = RequestMethod.GET)
	public String getExpensesByDate(@ModelAttribute String fromDate, @ModelAttribute String toDate,
			HttpServletRequest httpServletRequest, Model model) {

		try {
			HttpSession httpSession = httpServletRequest.getSession();
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/removeexpenses", method = RequestMethod.POST)
	public String removeExpenses(@ModelAttribute List<Expenses> expenseslist, HttpServletRequest httpServletRequest) {
		try {
			HttpSession httpSession = httpServletRequest.getSession();
			if (!httpSession.getAttribute("user_id").toString().isEmpty()) {
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
			} else {

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/addexpenses", method = RequestMethod.POST)
	public String addExpenses(@ModelAttribute List<Expenses> expenseslist, HttpServletRequest httpServletRequest,
			ModelMap model) {
		SessionInfo session = new SessionInfo();

		try {
			HttpSession httpSession = httpServletRequest.getSession();
			if ((!httpSession.getAttribute("user_id").toString().isEmpty()) && (!expenseslist.isEmpty())) {

				session.setUserName(httpSession.getAttribute("user_id").toString());
				boolean result = expensesservices.addExpenses(expenseslist, session);

				if (result) {
					// calling get expenses servlet for routing
					httpServletRequest.getSession().setAttribute("user_id", session.getUserName());
					getExpenses(httpServletRequest, model);

				} else {
					// redirect to error page
					redirectController("");
				}
			} else {

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/modifyexpenses", method = RequestMethod.POST)
	public String modifyExpenses(@ModelAttribute Expenses expenses, HttpServletRequest httpServletRequest,
			ModelMap model) {

		boolean status = false;

		try {
			HttpSession httpSession = httpServletRequest.getSession();
			if (!httpSession.getAttribute("user_id").toString().isEmpty()) {
				SessionInfo session = new SessionInfo();
				session.setUserName(httpSession.getAttribute("user_id").toString());
				status = expensesservices.modifyExpenses(expenses, session);
				if (status) {
					// calling get expenses servlet for routing
					httpServletRequest.getSession().setAttribute("user_id", session.getUserName());
					getExpenses(httpServletRequest, model);
				} else {

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