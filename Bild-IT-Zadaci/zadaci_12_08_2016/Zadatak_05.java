/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_12_08_2016;

import java.util.Scanner;

public class Zadatak_05 {
	/**
	 * Program reads unlimited amount of numbers in range 1 - 100 and counts how many times each is entered.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] numbers = new int[100];
		int userNumber = -1;
		System.out.println("Enter numbers: ");
		while (userNumber != 0) {
			userNumber = input.nextInt();
			if (userNumber > 0) {
				numbers[userNumber - 1]++;
			}
		}
		input.close();
	}

}
