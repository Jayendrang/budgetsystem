package SpringSemester.budgetsystem.beans;

import java.util.ArrayList;
import java.util.List;



public class Reminder {
	private String event_id,user_id,date,even_description,expenses_id,event_start_date,event_end_date,event_notification_flag,modified_by,modified_on;
	private int event_occurence_count,counter;
	private List<Reminder> listOfReminder = new ArrayList<Reminder>();

	public Reminder() {
			System.out.println("Bean Reminder -- Loaded()");
		
	}
	
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEven_description() {
		return even_description;
	}
	public void setEven_description(String even_description) {
		this.even_description = even_description;
	}
	public String getExpenses_id() {
		return expenses_id;
	}
	public void setExpenses_id(String expenses_id) {
		this.expenses_id = expenses_id;
	}
	public String getEvent_start_date() {
		return event_start_date;
	}
	public void setEvent_start_date(String event_start_date) {
		this.event_start_date = event_start_date;
	}
	public String getEvent_end_date() {
		return event_end_date;
	}
	public void setEvent_end_date(String event_end_date) {
		this.event_end_date = event_end_date;
	}
	public String getEvent_notification_flag() {
		return event_notification_flag;
	}
	public void setEvent_notification_flag(String event_notification_flag) {
		this.event_notification_flag = event_notification_flag;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public String getModified_on() {
		return modified_on;
	}
	public void setModified_on(String modified_on) {
		this.modified_on = modified_on;
	}
	public int getEvent_occurence_count() {
		return event_occurence_count;
	}
	public void setEvent_occurence_count(int event_occurence_count) {
		this.event_occurence_count = event_occurence_count;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

	public List<Reminder> getListOfReminder() {
		return listOfReminder;
	}

	public void setListOfReminder(List<Reminder> listOfReminder) {
		this.listOfReminder = listOfReminder;
	}
	
		
}
