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
		// createt scanner but use delimeter that include only space
		Scanner input = new Scanner(System.in);
		// prompt user for numbers and count them until 0 is entered
		System.out.println("Enter unlimited amount of numbers.");
		int userNumber = -1, largestNumber = 0, counter = 1;
		while (userNumber != 0) {
			// ask for numbers while there is some in scanner
			System.out.printf("Enter %snumbers: ", counter > 0 ? "some more " : "");
			// get forst number when program starts
			if (largestNumber == 0) largestNumber = input.nextInt();
			while (input.hasNextInt()) {
				userNumber = input.nextInt();
				
				// if number is other than 0 else break
				if (userNumber != 0) {
					// if number is largest set largest
					if (userNumber > largestNumber) {
						largestNumber = userNumber;
						counter = 1;
					// else if its same as largest count it
					} else if (userNumber == largestNumber)
						counter++;
				}  else {
					break;
				}
			}
			// clear input for next loop
			input.nextLine();
		}
		// print status
		System.out.printf("Largest number was %d and occured %d time%s.",
				largestNumber,
				counter,
				counter < 2 ? "" : "'s");
		input.close();
	}
}
