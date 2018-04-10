package SpringSemester.budgetsystem.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringSemester.budgetsystem.beans.ApplicationData;
import SpringSemester.budgetsystem.dao.UtilityServiceDao;
import SpringSemester.budgetsystem.services.UtilitiesServices;

@Service("utilitiesservices")
public class UtilitiesServicesImpl implements UtilitiesServices {

	@Autowired
	UtilityServiceDao utilityservicedao;
	
	@Override
	public List<ApplicationData> getIncomeList() {
		List<ApplicationData> incomeList = utilityservicedao.retrieveIncomeType();
		return incomeList;
	}

	@Override
	public List<ApplicationData> getExpensesLists() {
		List<ApplicationData> expensesList = utilityservicedao.retrieveExpensesType();
		return expensesList;
	}

	@Override
	public List<ApplicationData> getUserProfileType() {
		List<ApplicationData> userprofiletypes = utilityservicedao.retrieveProfileType();
		return userprofiletypes;
	}

	@Override
	public List<ApplicationData> getSecurityQuestion() {
		List<ApplicationData> securityquestions = utilityservicedao.retrieveSecurityQuestions();
		return securityquestions;
		
	}

}
