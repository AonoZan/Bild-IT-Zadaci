
package zadaci_06_09_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/** Program prompts user for fibonacci index and then calculates fibonacci using iterations. */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create number and prompt user for value
		int n = 0;
		System.out.println("Enter one real number.");
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
		// create fibonacci
		int fibonacci = 0;
		int f0 = 0; // For fib(0)
		int f1 = 1; // For fib(1)
		// if index is not 0 or 1 calculate fibonacci
		// else fibonacci is that index
		if (n != 0 && n != 1) {
			// start from 2 to (fib on index 2 is 1)
			for (int i = 2; i <= n; i++) {
				fibonacci = f0 + f1;
				f0 = f1;
				f1 = fibonacci;
			}
		} else {
			fibonacci = n;
		}
		// print fibonacci
		System.out.printf("Fibbernacci number on index %d is %d.\n", n, fibonacci);
		input.close();
	}
}

