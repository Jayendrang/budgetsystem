package SpringSemester.budgetsystem.services;

import java.util.List;

import SpringSemester.budgetsystem.beans.ApplicationData;

public interface  UtilitiesServices {

	public List<ApplicationData> getIncomeList();
	public List<ApplicationData> getExpensesLists();
	public List<ApplicationData> getUserProfileType();
	public List<ApplicationData> getSecurityQuestion();
	
}
