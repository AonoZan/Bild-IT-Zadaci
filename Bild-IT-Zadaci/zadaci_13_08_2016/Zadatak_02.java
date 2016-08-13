/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_13_08_2016;

import java.util.Scanner;

public class Zadatak_02 {
	/**
	 * Method for printing number in reverse order.
	 * @param number
	 */
	public static void reverse(int number) {
		int reverse = 0;
		// loop until number is not 0
		while (number != 0) {
			// add last number digit to the reverse
			reverse = (reverse * 10) + number % 10;
			// remove last digit from number
			number /= 10;
		}
		System.out.println(reverse);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user for one number
		System.out.print("Enter one number: ");
		int number = input.nextInt();
		// print number in reverse
		System.out.print("Number in reverse: ");
		reverse(number);
		
		System.out.println();
		input.close();
	}

}
