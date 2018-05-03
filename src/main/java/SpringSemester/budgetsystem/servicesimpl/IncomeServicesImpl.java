package SpringSemester.budgetsystem.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringSemester.budgetsystem.beans.Income;
import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.dao.IncomeDao;
import SpringSemester.budgetsystem.services.IncomeServices;

@Service("incomeservices")
public class IncomeServicesImpl implements IncomeServices {

	@Autowired
	IncomeDao incomedao;
	
	public IncomeServicesImpl() {
		System.out.println("Income services -- created()");
		
	}
	
	@Override
	public boolean addIncome(List<Income> incomeList, SessionInfo sessionInfo) {
		boolean servletflag =false;
		
			servletflag = incomedao.addIncome(incomeList,sessionInfo);
		
		return servletflag;
	}

	@Override
	public boolean modifyIncome(Income income,SessionInfo session) {
		if(!income.equals(null)) {
			return incomedao.updateIncome(income,session);
		}
		return false;
	}

	@Override
	public boolean removeListOfIncome(List<Income> incomeList,SessionInfo session) {
		if(!incomeList.isEmpty()) {
			return incomedao.deleteIncome(incomeList,session);
		}
		return false;
	}

	@Override
	public List<Income> getAllIncome(SessionInfo session) {
		if(!session.equals(null)) {
			return incomedao.retrieveAllIncomes(session);
		}
		return null;
	}

	@Override
	public List<Income> getIncomeByDate(String fromDate, String toDate, SessionInfo session) {
		if(!session.equals(null)) {
			if((!fromDate.isEmpty())&&(!toDate.isEmpty())) {
				return incomedao.retrieveIncomeByDate(fromDate, toDate, session);
			}
		}
		
		return null;
	}

	
}
