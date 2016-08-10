/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_10_08_2016;

public class Zadatak_01 {
	/**
	 * Method returns maximum days of year.
	 * If year is leap then it has 366 days, else year has 365 days.
	 * @param year
	 * @return
	 */
	public static int numberOfDayInAYear(int year) {
		// if year is leap return 366 else return 365
		return zadaci_08_08_2016.Zadatak_02.isLeap(year) ? 366 : 365;
	}
	/**
	 * Program asks user to enter two year and then prints ho many days each had in that range years.
	 * @param args
	 */
	public static void main(String[] args) {
		// create variables for range and ask user for values
		int startingYear = 0, endingYear = 0;
		while (true) {
			try {
				// if value for starting year on default value get new one
				if (startingYear == 0) {
					System.out.print("Enter value for starting year: ");
					startingYear = zadaci_01_08_2016.Zadatak_05.readFromConsole(startingYear);
					// if user enters number less than 1 it's wrong value reset and ask again
					if (startingYear < 1) {
						System.out.printf("%d is wrong value for year.\n", startingYear);
						startingYear = 0;
						throw new Exception("Enter new value.");
					}
				}
				// if value fpr ending year on default get new one
				if (endingYear == 0) {
					System.out.print("Enter value for ending year: ");
					endingYear = zadaci_01_08_2016.Zadatak_05.readFromConsole(endingYear);
					// if user enters value less than first year it's wrong value reset and ask again
					if (endingYear < startingYear) {
						System.out.printf("Ending year must be bigger than %d.\n", startingYear);
						endingYear = 0;
						throw new Exception("Enter new value.");
					}
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// loop for each year in range and print how much days it has
		for (int i = startingYear; i <= endingYear; i++) {
			System.out.printf("Year %d = %d days.\n",
					i,
					numberOfDayInAYear(i));
		}
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
