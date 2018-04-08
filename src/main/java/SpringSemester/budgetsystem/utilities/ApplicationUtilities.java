package SpringSemester.budgetsystem.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;

public class ApplicationUtilities {

	//General User status
	public static String ACTIVE_STATUS="ACTIVE";
	public static String INACTIVE_STATUS="INACTIVE";
	// Current Date
	public static String getCurrentDate() {

		SimpleDateFormat currentDate = new SimpleDateFormat("YYYY-MM-dd");
		Date date = new Date();
		return currentDate.format(date).toString();
	}

	// Current date and time
	public static String getCurrentDateAndTime() {
		SimpleDateFormat currentDateTime = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		Date date = new Date();
		return currentDateTime.format(date).toString();

	}

	// Random UserID
	public static String getRandomUserID(String fName, String lName) {
		StringBuilder userID = new StringBuilder();
		String randomAlphaNumeric = RandomStringUtils.randomAlphabetic(6);
		userID.append(lName.substring(0, 2));
		userID.append(randomAlphaNumeric);
		userID.append(fName.substring(0, 2));
		return userID.toString();
	}

	// Random Expenses ID
	public static String getRandomExpensesID() {
		StringBuilder expensesID = new StringBuilder();
		String randamAlphaNumeric = RandomStringUtils.randomAlphabetic(6);
		expensesID.append("ex");
		expensesID.append(randamAlphaNumeric);
		return expensesID.toString();
	}

	// Random Income ID
	public static String getRandomIncomeID() {
		StringBuilder expensesID = new StringBuilder();
		String randamAlphaNumeric = RandomStringUtils.randomAlphabetic(6);
		expensesID.append("inc");
		expensesID.append(randamAlphaNumeric);
		return expensesID.toString();
	}

	public static void main(String[] arg) {
		System.out.println(ApplicationUtilities.getCurrentDate());
		System.out.println(ApplicationUtilities.getCurrentDateAndTime());
		System.out.println(ApplicationUtilities.getRandomExpensesID());
		System.out.println(ApplicationUtilities.getRandomUserID("Jayendran", "Gurumoorthy"));
		System.out.println(ApplicationUtilities.getRandomIncomeID());
	}
}
