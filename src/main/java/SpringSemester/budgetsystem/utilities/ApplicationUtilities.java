package SpringSemester.budgetsystem.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.RandomStringUtils;

import SpringSemester.budgetsystem.beans.SessionInfo;

public class ApplicationUtilities {

	// General User status
	public static String ACTIVE_STATUS = "ACTIVE";
	public static String INACTIVE_STATUS = "INACTIVE";
	public static String USER_TYPE_GENERAL = "GNUSR";
	public static String USER_TYPE_ADMIN = "ADMIN";
	private static HashMap<String, String> expensesListMap = new HashMap<>();
	private static HashMap<String, String> incomeListMap = new HashMap<>();
	private static HashMap<String, String> userProfiletypesMap = new HashMap<>();
	private static HashMap<String, String> securityQuestionsMap = new HashMap<>();
	private static SessionInfo session = new SessionInfo();
	
	public static SessionInfo getSession() {
		System.out.println("Getsession called");
		return session;
	}

	public static void setSession(SessionInfo lsession) throws NullPointerException {
				session = lsession;
		System.out.println("Session resumed"+session.getFname()+""+session.getUserName());
		
	}

	// Last date of 3 months
	public static String[] getLastDateThreeMonths(int month, boolean thismonth) {
		String[] sysMonth = new String[3];

		try {
			Calendar calendar = Calendar.getInstance();
			if(thismonth) {
				calendar.set(calendar.MONTH, month--);
				calendar.set(calendar.DAY_OF_MONTH, 0);
				Date ds = calendar.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sysMonth[0] = sdf.format(ds).toString();
		
			}else {
			for (int i = 0; i < 3; i++) {
					{
						calendar.set(calendar.MONTH, month--);
						calendar.set(calendar.DAY_OF_MONTH, 0);
						Date ds = calendar.getTime();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						sysMonth[i] = sdf.format(ds).toString();
					}
			}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sysMonth;
	}

	// First date of three month
	public static String[] getFirstDateThreeMonths(int month, boolean thismonth) {
		String[] sysMonth = new String[3];

		try {
			Calendar calendar = Calendar.getInstance();
			if(thismonth) {
				calendar.set(calendar.MONTH, --month);
				calendar.set(calendar.DAY_OF_MONTH, 1);
				Date ds = calendar.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println(sdf.format(ds).toString());
				sysMonth[0] = sdf.format(ds).toString();
		
			}else {
				for (int i = 0; i < 3; i++) {
					{
						calendar.set(calendar.MONTH, --month);
						calendar.set(calendar.DAY_OF_MONTH, 1);
						Date ds = calendar.getTime();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						System.out.println(sdf.format(ds).toString());
						sysMonth[i] = sdf.format(ds).toString();
					}
					}
				}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sysMonth;
	}

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
		StringBuilder incomeID = new StringBuilder();
		String randamAlphaNumeric = RandomStringUtils.randomAlphabetic(6);
		incomeID.append("inc");
		incomeID.append(randamAlphaNumeric);
		return incomeID.toString();
	}

	// Random ReminderID
	public static String getReminderID() {
		StringBuilder reminderID = new StringBuilder();
		String randamAlphaNumeric = RandomStringUtils.randomAlphabetic(6);
		reminderID.append("rim");
		reminderID.append(randamAlphaNumeric);
		return reminderID.toString();
	}

	public static String getExpensesListMap(String key) {
		return (String) expensesListMap.get(key);
	}

	public void setExpensesListMap(HashMap<String, String> expensesListMap) {
		this.expensesListMap = expensesListMap;
	}

	public static String getIncomeListMap(String key) {
		return (String) incomeListMap.get(key);
	}

	public void setIncomeListMap(HashMap<String, String> incomeListMap) {
		this.incomeListMap = incomeListMap;
	}

	public static String getUserProfiletypesMap(String key) {
		return (String) userProfiletypesMap.get(key);
	}

	public void setUserProfiletypesMap(HashMap<String, String> userProfiletypesMap) {
		this.userProfiletypesMap = userProfiletypesMap;
	}

	public static String getSecurityQuestionsMap(String key) {
		return securityQuestionsMap.get(key);
	}

	public void setSecurityQuestionsMap(HashMap<String, String> securityQuestionsMap) {
		this.securityQuestionsMap = securityQuestionsMap;
	}

	public static void main(String[] arg) {
		// System.out.println(ApplicationUtilities.getCurrentDate());
		// System.out.println(ApplicationUtilities.getCurrentDateAndTime());
		// System.out.println(ApplicationUtilities.getRandomExpensesID());
		// System.out.println(ApplicationUtilities.getRandomUserID("Jayendran",
		// "Gurumoorthy"));
		// System.out.println(ApplicationUtilities.getRandomIncomeID());

		ApplicationUtilities.getFirstDateThreeMonths(Calendar.getInstance().get(Calendar.MONTH)+1,true);
		ApplicationUtilities.getLastDateThreeMonths(Calendar.getInstance().get(Calendar.MONTH)+1,true);
	}
}
