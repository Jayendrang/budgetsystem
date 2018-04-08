package SpringSemester.budgetsystem.beans;

import java.util.HashMap;

public class ApplicationData {

	public ApplicationData() {
		System.out.println("Application support bean");
	}
	private String code,type,details;
	private HashMap<String, ApplicationData> applicationDataCollection = new HashMap<>();
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public HashMap<String, ApplicationData> getApplicationDataCollection() {
		return applicationDataCollection;
	}
	public void setApplicationDataCollection(HashMap<String, ApplicationData> applicationDataCollection) {
		this.applicationDataCollection = applicationDataCollection;
	}
	
	
}
