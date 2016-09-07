
package zadaci_07_09_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	// constant for division
	public final static int TEN = 10;
	/** Method prints int value in reverse using recursion. (123 = 321) */
	public static void intReverse(int i) {
		// if number is 0 return
		// else print last and using recursion do else for all except last one
		if (i == 0) return;
		else {
			System.out.print(i % TEN);
			intReverse(i / TEN);
		}
	}
	/** Program asks user for one number and then prints it in reverse. */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create number and prompt user for value
		int n = 0;
		System.out.println("Enter one positive number.");
		while (true) {
			try {
				// if number on default ask for value
				if (n == 0) {
					System.out.print("Number: ");
					n = input.nextInt();
					// if still on default ask again
					if (n < 0) {
						n = 0;
						continue;
					}
				}
				break;
			} catch (InputMismatchException e) {
				// when user makes mistake print message and clear console
				System.out.println("Please enter number.");
				input.nextLine();
			}
		}
		// print number in reverse
		intReverse(n);
		
		input.close();
	}
}

