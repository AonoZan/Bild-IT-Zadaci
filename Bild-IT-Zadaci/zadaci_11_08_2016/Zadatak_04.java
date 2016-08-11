/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_11_08_2016;

import java.util.Scanner;

public class Zadatak_04 {
	/**
	 * Program asks user for amount of minutes and then calculates how much is that in years and days.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create variable for minutes and ask user for value
		long minutes = 0;
		while (true) {
			try {
				// if default value get new one
				if (minutes == 0) {
					System.out.println("Enter number of minutes: ");
					minutes = input.nextLong();
					// if user enters negative ask again
					if (minutes < 1) {
						System.out.printf("Not valid number %d.", minutes);
						minutes = 0;
						throw new Exception("Try again.");
					}
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// calculate how much days and years from minutes and print it
		int years = (int)(minutes / 365);
		int daysReminder = (int)(minutes % 365);
		System.out.printf("%d minutes is %d and %d day%s.",
				minutes,
				years,
				daysReminder,
				daysReminder > 1 ? "'s" : "");
		input.close();
	}
}
