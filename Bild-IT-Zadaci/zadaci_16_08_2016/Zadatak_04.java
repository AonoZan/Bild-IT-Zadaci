
package zadaci_16_08_2016;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	final static int UTC = 2;
	/**
	 * Method for checking if year is leap or not.
	 * @param year
	 * @return
	 */
	public static boolean isLeap(int year) {
		// leap if it's divisible with 4 but not with 100
		// or if it's divisible with 400
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		}
		return false;
	}
	/**
	 * Method for retrieving maximum days in a year.
	 * @param year
	 * @return
	 */
	public static int yearDays(int year) {
		if (isLeap(year)) {
			return 366;		// leap years have 366 other have 365
		} else {
			return 365;
		}
	}
	/**
	 * Method for retrieving max number of days for certain month.
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMaxDay(int year, int month) {
		// if invalid arguments;
		if (month < 1 || month > 12) {
			System.out.println("Cant retrive max day. Invalid argiment.");
			return 0;
		}
		// for leap years return 29 or 28 for others 30 or 31
		if (month == 2) {
			return isLeap(year) ? 29 : 28;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else return 31;
	}
	/**
	 * Method for retrieving date from milliseconds.
	 * @param millis
	 * @return
	 */
	public static String date(long millis) {
		// convert milliseconds to days
		long days = millis / 1000 / 60 / 60 / 24;
		// Unix starting year is 1970
		int year = 1970;
		// count years until year days can be subtracted from total days
		while (yearDays(year) < days) {
			days -= yearDays(year);
			year++;
		}
		int month = 1;
		// count months until month days can be subtracted from total days
		while (getMaxDay(year, month) < days) {
			days -= getMaxDay(year, month);
			month++;
		}
		// add one day to fix and return formated string
		days++;
		return String.format("%d-%d-%d",
				days,
				month,
				year);
	}
	/**
	 * Method for retrieving current time.
	 * @param millis
	 * @return
	 */
	public static String time(long millis) {
		// create string
		String time = new String();
		// convert milliseconds to second and add seconds to time
		int seconds = (int)(millis / 1000);
		time += seconds % 60;
		// convert seconds to minutes and add minutes
		int minutes = seconds / 60;
		time = minutes % 60 + ":" + time;
		// convert minutes to hours and add hours shifted to utc time
		int hours = minutes / 60;
		time = (hours % 24 + UTC) + ":" + time;
		
		return time;
	}
	/**
	 * Method for retrieving current time and date.
	 * @param millis
	 * @return
	 */
	public static String dateAndTime(long millis) {
		return time(millis) + " " + date(millis);
	}
	/**
	 * Program prints current time and date.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(dateAndTime(System.currentTimeMillis()));
	}

}

