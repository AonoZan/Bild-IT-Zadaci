
package zadaci_23_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**Program makes list of all primes less than 120 and prints in reverse*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create list and variable to store number
		StackOfIntegers factors = new StackOfIntegers();
		int userNumber = 0;
		// prompt user for number
		System.out.println("Enter one number to be calculated factors from.");
		do {
			try {
				// try to get number
				System.out.print("Enter (non-zero) number: ");
				userNumber =input.nextInt();
			} catch (InputMismatchException e) {
				// if error clear console
				System.out.println("Please enter only numbers.");
				input.nextLine();
			}
		} while (userNumber == 0);
		// create first divider and loop until number becomes non divisable
		int divider = 2;
		while (userNumber > 1) {
			// if number can be divided add to list divider and divide number
			if (userNumber % divider == 0) {
				factors.push(divider);
				userNumber /= divider;
			// else try another divider
			} else {
				divider++;
			}
		}
		// pop factors and print them
		System.out.print("Factors: ");
		for (int i = factors.getSize(); i > 0; i--) {
			System.out.print(factors.pop() + " ");
		}
		input.close();
	}
}

