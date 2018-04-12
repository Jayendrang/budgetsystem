package SpringSemester.budgetsystem.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import SpringSemester.budgetsystem.beans.Expenses;
import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.dao.ExpenesesDao;
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

@Repository
@Qualifier("expensesdao")
public class ExpensesDaoImpl implements ExpenesesDao {

	@Autowired
	JdbcTemplate template;
	
	public ExpensesDaoImpl() {
		System.out.println("Expenses Dao --- created()");
	}
	
	@Override
	public boolean addExpenses(List<Expenses> expenses,SessionInfo session) {
		int status=0;
		boolean result=false;
		
		try {
		for(Expenses expense : expenses) {
		String insertQuery="insert into sor_expenses (expenses_id,user_id,expenses_date,expenses_name,expenses_type,expenses_desc,amount,remark,created_on) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		status=template.update(insertQuery,new Object[] {
				ApplicationUtilities.getRandomExpensesID(),
				session.getUserName(),
				expense.getExpenses_date(),
				expense.getExpenses_name(),
				expense.getExpneses_type(),
				expense.getExpenses_desc(),
				Double.parseDouble(expense.getAmount()),
				expense.getRemark(),
				ApplicationUtilities.getCurrentDate()
		});
		result = status>0?true:false;
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
		return result;
	}

	@Override
	public boolean updateExpenses(Expenses expenses,SessionInfo session) {
		String udpateQueryExpenses="update sor_expenses set expenses_date=?,expenses_name=?,expenses_type=?,expenses_desc=?,amount=?,remark=? where expenses_id =? and user_id=?;";
		boolean result = false;
		try {
			
			int status = template.update(udpateQueryExpenses,new Object[] {
					expenses.getExpenses_date(),
					expenses.getExpenses_name(),
					expenses.getExpneses_type(),
					expenses.getExpenses_desc(),
					Double.parseDouble(expenses.getAmount()),
					expenses.getRemark(),
					expenses.getExpenses_id(),
					session.getUserName()
			});
			result = status>0?true:false;
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public List<Expenses> retrieveAllExpenses(SessionInfo session) {
		String selectAllExpenses="select expenses_id,expenses_date,expenses_name,expenses_type,expenses_desc,amount,remark from sor_expenses where user_id=?";
		List<Expenses> expensesList = new ArrayList<>();
		try {
			expensesList = template.queryForObject(selectAllExpenses, new Object[] {session.getUserName()},new ExpensesDataMapper());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return expensesList;
	}

	@Override
	public List<Expenses> retrieveExpensesByDate(String fromDate, String toDate, SessionInfo session) {
		String selectExepenseDate="select expenses_id,expenses_date,expenses_name,expenses_type,expenses_desc,amount,remark from sor_expenses where user_id=? and expenses_date between ? and ? ;";
		List<Expenses> expensesList = new ArrayList<>();
		try {
			expensesList = template.queryForObject(selectExepenseDate, new Object[] {session.getUserName(),fromDate,toDate}, new ExpensesDataMapper());
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return expensesList;
	}

	@Override
	public boolean deleteExpenses(List<Expenses> expenses,SessionInfo session) {
	
		String deleteQuery = "delete from sor_expenses where expenses_id=? and  user_id =?";
		int result =0;
		boolean status = false;
		try {
			for(Expenses texpenses:expenses) {
			result = template.update(deleteQuery,texpenses.getExpenses_id(),session.getUserName());
			status = result>0?true:false;
			}
		}catch(Exception ex) {
		ex.printStackTrace();
		}
		
		return status;
	}

	class ExpensesDataMapper implements RowMapper<List<Expenses>>{

		private List<Expenses> expensesList = new ArrayList<>();
		@Override
		public List<Expenses> mapRow(ResultSet resultset, int arg1) throws SQLException {
			
			while(resultset.next()) {
			Expenses expense = new Expenses();
			
			expense.setExpenses_id(resultset.getString("expenses_id"));
			expense.setExpenses_date(resultset.getString("expenses_date"));
			expense.setExpenses_name(resultset.getString("expenses_name"));
			expense.setExpneses_type(resultset.getString("expenses_type"));
			expense.setExpenses_desc(resultset.getString("expenses_desc"));
			expense.setAmount(String.valueOf(resultset.getDouble("amount")));
			expense.setRemark(resultset.getString("remark"));
			expensesList.add(expense);
			}
			return expensesList;
		}
		
		
		
	}
}
