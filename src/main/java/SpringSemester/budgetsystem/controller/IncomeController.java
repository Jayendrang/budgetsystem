package SpringSemester.budgetsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SpringSemester.budgetsystem.beans.Income;
import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.services.IncomeServices;
import SpringSemester.budgetsystem.services.UtilitiesServices;

@Controller
@RequestMapping(value = "/income")
public class IncomeController {

	@Autowired
	IncomeServices incomeservices;

	@Autowired
	UtilitiesServices utilityservices;
	
	
	public IncomeController() {
		System.out.println("Income controller --- started()");
	}

	@RequestMapping(value = "/loadincomepage", method = RequestMethod.GET)
	public String showIncomePage(Model model,HttpSession httpSession) {
		try {
			if(!httpSession.getAttribute("user_id").toString().isEmpty()) {
			Income income = new Income();
			List<Income> incomeList = new ArrayList<>();
			model.addAttribute("income_bean", income);
			model.addAttribute("income_list_bean",incomeList);
			model.addAttribute("income_list_data", utilityservices.getIncomeList());
			model.addAttribute("user_id",httpSession.getAttribute("user_id").toString());
			return "income_home";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "income_home";
	}

	@RequestMapping(value="/addIncome", method=RequestMethod.POST)
	public String addNewIncome(@ModelAttribute List<Income> incomelist, HttpSession session, Model model) {
		boolean result = false;
		String page = null;
		try {
			if (!incomelist.isEmpty()) {
				SessionInfo sessionInfo = new SessionInfo();
				sessionInfo.setUserName(session.getAttribute("user_id").toString());
				result = incomeservices.addIncome(incomelist, sessionInfo);
				if (result) {

				} else {

				}
			} else {

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return page;
	}

	@RequestMapping(value="/getAllIncome", method=RequestMethod.GET)
	public String getAllIncome(Model model, HttpSession httpSesison) {
		List<Income> incomeList = new ArrayList<Income>();
		SessionInfo sessionInfo = new SessionInfo();
		String page = null;
		if (!httpSesison.getAttribute("user_id").toString().isEmpty()) {
			sessionInfo.setUserName(httpSesison.getAttribute("user_id").toString());
			incomeList = incomeservices.getAllIncome(sessionInfo);
			if (incomeList.isEmpty()) {
				model.addAttribute("income_list", incomeList);
				model.addAttribute("user_id", sessionInfo.getUserName());
			} else {

			}

		} else {

		}
		return null;
	}

	@RequestMapping(value="/getIncomeByyDate", method=RequestMethod.GET)
	public String getIncomeListByDate(Model model, HttpSession httpSession, @ModelAttribute String fromDate,
			@ModelAttribute String toDate) {

		List<Income> incomeList = new ArrayList<Income>();
		SessionInfo sessionInfo = new SessionInfo();
		String page = null;
		if (!httpSession.getAttribute("user_id").toString().isEmpty()) {
			if ((!fromDate.isEmpty()) && (!toDate.isEmpty())) {
				sessionInfo.setUserName(httpSession.getAttribute("user_id").toString());
				incomeList = incomeservices.getIncomeByDate(fromDate, toDate, sessionInfo);
				if (incomeList.isEmpty()) {
					model.addAttribute("income_list_by_date", incomeList);
					model.addAttribute("user_id", sessionInfo.getUserName());
				} else {

				}
			}
		}
		return null;
	}

	@RequestMapping(value="/modifyIncome", method=RequestMethod.POST)
	public String modifyIncomeList(@ModelAttribute Income income,Model model, HttpSession httpSession) {
		SessionInfo session = new SessionInfo();
		String page = null;
		if((!income.equals(null)&&(!httpSession.getAttribute("user_id").toString().isEmpty()))) {
			session.setUserName(httpSession.getAttribute("user_id").toString());
			boolean result = incomeservices.modifyIncome(income,session);
			if(result) {
				
			}else {
				
			}
		}
		
		return null;
	}
	
	@RequestMapping(value="/removeIncome", method=RequestMethod.POST)
	public String deleteIncome(@ModelAttribute List<Income> incomelist,Model model, HttpSession httpSession) {
		
		SessionInfo session = new SessionInfo();
		String page = null;
		
		if(httpSession.getAttribute("user_id").toString().isEmpty()) {
			if(!incomelist.isEmpty()) {
					session.setUserName(httpSession.getAttribute("user_id").toString());
					boolean result = incomeservices.removeListOfIncome(incomelist, session);
					if(result) {
						
					}else {
						
					}
			}
		}
		return null;
	}
}
