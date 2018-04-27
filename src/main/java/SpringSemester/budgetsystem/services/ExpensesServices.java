package SpringSemester.budgetsystem.services;

import java.util.List;

import SpringSemester.budgetsystem.beans.Expenses;
import SpringSemester.budgetsystem.beans.SessionInfo;

public interface ExpensesServices {

	public boolean addExpenses(List<Expenses> expenses, SessionInfo session );
	public boolean modifyExpenses(Expenses expenses, SessionInfo session);
	public boolean removeListOfExpenses(List<Expenses> expensesList,SessionInfo session);
	public List<Expenses> getAllExpenses(SessionInfo session);
	public List<Expenses> getExpensesByDate(String fromDate,String toDate,SessionInfo session);
	
	
}
