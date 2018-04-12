package SpringSemester.budgetsystem.dao;

import java.util.List;

import SpringSemester.budgetsystem.beans.Income;
import SpringSemester.budgetsystem.beans.SessionInfo;

public interface IncomeDao {

	public boolean addIncome(List<Income> income,SessionInfo session);
	public boolean updateIncome(Income income,SessionInfo session);
	public List<Income> retrieveAllIncomes(SessionInfo session);
	public List<Income> retrieveIncomeByDate(String fromDate,String toDate,SessionInfo session);
	public boolean deleteIncome(List<Income> expenses,SessionInfo session);
}
