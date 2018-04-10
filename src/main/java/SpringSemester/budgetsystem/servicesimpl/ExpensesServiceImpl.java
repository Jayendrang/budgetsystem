package SpringSemester.budgetsystem.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringSemester.budgetsystem.beans.Expenses;
import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.dao.ExpenesesDao;
import SpringSemester.budgetsystem.services.ExpensesServices;

@Service("expensesservice")
public class ExpensesServiceImpl implements ExpensesServices {

	@Autowired
	ExpenesesDao expenses;
	
	
	@Override
	public boolean addExpenses(List<Expenses> expenses,SessionInfo session) {
		
		return false;
	}

	@Override
	public boolean modifyExpenses(Expenses expenses,SessionInfo session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeListOfExpenses(List<Expenses> expensesList,SessionInfo session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Expenses> getAllExpenses(SessionInfo session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expenses> getExpensesByDate(String fromDate, String toDate, SessionInfo session) {
		// TODO Auto-generated method stub
		return null;
	}

}
