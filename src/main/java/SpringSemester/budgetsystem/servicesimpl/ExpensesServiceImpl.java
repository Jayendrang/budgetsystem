package SpringSemester.budgetsystem.servicesimpl;

import java.util.ArrayList;
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
	ExpenesesDao expensesdao;
	
	public ExpensesServiceImpl() {
	
	 System.out.println("Expenses service -- created()");
	}
	
	@Override
	public boolean addExpenses(List<Expenses> expenses,SessionInfo session) {
		boolean daoproceedflag=false;
		boolean servletflag =false;
		if((session!=null) && (!expenses.isEmpty())) {
			servletflag=expensesdao.addExpenses(expenses,session);
		}
		
		return servletflag;
	}

	@Override
	public boolean modifyExpenses(Expenses expenses,SessionInfo session) {
		boolean servletflag=false;
		if((!expenses.equals(null)) && (!session.equals(null))) {
			if(session.getUserName().trim().equals(expenses.getUser_id().trim())){
				servletflag=expensesdao.updateExpenses(expenses,session);
			}
		}
		
		return servletflag;
	}

	@Override
	public boolean removeListOfExpenses(List<Expenses> expensesList,SessionInfo session) {
		boolean servletflag=false;
		if((!expensesList.isEmpty())&& (!session.equals(null))) {
			servletflag=expensesdao.deleteExpenses(expensesList,session);
		}
		
		return servletflag;
	}

	@Override
	public List<Expenses> getAllExpenses(SessionInfo session) {
		List<Expenses> returnList = new ArrayList<Expenses>();
		if(!session.equals(null)) {
			return returnList=expensesdao.retrieveAllExpenses(session);
		}
		return null;
	}

	@Override
	public List<Expenses> getExpensesByDate(String fromDate, String toDate, SessionInfo session) {
		List<Expenses> returnList = new ArrayList<Expenses>();
		if(!session.equals(null)) {
			if((!fromDate.isEmpty())&&(!toDate.isEmpty())){
				returnList = expensesdao.retrieveExpensesByDate(fromDate, toDate, session);
			}
		}
		return returnList;
	}

}
