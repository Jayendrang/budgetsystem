package SpringSemester.budgetsystem.beans;



public class ApplicationData {

	public ApplicationData() {
		System.out.println("Application support bean");
	}
	
	private String code,type,details;
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
	
	
}
