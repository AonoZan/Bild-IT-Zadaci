
package zadaci_07_09_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/** Method sums all digits in number using recursion. */
	public static int sumDigits(long n) {
		// if number is 0 return 0 else sum of all digits except last plus last
		return n == 0 ? 0 : (int)(sumDigits(n / 10) + n % 10);
	}
	/** Program prompts user for one number and then sums all digits in number. */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create number and prompt user for value
		int n = 0;
		System.out.println("Enter one positive number.");
		while (true) {
			try {
				// get number
				System.out.print("Number: ");
				n = input.nextInt();
				break;
			} catch (InputMismatchException e) {
				// when user makes mistake print message and clear console
				System.out.println("Please enter number.");
				input.nextLine();
			}
		}
		// sum all digits and print result
		int sum = sumDigits(n);
		System.out.println("Sum of digits: " + sum);
		
		input.close();
	}
}

