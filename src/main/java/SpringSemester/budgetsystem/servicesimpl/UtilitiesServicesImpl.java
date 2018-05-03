package SpringSemester.budgetsystem.servicesimpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringSemester.budgetsystem.beans.ApplicationData;
import SpringSemester.budgetsystem.dao.UtilityServiceDao;
import SpringSemester.budgetsystem.services.UtilitiesServices;
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

@Service("utilitiesservices")
public class UtilitiesServicesImpl implements UtilitiesServices {

	@Autowired
	UtilityServiceDao utilityservicedao;
	
	ApplicationUtilities utilities = new ApplicationUtilities();
	
	public UtilitiesServicesImpl() {
		
	}
	
	@Override
	public String[]  getIncomeList() {
		List<ApplicationData> incomeList = utilityservicedao.retrieveIncomeType();
		HashMap<String,String> incomeListMap = new HashMap<>();
		String [] incometype = new String[incomeList.size()];
		int i=0;    
		for(ApplicationData data:incomeList) {
	    	incomeListMap.put(data.getCode(), data.getType());
	    	incometype[i] = data.getCode();
	    	i++;
	    }
	     utilities.setIncomeListMap(incomeListMap);
	    	
	    
		return incometype;
	}

	@Override
	public String[]  getExpensesLists() {
		List<ApplicationData> expensesList = utilityservicedao.retrieveExpensesType();
		HashMap<String,String> expensesListMap = new HashMap<>();
		String [] expensestype=new String[expensesList.size()];
		int i=0;

		for(ApplicationData data:expensesList) {
	    	expensesListMap.put(data.getCode(), data.getType());
			expensestype[i]=data.getCode();
			i++;

		}
	    utilities.setExpensesListMap(expensesListMap);
		
	   return expensestype;
	}

	@Override
	public String[]  getUserProfileType() {
		List<ApplicationData> userprofiletypes = utilityservicedao.retrieveProfileType();
		HashMap<String,String> userProfiletypesMap = new HashMap<>();
	    String [] profileType = new String[userprofiletypes.size()];
	    int i=0;
		for(ApplicationData data:userprofiletypes) {
	    	userProfiletypesMap.put(data.getCode(), data.getType());
	    	profileType[i]=data.getCode();
	    	i++;
		}
	    
	    utilities.setUserProfiletypesMap(userProfiletypesMap);
		return profileType;
	}

	@Override
	public List<ApplicationData> getSecurityQuestion() {
		List<ApplicationData> securityquestions = utilityservicedao.retrieveSecurityQuestions();
	    HashMap<String,String> securityQuestionsMap = new HashMap<>();
	    String[] arrayofQues = new String[securityquestions.size()];
//	    int i=0;
//	    for(ApplicationData data:securityquestions) {
//	    	securityQuestionsMap.put(data.getDetails(),data.getType() );
//	    	arrayofQues[i] = data.getDetails();
//	    	i++;
//	    }
	    utilities.setSecurityQuestionsMap(securityQuestionsMap);
	    
		return securityquestions;
		
	}

}
