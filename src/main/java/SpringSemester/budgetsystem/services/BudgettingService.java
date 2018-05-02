package SpringSemester.budgetsystem.services;

import java.util.HashMap;
import java.util.List;

import SpringSemester.budgetsystem.beans.SessionInfo;

public interface BudgettingService {

	public List<HashMap<String,Double>> predictNextMonthBalance(SessionInfo session);
	public List< HashMap<String,Double>> getCurrentMonthBudget(SessionInfo session);
	
}
