/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_09_08_2016;

import java.util.Scanner;

public class Zadatak_04 {
	/**
	 * Program reads unlimited anount of numbers from user.
	 * Reading stops ehen 0 is entered.
	 * After 0 is entered program prints which number is largest and how many times it occured.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input.useDelimiter(" *");
		System.out.println("Enter unlimited amount of numbers.");
		int userNumber = -1, largestNumber = 0, counter = 0;
		while (userNumber != 0) {
			try {
				System.out.printf("Enter %snumbers: ", counter > 0 ? "some more " : "");
				while (input.hasNextInt()) {
					userNumber = input.nextInt();
					if (userNumber != 0) {
						if (userNumber > largestNumber) {
							largestNumber = userNumber;
							counter = 1;
						} else if (userNumber == largestNumber)
							counter++;
						continue;
					}  else {
						break;
					}
				}
				input.nextLine();
			} catch (Exception e) {
				System.out.println("Illegal input.");
				System.exit(0);
			}
		}
		System.out.printf("Largest number was %d and occured %d time%s.",
				largestNumber,
				counter,
				counter < 2 ? "" : "'s");
		input.close();
	}
}
