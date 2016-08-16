/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_15_08_2016;

public class Zadatak_01 {
	/**
	 * Method for retrieving month name from number.
	 * 1 is for January, 2 for February etc...
	 * @param month
	 * @return Month name as string eg. "January",
	 * Empty string "" if number is invalid.
	 */
	public static String getMonthName(int month) {
		// Return month name or empty name
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
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			System.out.print("Cant retrive month nome(arg " + month + ")");
			return "";
		}
	}
	/**
	 * Program generates random month and prints it on the console.
	 * @param args
	 */
	public static void main(String[] args) {
		// define constant for month min and max
		final int MIN_MONTH = 1;
		final int MAX_MONTH = 12;
		// generate random number and print month name using that number
		int month = MIN_MONTH + (int)(Math.random() * MAX_MONTH);
		System.out.printf("Random month is %s.",
				getMonthName(month));
	}

}
