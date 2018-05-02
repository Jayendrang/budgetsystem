package SpringSemester.budgetsystem.servicesimpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringSemester.budgetsystem.beans.Expenses;
import SpringSemester.budgetsystem.beans.Income;
import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.dao.ExpenesesDao;
import SpringSemester.budgetsystem.dao.IncomeDao;
import SpringSemester.budgetsystem.exceptions.BudgetPredictException;
import SpringSemester.budgetsystem.services.BudgettingService;
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

@Service
public class BudgettingServiceImpl implements BudgettingService {

	@Autowired
	ExpenesesDao expensesdao;
	@Autowired
	IncomeDao incomedao;

	@Override
	public List<HashMap<String, Double>> predictNextMonthBalance(SessionInfo session) {
		List<HashMap<String, Double>> resultSet = new ArrayList<>();
		resultSet.add(meanOfIncome(session, 3, false));
		resultSet.add(meanOfExpenses(session, 3, false));
		return resultSet;
	}

	@Override
	public List<HashMap<String, Double>> getCurrentMonthBudget(SessionInfo session) {
		List<HashMap<String, Double>> resultSet = new ArrayList<>();
		resultSet.add(meanOfIncome(session, 1, true));
		resultSet.add(meanOfExpenses(session, 1, true));
		return resultSet;
	}

	public HashMap<String, Double> meanOfIncome(SessionInfo session, int month, boolean current) {

		HashMap<String, Double> incomeMean = new HashMap<>();
		String[] firstDateOfMonth = ApplicationUtilities
				.getFirstDateThreeMonths(Calendar.getInstance().get(Calendar.MONTH) + 1, true);
		String[] lastDateOfMonth = ApplicationUtilities
				.getLastDateThreeMonths(Calendar.getInstance().get(Calendar.MONTH) + 1, true);

		try {
			List<Income> listofIncome = incomedao.retrieveIncomeByDate(firstDateOfMonth[0], lastDateOfMonth[0],
					session);
			for (Income income : listofIncome) {
			if(incomeMean.containsKey(income.getIncome_category())) {
				double summation =+ incomeMean.get(income.getIncome_category());
				incomeMean.put(income.getIncome_category(),summation);
			}
				incomeMean.put(income.getIncome_category(), Double.parseDouble(income.getAmount()));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return incomeMean;
	}

	public HashMap<String, Double> meanOfExpenses(SessionInfo session, int month, boolean current) {

		HashMap<String, Double> expensesMean = new HashMap<>();
		String[] firstDateOfMonth = ApplicationUtilities
				.getFirstDateThreeMonths(Calendar.getInstance().get(Calendar.MONTH) + 1, true);
		String[] lastDateOfMonth = ApplicationUtilities
				.getLastDateThreeMonths(Calendar.getInstance().get(Calendar.MONTH) + 1, true);

		try {
			List<Expenses> listofIncome = expensesdao.retrieveExpensesByDate(firstDateOfMonth[0], lastDateOfMonth[0],
					session);
			for (Expenses expenses : listofIncome) {
				if (expensesMean.containsKey(expenses.getExpenses_name())) {
					double summation = +expensesMean.get(expenses.getExpenses_name());
					expensesMean.put(expenses.getExpenses_name(), summation);
				} else {
					expensesMean.put(expenses.getExpenses_name(), Double.parseDouble(expenses.getAmount()));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return expensesMean;
	}
}
