package SpringSemester.budgetsystem.beans;

import java.util.ArrayList;
import java.util.List;


public class Income {
	private String income_id,user_id,income_date,income_type,income_category,income_desc,amount,remark,created_on;
	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	private List<Income> incomeList = new ArrayList<Income>();
	
	public Income() {
	
		System.out.println("Bean IncomeDao -- Loaded()");
	}
	
	public String getIncome_id() {
		return income_id;
	}
	public void setIncome_id(String income_id) {
		this.income_id = income_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getIncome_date() {
		return income_date;
	}
	public void setIncome_date(String income_date) {
		this.income_date = income_date;
	}
	public String getIncome_type() {
		return income_type;
	}
	public void setIncome_type(String income_type) {
		this.income_type = income_type;
	}
	public String getIncome_category() {
		return income_category;
	}
	public void setIncome_category(String income_category) {
		this.income_category = income_category;
	}
	public String getIncome_desc() {
		return income_desc;
	}
	public void setIncome_desc(String income_desc) {
		this.income_desc = income_desc;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<Income> getIncomeList() {
		return incomeList;
	}
	public void setIncomeList(List<Income> incomeList) {
		this.incomeList = incomeList;
	}


}
