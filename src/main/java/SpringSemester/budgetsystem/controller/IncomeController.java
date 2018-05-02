package SpringSemester.budgetsystem.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SpringSemester.budgetsystem.beans.Expenses;
import SpringSemester.budgetsystem.beans.Income;
import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.services.IncomeServices;
import SpringSemester.budgetsystem.services.UtilitiesServices;
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

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
	public String addNewIncome(HttpServletRequest request, HttpServletResponse response) {
		boolean result = false;
		String page = null;
		SessionInfo session = new SessionInfo();
		String[] date = null;
		String[] category = null;
		String[] desc = null;
		String[] amount = null;
		String[] remarks = null;
		List<Income> incomelist = new ArrayList<>();
		try {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user_id", "GuMPnZqYSe");
			
			if ((!httpSession.getAttribute("user_id").toString().isEmpty())) {
				session.setUserName(httpSession.getAttribute("user_id").toString());
				Map<String, String[]> pagedata = request.getParameterMap();
				Set setData = pagedata.entrySet();
				Iterator setItr = setData.iterator();
				while (setItr.hasNext()) {
					Map.Entry<String, String[]> entry = (Entry<String, String[]>) setItr.next();
					String paramName = entry.getKey();
					System.out.println(paramName);
					String[] paramValues = entry.getValue();
					
					switch (paramName) {

					case "date-value": {
						date = new String[paramValues.length];
						date = paramValues;
						continue;
					}
					case "income_category": {
						category= new String[paramValues.length];
						category = paramValues;
						continue;
					}
					case "income-desc": {
						desc = new String[paramValues.length];
						desc = paramValues;
						continue;
					}
					case "income-amt": {
						amount = new String[paramValues.length];
						amount = paramValues;
						continue;
					}
					case "income-remarks":
					{
						remarks = new String[paramValues.length];
						remarks = paramValues;
						continue;
					}
				}
					for (int s = 0; s < date.length; s++) {
						Income income = new Income();
						income.setIncome_date(date[s]);
						income.setIncome_category(category[s]);
						income.setIncome_desc(desc[s]);
						income.setIncome_type(ApplicationUtilities.getIncomeListMap(category[s]));
						income.setAmount(amount[s]);
						income.setRemark(remarks[s]);
						incomelist.add(income);
					}

				}
				System.out.println(incomeservices.addIncome(incomelist, session));
			} else {
			
			
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return page;
	}

	@RequestMapping(value="/getAllIncome", method=RequestMethod.GET)
	public String getAllIncome(HttpServletRequest request,HttpServletResponse response, HttpSession httpSesison) {
		List<Income> incomeList = new ArrayList<Income>();
		SessionInfo sessionInfo = new SessionInfo();
		try {
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("user_id", "GuMPnZqYSe");
		String page = null;
		if (!httpSesison.getAttribute("user_id").toString().isEmpty()) {
			sessionInfo.setUserName(httpSesison.getAttribute("user_id").toString());
			incomeList = incomeservices.getAllIncome(sessionInfo);
			if (!incomeList.isEmpty()) {
				request.setAttribute("income_list", incomeList);
				request.setAttribute("user_id", sessionInfo.getUserName());
				request.getRequestDispatcher("/WEB-INF/views/income_home.jsp").forward(request, response);
			} else {

			}

		} else {

		}}catch(Exception ex) {
			ex.printStackTrace();
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
	
	@RequestMapping(value="/serveIncome")
	public String loadExpensesPage(HttpServletRequest request, HttpServletResponse response) {


		System.out.println("new non spring servlet");
		try {
			SessionInfo session = new SessionInfo();
			session.setUserName("GuMPnZqYSe");
				
				request.setAttribute("applicationdata", utilityservices.getIncomeList());
				request.getRequestDispatcher("/WEB-INF/views/income_new.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
			
		
		return null;
	}
	
}
