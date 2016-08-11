/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_11_08_2016;

import java.util.Scanner;

public class Zadatak_05 {
	/**
	 * Program reads unlimited anount of numbers from user.
	 * Reading stops ehen 0 is entered.
	 * After 0 is entered program prints positive and negative count, sum of all numbers and average.
	 * @param args
	 */
	public static void main(String[] args) {
		// createt scanner but use delimeter that include only space
		Scanner input = new Scanner(System.in);
		// prompt user for numbers and count them until 0 is entered
		System.out.println("Enter unlimited amount of numbers.");
		int userNumber = -1, negativeCount = 0, count = 0;
		double sum = 0, average = 0;
		while (userNumber != 0) {
			// ask for numbers while there is some in scanner
			System.out.print("Enter numbers: ");
			while (input.hasNextInt()) {
				userNumber = input.nextInt();
				// if number is other than 0 else break
				if (userNumber != 0) {
					// count if negative
					if (userNumber < 0) {
						negativeCount++;
					}
					// calculate sum and count number
					sum += userNumber;
					count++;
				}  else {
					break;
				}
			}
			// clear input for next loop
			input.nextLine();
		}
		average = sum / count;
		// print status
		System.out.printf("Positive numbers %d, negative numbers %d, sum %.2f and average %.2f.",
				count - negativeCount,
				negativeCount,
				sum,
				average);
		input.close();
	}
}
