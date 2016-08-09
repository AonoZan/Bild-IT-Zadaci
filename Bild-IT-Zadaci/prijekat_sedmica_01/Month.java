/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package prijekat_sedmica_01;


/**
 * Class that stores information about month.
 * @see <a href="https://en.wikipedia.org/wiki/Unix_time">Unix Time</a>
 */
public class Month {
	private int[] yearMonth = new int[2];
	private int[][] month = new int[6][7];
	private int[] reminders = new int[31];
	private StringBuilder displayString = new StringBuilder();
	private int startingDay;
	private int maxDayInMonth;
	
	Month() {
		this(2016);
	}
	Month(int year) {
		this(year, 1);
	}
	Month(int year, int month) {
		this.yearMonth[0] = year;
		this.yearMonth[1] = month;
		updateEverything();
	}
	public String getDisplayString() {
		return displayString.toString();
	}
	public int[] getYearMonth() {
		return yearMonth;
	}
	public int getCurrentMaxDay() {
		return Month.getMaxDay(this.yearMonth[0], this.yearMonth[1]);
	}
	/**
	 * Method for setting reminders count that can be used to mark days that contains reminders.
	 */
	public void setReminders(int[] reminders) {
		for (int i = 0; i < this.reminders.length; i++) {
			this.reminders[i] = reminders[i];
		}
	}
	/**
	 * Method that updates everything.
	 */
	private void updateEverything(){
		this.maxDayInMonth = getMaxDay(this.yearMonth[0], this.yearMonth[1]);	// recalculate maximum number of days
		this.startingDay = getStartingDay(this.yearMonth[0], this.yearMonth[1]);// recalculate first day in month
		updateMonth();															// update list that contains days
		updateMonthDisplay();													// update string that comntains month visualy represented
	}
	/**
	 * Method for jumping on another month
	 * @param year
	 * @param month
	 */
	public void updateDate(int year, int month) {
		this.yearMonth[0] = year;
		this.yearMonth[1] = month;	// update year and month date	
		updateEverything();			// and recalculate everything
	}
	/**
	 * Method for converting numbers into month names.
	 * @param month number from 1 to 12
	 * @return Month name eg. January
	 */
	public static String getMonthName(int month) {
		switch (month) {
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4:
				return "April";
			case 5:
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8:
				return "Avgust";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11:
				return "November";
			case 12:
				return "December";
			default:
				System.out.printf("Cant return month name. Invalid argument(%d).\n", month);
				return "";
		}
		
	}
	/**
	 * Simple method for checking if year is leap.
	 * @param year any number representing year
	 * @return true if year is leap, false if year is zero, negative or not leap
	 */
	public static boolean isLeap(int year){
		// year is leap if it's divisable with 4 and not with 100 or if divisable with 400
		if (year > 0 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) return true;
		return false;
	}
	/**
	 * Method for retriving max number of days for certain month.
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMaxDay(int year, int month) {
		if (month < 1 || month > 12 || year < 1) {
			System.out.println("Can't return max value for month(wrong argument).");
			return 0;
		}
		if (month == 2) return isLeap(year) ? 29 : 28;
		else if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
		else return 31;
		
	}
	// Method from book(Java Essensials)
	/** Get the start day of month/1/year */
	public static int getStartingDay(int year, int month) {
		final int START_DAY_FOR_JAN_1_1800 = 3;
		// Get total number of days from 1/1/1800 to month/1/year
		int totalNumberOfDays = getTotalNumberOfDays(year, month);
		
		// Return the start day for month/1/year
		return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
	}
	// Method from book(Java Essensials)
	/** Get the total number of days since January 1, 1800 */
	public static int getTotalNumberOfDays(int year, int month) {
		int total = 0;
		// Get the total days from 1800 to 1/1/year
		for (int i = 1800; i < year; i++)
			if (isLeap(i))
				total = total + 366;
			else
				total = total + 365;
		// Add days from Jan to the month prior to the calendar month
		for (int i = 1; i < month; i++)
			total = total + getMaxDay(year, i);
		return total;
	}
	/**
	 * Method that updates 2D list of days.
	 */
	private void updateMonth() {
		// for every week and day
		for (int i = 0; i < this.month.length; i++) {
			for (int j = 0; j < this.month[i].length; j++) {
				// if it's smaller than starting day in a week skip
				int currentDay;
				if (i == 0 && j < startingDay) {
					this.month[i][j] = 0;
					continue;
				}
				// if it's not bigger than max day in month add it to the list else add 0
				if ((currentDay = (this.month[i].length * i) + (j + 1) - this.startingDay) <= this.maxDayInMonth)
					this.month[i][j] = currentDay;
				else this.month[i][j] = 0;
			}
		}
	}
	/**
	 * Method that constructs string that represent month
	 */
	public void updateMonthDisplay() {
		this.displayString.setLength(0);										// reset each time
		this.displayString.append(" Sun   Mon   Tue   Wed   Thu   Fri   Sat\n");// add names of days
		String marked = "|", non_marked = " ";									// create strings that wil be used to mark days that have reminders
		String day, reminder = non_marked;										// create day and set it's not marked
		for (int[] is : month) {												// loop for ewery week in month
			for (int i : is) {													// and for every day in week
				try {															// if theres reminders on that day mark it
					reminder = reminders[i - 1] > 0 ? marked : non_marked;
				} catch (Exception e) {}
				// build string for each day
				day = String.format(" %s%2s%s ",
						reminder,
						i > 0 ? i + "" : "  ",
						reminder);
				// append that string and reset reminder
				this.displayString.append(day);
				reminder = non_marked;
			}
			this.displayString.append("\n");
		}
	}
}
