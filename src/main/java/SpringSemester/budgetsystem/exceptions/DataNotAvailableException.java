package SpringSemester.budgetsystem.exceptions;

public class DataNotAvailableException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message=null;
	
	public DataNotAvailableException() {
		
	}
	public DataNotAvailableException(String msg) {
		this.message=msg;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	public String toString() {
		return this.message;
	}

}
