/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_09_08_2016;

public class Zadatak_01 {
	/**
	 * Program asks user for two values.
	 * First value represent todays day as number from 0 to 6, which means 0 is monday, 1 is Tuesday and so on.
	 * Second value represent number of days after that day.
	 * When user enters all values correct program prints which day will be that day.
	 * @param args
	 */
	public static void main(String[] args) {
		// Create list of day names that can be acessed with index later
		String[] dayNames = new String[]{
				"Monday",
				"Tuesday",
				"Wednsday",
				"Thursday",
				"Friday",
				"Saturday",
				"Sunday"
		};
		// prompt user for values
		System.out.println("Enter day and number of days after that day.");
		int day = 0, futureDay = 0;
		while (true) {
			try {
				// if valuue for day is unchanged get new one
				if (day == 0) {
					System.out.print("Enter value for this day(0 - 6): ");
					day = zadaci_01_08_2016.Zadatak_05.readFromConsole(day);
					// if user enters wrong value reset it and ask again
					if (day < 0 || day > 6) {
						System.out.printf("%d is not correct value for day.", day);
						day = 0;
						throw new Exception("Try again.");
					}
				}
				// if value for future day is unchanged get new one
				if (futureDay == 0) {
					System.out.printf("Enter number of days after %s day: ", dayNames[day]);
					futureDay = zadaci_01_08_2016.Zadatak_05.readFromConsole(futureDay);
					// if user enters negative or zero for number of days ask again
					if (futureDay < 1) {
						System.out.println("No negative or same values as starting day.");
						futureDay = 0;
						throw new Exception("Try again.");
					}
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// print message
		System.out.printf("Today is %s and %d days after is %s.",
				dayNames[day],
				futureDay,
				dayNames[(day + futureDay) % 7]);
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
