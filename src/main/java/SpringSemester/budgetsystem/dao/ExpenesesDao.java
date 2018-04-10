package SpringSemester.budgetsystem.dao;

import java.util.List;

import SpringSemester.budgetsystem.beans.Expenses;
import SpringSemester.budgetsystem.beans.SessionInfo;

public interface ExpenesesDao {

	public boolean addExpenses(List<Expenses> expenses);
	public boolean updateExpenses(Expenses expenses);
	public List<Expenses> retrieveAllExpenses(SessionInfo session);
	public List<Expenses> retrieveByDate(String fromDate,String toDate,SessionInfo session);
	public boolean deleteExpenses(List<Expenses> expenses,SessionInfo session);
}
