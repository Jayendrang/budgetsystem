package SpringSemester.budgetsystem.exceptions;

public class BudgetPredictException extends Exception {

	/**
	 * Exception serival version
	 */
	private static final long serialVersionUID = 1L;
	
	private String message = null;
	
	public BudgetPredictException() {
	}
	
	public BudgetPredictException(String msg) {
		this.message=msg;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	@Override
	public String toString() {
		
		return message;
	}

}
