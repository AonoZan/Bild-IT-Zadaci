/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package prijekat_sedmica_01;
/**
 * 
 * @author AonoZan
 * @see <a href="https://en.wikipedia.org/wiki/Unix_time">Unix Time</a>
 */
public class Month {
	private int[] yearMonth = new int[2];
	private int[][] month = new int[6][7];
	private int[] reminders = new int[31];
	private StringBuilder displayString = new StringBuilder();
	private int startingDay = 1;
	
	Month() {
		this(1970);
	}
	Month(int year) {
		this(1970, 1);
	}
	Month(int year, int month) {
		this.yearMonth[1] = year;
		this.yearMonth[0] = month;
		reminders[30] = 2;
		reminders[11] = 2;
		for (int i = 0; i < this.month.length; i++) {
			for (int j = 0; j < this.month[i].length; j++) {
				this.month[i][j] = (this.month[i].length * i) + (j + 1);
			}
		}
		updateMonthDisplay();
	}
	/**
	 * 
	 * @param month
	 * @return
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
		if (year > 0 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) return true;
		return false;
	}
	// 31 29 31 30 31 30 31 31 30 31 30 31
	public static int getMaxDayInMonth(int year, int month) {
		if (month < 1 || month > 12 || year < 1) {
			System.out.println("Can't return max value for month(wrong argument).");
			return 0;
		}
		if (month == 2) return isLeap(year) ? 29 : 28;
		else if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
		else return 31;
		
	}
	private void updateMonthDisplay() {
		this.displayString.append("\t      " + getMonthName(yearMonth[0]) + " " + yearMonth[1] +"\n");
		this.displayString.append("_________________________________________\n");
		this.displayString.append(" Sun   Mon   Tue   Wed   Thu   Fri   Sat\n");
		String day, reminder = "";
		for (int[] is : month) {
			for (int i : is) {
				try {
					reminder = reminders[i - 1] > 0 ? "|" : " ";
				} catch (Exception e) {

				}
				day = String.format(" %s%2s%s ",
						reminder,
						i > 0 ? i + "" : "__",
						reminder);
				this.displayString.append(day);
			}
			this.displayString.append("\n");
		}
		System.out.println(displayString);
	}
}
