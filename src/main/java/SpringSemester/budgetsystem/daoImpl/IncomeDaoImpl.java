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
import SpringSemester.budgetsystem.beans.Income;
import SpringSemester.budgetsystem.beans.SessionInfo;
import SpringSemester.budgetsystem.dao.IncomeDao;
import SpringSemester.budgetsystem.utilities.ApplicationUtilities;

@Repository
@Qualifier("incomedao")
public class IncomeDaoImpl implements IncomeDao {

	@Autowired
	JdbcTemplate template;

	public IncomeDaoImpl() {

		System.out.println("Income dao -- created()");
	}

	@Override
	public boolean addIncome(List<Income> incomelist,SessionInfo session) {
		int status = 0;
		boolean result = false;

		try {
			for (Income income : incomelist) {
				String insertQuery = "insert into sor_income(income_id,user_id,income_Date,income_name,income_type,income_desc,amount,remark,created_on) "
						+ "values(?,?,?,?,?,?,?,?,?)";
				
				status = template.update(insertQuery,
						new Object[] { ApplicationUtilities.getRandomIncomeID(),
								session.getUserName(),
								income.getIncome_date(), 
								income.getIncome_category(),
								income.getIncome_type(),
								income.getIncome_desc(),
								Double.parseDouble(income.getAmount()),
								income.getRemark(),
								ApplicationUtilities.getCurrentDate() });
			
				System.out.println("Query"+status);
				result = status > 0 ? true : false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	@Override
	public boolean updateIncome(Income income,SessionInfo session) {

		String updateQueryIncome = "update sor_income set income_Date=?,income_type=?,income_name=?,income_desc=?,amount=?,remark=? where income_id=? and user_id=?";
		boolean result = false;
		try {

			int status = template.update(updateQueryIncome,
					new Object[] { income.getIncome_date(), income.getIncome_type(), income.getIncome_category(),
							income.getIncome_desc(), Double.parseDouble(income.getAmount()), income.getRemark(),
							income.getIncome_id(), session.getUserName() });
			result = status > 0 ? true : false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Income> retrieveAllIncomes(SessionInfo session) {
		String selectQuery = "select income_id,user_id,income_Date,income_type,income_name,income_desc,amount,remark,created_on from sor_income where user_id=?";
		List<Income> incomeList = new ArrayList<Income>();
		try {
			incomeList=template.queryForObject(selectQuery, new Object[] {session.getUserName()},new IncomeDataMapper());
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return incomeList;
	}

	@Override
	public List<Income> retrieveIncomeByDate(String fromDate, String toDate, SessionInfo session) {
		String selectQuery ="select income_id,user_id,income_Date,income_type,income_name,income_desc,amount,remark,created_on from sor_income where user_id=? and income_Date between ? and ?";
		List<Income> incomeList = new ArrayList<Income>();
		try {
			incomeList = template.queryForObject(selectQuery, new Object[] {session.getUserName(),fromDate,toDate}, new IncomeDataMapper());
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return incomeList;
	}

	@Override
	public boolean deleteIncome(List<Income> incomelist,SessionInfo session) {
		String deleteQuery = "delete from sor_income where income_id=? and user_id=?";
		boolean result=false;
		int executioncount=0,listcount=incomelist.size();
		
		try {
			for(Income income:incomelist) {
				executioncount=+template.update(deleteQuery,new Object[] {income.getIncome_id(),session.getUserName()});
				
			}
			if(executioncount==listcount) {
				result=true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	class IncomeDataMapper implements RowMapper<List<Income>> {

		private List<Income> incomeList = new ArrayList<>();

		@Override
		public List<Income> mapRow(ResultSet resultset, int arg1) throws SQLException {

			while (resultset.next()) {
				Income income = new Income();

				income.setIncome_id(resultset.getString("income_id"));
				income.setIncome_date(resultset.getString("income_Date"));
				income.setIncome_category(resultset.getString("income_name"));
				income.setIncome_type(resultset.getString("income_type"));
				income.setIncome_desc(resultset.getString("income_desc"));
				income.setAmount(String.valueOf(resultset.getDouble("amount")));
				income.setRemark(resultset.getString("remark"));
				income.setCreated_on(resultset.getString("created_on"));
				incomeList.add(income);
			}
			return incomeList;
		}

	}
}
