
package zadaci_17_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**
	 * Program asks user for one short digit
	 * and then prints binary code for that number.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user for number
		System.out.print("Enter one 'short' digit: ");
		try {
			short digit = input.nextShort();
			System.out.print("Binary of short: ");
			if (digit < 0) {	// for negative integers
				System.out.println(Integer.toBinaryString(digit).substring(16, 32));
			} else {			// for positive integers
				// for 1st (left to right) equation is:
				// digit % 2
				// for 2th equation is:
				// digit / 2 % 2 and so on go trough all 16
				for (int i = 15; i >= 0; i--) {
					System.out.print((digit / (int)(Math.pow(2, i))) % 2);
				}
		}
		// exit if something is wrong
		} catch (InputMismatchException e) {
			System.out.println("Wrong input!");
		}
		input.close();
	}

}

