package SpringSemester.budgetsystem.dao;

import java.util.List;

import SpringSemester.budgetsystem.beans.ApplicationData;;

public interface UtilityServiceDao {
	public List<ApplicationData> retrieveIncomeType();
	public List<ApplicationData> retrieveExpensesType();
	public List<ApplicationData> retrieveProfileType();
	public List<ApplicationData> retrieveSecurityQuestions();

}
