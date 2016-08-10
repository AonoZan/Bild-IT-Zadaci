/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_09_08_2016;

public class Zadatak_01 {

	public static void main(String[] args) {
		String[] dayNames = new String[]{
				"Monday",
				"Tuesday",
				"Wednsday",
				"Thursday",
				"Friday",
				"Saturday",
				"Sunday"
		};
		System.out.println("Enter day and number of days after that day.");
		int day = 0, futureDay = 0;
		while (true) {
			try {
				if (day == 0) {
					System.out.print("Enter value for this day(0 - 6): ");
					day = zadaci_01_08_2016.Zadatak_05.readFromConsole(day);
					if (day < 0 || day > 6) {
						System.out.printf("%d is not correct value for day.", day);
						day = 0;
						throw new Exception("Try again.");
					}
				}
				if (futureDay == 0) {
					System.out.printf("Enter number of days after %s day: ", dayNames[day]);
					futureDay = zadaci_01_08_2016.Zadatak_05.readFromConsole(futureDay);
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
		System.out.printf("Today is %s and %d days after is %s.",
				dayNames[day],
				futureDay,
				dayNames[(day + futureDay) % 7]);
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
