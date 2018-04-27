package SpringSemester.budgetsystem.services;

import java.util.List;


import SpringSemester.budgetsystem.beans.Income;
import SpringSemester.budgetsystem.beans.SessionInfo;

public interface IncomeServices {
	
	public boolean addIncome(List<Income> income,SessionInfo session );
	public boolean modifyIncome(Income income,SessionInfo session);
	public boolean removeListOfIncome(List<Income> incomeList,SessionInfo session);
	public List<Income> getAllIncome(SessionInfo session);
	public List<Income> getIncomeByDate(String fromDate,String toDate,SessionInfo session);

}
