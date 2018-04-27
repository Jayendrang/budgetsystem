package SpringSemester.budgetsystem.servicesimpl;

import java.util.HashMap;
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
	
	
	
	public UtilitiesServicesImpl() {
		
	}
	
	@Override
	public HashMap<String,String>  getIncomeList() {
		List<ApplicationData> incomeList = utilityservicedao.retrieveIncomeType();
		HashMap<String,String> incomeListMap = new HashMap<>();
	    for(ApplicationData data:incomeList) {
	    	incomeListMap.put(data.getCode(), data.getType());
	    }
	     
	    		
		return incomeListMap;
	}

	@Override
	public String[]  getExpensesLists() {
		List<ApplicationData> expensesList = utilityservicedao.retrieveExpensesType();
		
//		HashMap<String,String> expensesListMap = new HashMap<>();
//	    for(ApplicationData data:expensesList) {
//	    	expensesListMap.put(data.getCode(), data.getType());
//	    }
		String [] arrayOfExpenses=new String[expensesList.size()];
		int i=0;
		for(ApplicationData data : expensesList) {
			arrayOfExpenses[i]=data.getCode();
			i++;
		}
	   return arrayOfExpenses;
	}

	@Override
	public HashMap<String,String>  getUserProfileType() {
		List<ApplicationData> userprofiletypes = utilityservicedao.retrieveProfileType();
		HashMap<String,String> userProfiletypesMap = new HashMap<>();
	    for(ApplicationData data:userprofiletypes) {
	    	userProfiletypesMap.put(data.getCode(), data.getType());
	    }

		return userProfiletypesMap;
	}

	@Override
	public HashMap<String,String> getSecurityQuestion() {
		List<ApplicationData> securityquestions = utilityservicedao.retrieveSecurityQuestions();
	    HashMap<String,String> securityQuestionsMap = new HashMap<>();
	    for(ApplicationData data:securityquestions) {
	    	securityQuestionsMap.put(data.getCode(), data.getDetails());
	    }
	    
		return securityQuestionsMap;
		
	}

}
