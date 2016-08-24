
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
		StackOfIntegers factors = new StackOfIntegers();
		int userNumber = 0;
		System.out.println("Enter one number to be calculated factors from.");
		do {
			try {
				System.out.print("Enter (non-zero) number: ");
				userNumber =input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter only numbers.");
			}
		} while (userNumber == 0);
		
		while (userNumber > 1)
		// pop primes and print them
		for (int i = factors.getSize(); i > 0; i--) {
			System.out.print(factors.pop() + " ");
		}
		input.close();
	}
}

