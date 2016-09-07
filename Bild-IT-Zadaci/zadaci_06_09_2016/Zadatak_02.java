
package zadaci_06_09_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/** Method calculates gcd using recursion. */
	public static int gcd(int n, int m) {
		int gcd = 0;
		// if m is divisible with n then gcd is n
		// else do recursion...
		if (m % n == 0) {
			gcd = n;
		} else {
			gcd = gcd(m, n % m);
		}
		return gcd;
	}
	/** Program asks user for two numbers and then calculates gcd for those two numbers. */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create number and prompt user for value
		int m = 0, n = 0;
		System.out.println("Enter two numbers for finding GCD.");
		while (true) {
			try {
				// if number on default ask for value
				if (m == 0) {
					System.out.print("Enter first: ");
					m = input.nextInt();
					// if still on default ask again
					if (m <= 0) {
						m = 0;
						continue;
					}
				}
				// if number on default ask for value
				if (n == 0) {
					System.out.print("Enter second: ");
					n = input.nextInt();
					// if still on default ask again
					if (n <= 0) {
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
		// calculate gcd and print it
		int gcd = gcd(m, n);
		System.out.printf("Greatest common divisor for numbers %d and %d is %d.\n"
				,m , n, gcd);
		
		input.close();
	}
}

