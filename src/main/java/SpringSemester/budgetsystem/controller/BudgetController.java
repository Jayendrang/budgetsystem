package SpringSemester.budgetsystem.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.services.BudgettingService;

@Controller
@RequestMapping(value = "/budget")
public class BudgetController {

	@Autowired
	BudgettingService budgettingService;

	public BudgetController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/currentMonth")
	public void getCurrentMonthExpensesGraph(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Double> incomeMap = new HashMap<>();
		Map<String,Double> expenseMap = new HashMap<>();
		try {
			SessionInfo session = new SessionInfo();
			session.setUserName("GuMPnZqYSe");
			
			List<HashMap<String, Double>> currentMonthData = budgettingService.getCurrentMonthBudget(session);
			if (!currentMonthData.isEmpty()) {
				System.out.println("Servlet--"+currentMonthData.size());
				incomeMap = currentMonthData.get(0);
				expenseMap = currentMonthData.get(1);
			}
			request.setAttribute("expenseMapData", expenseMap);
			request.setAttribute("incomeMapData", incomeMap);
	
			request.getRequestDispatcher("/WEB-INF/views/currentMonthGraph.jsp").forward(request, response);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
}
