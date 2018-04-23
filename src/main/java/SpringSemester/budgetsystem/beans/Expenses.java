package SpringSemester.budgetsystem.beans;
import java.util.ArrayList;
import java.util.List;


public class Expenses {
	
private String expenses_id,user_id,expenses_date,expenses_type,expenses_name,expenses_desc,amount,remark,created_on;
public String getCreated_on() {
	return created_on;
}

public void setCreated_on(String created_on) {
	this.created_on = created_on;
}

public Expenses() {
	System.out.println("Bean Expenses -- Loaded()");
	
}

public String getExpenses_id() {
	return expenses_id;
}

public void setExpenses_id(String expenses_id) {
	this.expenses_id = expenses_id;
}

public String getUser_id() {
	return user_id;
}

public void setUser_id(String user_id) {
	this.user_id = user_id;
}

public String getExpenses_date() {
	return expenses_date;
}

public void setExpenses_date(String expenses_date) {
	this.expenses_date = expenses_date;
}

public String getExpenses_type() {
	return expenses_type;
}

public void setExpenses_type(String expenses_type) {
	this.expenses_type = expenses_type;
}

public String getExpenses_name() {
	return expenses_name;
}

public void setExpenses_name(String expenses_name) {
	this.expenses_name = expenses_name;
}

public String getExpenses_desc() {
	return expenses_desc;
}

public void setExpenses_desc(String expenses_desc) {
	this.expenses_desc = expenses_desc;
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

}
