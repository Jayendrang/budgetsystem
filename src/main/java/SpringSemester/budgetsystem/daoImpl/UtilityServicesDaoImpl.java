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

import SpringSemester.budgetsystem.beans.ApplicationData;
import SpringSemester.budgetsystem.dao.UtilityServiceDao;

@Repository
@Qualifier("utilityservicesdao")
public class UtilityServicesDaoImpl implements UtilityServiceDao {

	@Autowired
	JdbcTemplate template;
	public UtilityServicesDaoImpl() {

		System.out.println("Utility services Dao -- Started()");
	}
	
	@Override
	public List<ApplicationData> retrieveIncomeType() {
		try {
		String retrieveIncomeQuery="select code,type from app_data where type like 'ITYP%' order by type";
		List<ApplicationData> incomeTypes = template.queryForObject(retrieveIncomeQuery,new appDataInfoMapper()); 
		return incomeTypes;
		}catch(Exception ex) {
		ex.printStackTrace();
		}
		return null;
		}

	@Override
	public List<ApplicationData> retrieveExpensesType() {
		try {
			String retrieveExpensesQuery="select code,type from app_data where type like 'ETYP%' order by type";
			List<ApplicationData> incomeTypes = template.queryForObject(retrieveExpensesQuery,new appDataInfoMapper()); 
			return incomeTypes;
			}catch(Exception ex) {
			ex.printStackTrace();
			}
			return null;
	}

	@Override
	public List<ApplicationData> retrieveProfileType() {
		try {
			String retrieveProfileType="select code,type from app_data where type ='PROFILE' order by type";
			List<ApplicationData> incomeTypes = template.queryForObject(retrieveProfileType,new appDataInfoMapper()); 
			return incomeTypes;
			}catch(Exception ex) {
			ex.printStackTrace();
			}
			return null;
	}

	@Override
	public List<ApplicationData> retrieveSecurityQuestions() {
		try {
			String retrieveSecQuestions="select code,type from app_data where type='SECQUES' order by code";
			List<ApplicationData> incomeTypes = template.queryForObject(retrieveSecQuestions,new appDataInfoMapper()); 
			return incomeTypes;
			}catch(Exception ex) {
			ex.printStackTrace();
			}
			return null;
	}

	class appDataInfoMapper implements RowMapper<List<ApplicationData>>{

		@Override
		public synchronized List<ApplicationData> mapRow(ResultSet rs, int arg1) throws SQLException {
		
			List<ApplicationData> utilities = new ArrayList<ApplicationData>();
			while(rs.next()) {
				ApplicationData utility = new ApplicationData();
			utility.setCode(rs.getString("code"));
			utility.setType(rs.getString("type"));
			utilities.add(utility);	
				
			}
			
			return utilities;
		}

		
	}
}
