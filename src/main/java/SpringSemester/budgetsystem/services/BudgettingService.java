package SpringSemester.budgetsystem.services;

import java.util.HashMap;

import SpringSemester.budgetsystem.beans.SessionInfo;

public interface BudgettingService {

	public HashMap<String, HashMap<String,Double>> predictNextMonthBalance(SessionInfo session);
	public HashMap<String, HashMap<String,Double>> getCurrentMonthBudget(SessionInfo session);
	
}
