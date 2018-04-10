package SpringSemester.budgetsystem.services;

import java.util.List;

import SpringSemester.budgetsystem.beans.Expenses;
import SpringSemester.budgetsystem.beans.SessionInfo;

public interface IncomeServices {
	
	public boolean addIncome(List<Expenses> expenses );
	public boolean modifyIncome(Expenses expenses);
	public boolean removeListOfIncome(List<Expenses> expensesList);
	public List<Expenses> getAllIncome(SessionInfo session);
	public List<Expenses> getIncomeByDate(String fromDate,String toDate,SessionInfo session);

}
