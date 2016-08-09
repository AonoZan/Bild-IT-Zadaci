/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_08_08_2016;

public class Zadatak_02 {
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
	/**
	 * Program asks user for date (month and year) and then prints maximum number days in that month.
	 * @param args
	 */
	public static void main(String[] args) {
		// create variable for month and year and ask user for values
		int month = 0, year = 0;
		System.out.println("Enter values for date.");
		while (true) {
			try {
				// if value for month is still on default ask for another one
				if (month == 0) {
					System.out.print("Enter month(1 - 12): ");
					month = zadaci_01_08_2016.Zadatak_05.readFromConsole(month);
					// if user enters wrong value for month reset it and ask again
					if (month < 1 || month > 12) {
						System.out.printf("%d is incorrect value for month.", month);
						month = 0;
						throw new Exception("Try again..");
					}
				}
				// if value for month is still on default ask for another one
				if (year == 0) {
					System.out.print("Enter year: ");
					year = zadaci_01_08_2016.Zadatak_05.readFromConsole(year);
					// if user enters zero or negative year reset it and ask again
					if (year < 1) {
						System.out.printf("%d is incorrect value for year.", year);
						year = 0;
						throw new Exception("Try again..");
					}
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// print message and close scanner
		System.out.printf("%s of %d had %d days.\n",
				getMonthName(month),
				year,
				getMaxDay(year, month));
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
