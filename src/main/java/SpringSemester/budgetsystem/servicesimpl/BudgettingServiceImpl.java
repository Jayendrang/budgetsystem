package SpringSemester.budgetsystem.servicesimpl;

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
	public HashMap<String, HashMap<String,Double>> predictNextMonthBalance(SessionInfo session) {
		HashMap<String,HashMap<String,Double>> resultSet = new HashMap<>();
		resultSet.put("meanIncome", meanOfIncome(session,3));
		resultSet.put("meanExpenses",meanOfExpenses(session,3));
		return resultSet;
	}

	@Override
	public HashMap<String, HashMap<String,Double>> getCurrentMonthBudget(SessionInfo session) {
		HashMap<String,HashMap<String,Double>> resultSet = new HashMap<>();
		resultSet.put("meanIncome", meanOfIncome(session,1));
		resultSet.put("meanExpenses",meanOfExpenses(session,1));
		return resultSet;
	}

	private HashMap<String, Double> meanOfExpenses(SessionInfo session, int numOfMonth) {
		HashMap<String, List<Expenses>> monthlyExpensesHash = new HashMap<String, List<Expenses>>(3);
		HashMap<String, Double> meanOfExpenses = new HashMap<String, Double>();
		try {
			String[] firstDateOfMonth = ApplicationUtilities.getFirstDateThreeMonths(Calendar.MONTH);
			String[] lastDateOfMonth = ApplicationUtilities.getLastDateThreeMonths(Calendar.MONTH);
			double totalMeanExpenses=0.0;
			List<Expenses> listofExpenses;
			for (int month = 0; month < numOfMonth; month++) {
				listofExpenses = expensesdao.retrieveExpensesByDate(firstDateOfMonth[month], lastDateOfMonth[month],
						session);
				if(!listofExpenses.equals(null)) {
				monthlyExpensesHash.put(String.valueOf(month), listofExpenses);
				}else {
					throw new BudgetPredictException("Data Insufficient to predict future month balance");
				}
			}

			for (int pmonth = 0; pmonth < numOfMonth; pmonth++) {
				if (pmonth == 0 || pmonth == 1) {
					List<Expenses> monthexpenses = monthlyExpensesHash.get(pmonth);
					for (Expenses expenses : monthexpenses) {
						if (meanOfExpenses.containsKey(expenses.getExpenses_name())) {
							double val = meanOfExpenses.get(expenses.getExpenses_name());
							val += Double.parseDouble(expenses.getAmount());
							meanOfExpenses.put(expenses.getExpenses_name(), val);
							
						} else {
							meanOfExpenses.put(expenses.getExpenses_name(), Double.parseDouble(expenses.getAmount()));
						}
					}
				}
				if (pmonth == 2) {
					List<Expenses> monthexpenses = monthlyExpensesHash.get(pmonth);
					for (Expenses expenses : monthexpenses) {
						if (meanOfExpenses.containsKey(expenses.getExpenses_name())) {
							double val = meanOfExpenses.get(expenses.getExpenses_name());
							val += Double.parseDouble(expenses.getAmount());
							totalMeanExpenses = +(val/numOfMonth);
							meanOfExpenses.put(expenses.getExpenses_name(), val / numOfMonth);
								
						} else {
							totalMeanExpenses=+Double.parseDouble(expenses.getAmount());
							meanOfExpenses.put(expenses.getExpenses_name(), Double.parseDouble(expenses.getAmount()));
						}
					}
					meanOfExpenses.put("TotalMeanExpenses", totalMeanExpenses);
				}

			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		return meanOfExpenses;
	}

	private HashMap<String, Double> meanOfIncome(SessionInfo session, int numOfMonth) {

		HashMap<String, List<Income>> monthlyIncomeHash = new HashMap<String, List<Income>>(3);
		HashMap<String, Double> meanOfIncome = new HashMap<String, Double>();
		double totalMeanIncome=0.0;
		try {
			String[] firstDateOfMonth = ApplicationUtilities.getFirstDateThreeMonths(Calendar.MONTH);
			String[] lastDateOfMonth = ApplicationUtilities.getLastDateThreeMonths(Calendar.MONTH);
			List<Income> listofIncome;
			for (int month = 0; month < numOfMonth; month++) {
				listofIncome = incomedao.retrieveIncomeByDate(firstDateOfMonth[month], lastDateOfMonth[month], session);
				if(!listofIncome.equals(null)) {
				monthlyIncomeHash.put(String.valueOf(month), listofIncome);
				}else {
					throw new BudgetPredictException("Data Insufficient to predict future month balance");
				}
			}

			for (int pmonth = 0; pmonth < numOfMonth; pmonth++) {
				if (pmonth == 0 || pmonth == 1) {
					List<Income> monthincome = monthlyIncomeHash.get(pmonth);
					for (Income income : monthincome) {
						if (meanOfIncome.containsKey(income.getIncome_category())) {
							double val = meanOfIncome.get(income.getIncome_category());
							val += Double.parseDouble(income.getAmount());
							meanOfIncome.put(income.getIncome_category(), val);

						} else {
							meanOfIncome.put(income.getIncome_category(), Double.parseDouble(income.getAmount()));
						}
					}
				}
				if (pmonth == 2) {
					List<Income> monthincome = monthlyIncomeHash.get(pmonth);
					for (Income income : monthincome) {
						if (meanOfIncome.containsKey(income.getIncome_category())) {
							double val = meanOfIncome.get(income.getIncome_category());
							val += Double.parseDouble(income.getAmount());
							totalMeanIncome = + (val/numOfMonth);
							meanOfIncome.put(income.getIncome_category(), val /numOfMonth);

						} else {
							totalMeanIncome=+Double.parseDouble(income.getAmount());
							meanOfIncome.put(income.getIncome_category(), Double.parseDouble(income.getAmount()));
						}
					}
					meanOfIncome.put("TotalMeanIncome", totalMeanIncome);
				}

			}

		} catch (Exception ex) {
			ex.getMessage();
		}
		return meanOfIncome;

	}
}
