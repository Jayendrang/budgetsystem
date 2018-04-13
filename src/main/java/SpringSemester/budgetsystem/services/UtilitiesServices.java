package SpringSemester.budgetsystem.services;

import java.util.HashMap;
import java.util.List;

import SpringSemester.budgetsystem.beans.ApplicationData;

public interface  UtilitiesServices {
		
	public HashMap<String,String> getIncomeList();
	public HashMap<String,String> getExpensesLists();
	public HashMap<String,String> getUserProfileType();
	public HashMap<String,String> getSecurityQuestion();
	
}
