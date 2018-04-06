package SpringSemester.budgetsystem.beans;


public class UserInfo {
private String user_id,user_fname,user_lname,user_type,email_id,mobile_contact,password,address,profile_creation_date;
private String rec1_ques,rec1_ans,rec2_ques,rec2_ans;
private String last_log_time;

public UserInfo() {

	System.out.println("Bean UserInfo--Loaded()");
}

public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getUser_fname() {
	return user_fname;
}
public void setUser_fname(String user_name) {
	this.user_fname = user_name;
}

public String getUser_lname() {
	return user_lname;
}
public void setUser_lname(String user_lname) {
	this.user_lname = user_lname;
}
public String getUser_type() {
	return user_type;
}
public void setUser_type(String user_type) {
	this.user_type = user_type;
}
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}
public String getMobile_contact() {
	return mobile_contact;
}
public void setMobile_contact(String mobile_contact) {
	this.mobile_contact = mobile_contact;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getProfile_creation_date() {
	return profile_creation_date;
}
public void setProfile_creation_date(String profile_creation_date) {
	this.profile_creation_date = profile_creation_date;
}
public String getRec1_ques() {
	return rec1_ques;
}
public void setRec1_ques(String rec1_ques) {
	this.rec1_ques = rec1_ques;
}
public String getRec1_ans() {
	return rec1_ans;
}
public void setRec1_ans(String rec1_ans) {
	this.rec1_ans = rec1_ans;
}
public String getRec2_ques() {
	return rec2_ques;
}
public void setRec2_ques(String rec2_ques) {
	this.rec2_ques = rec2_ques;
}
public String getRec2_ans() {
	return rec2_ans;
}
public void setRec2_ans(String rec2_ans) {
	this.rec2_ans = rec2_ans;
}
public String getLast_log_time() {
	return last_log_time;
}
public void setLast_log_time(String last_log_time) {
	this.last_log_time = last_log_time;
}


}
