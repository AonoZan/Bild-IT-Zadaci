
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
		System.out.println(Short.MAX_VALUE);
		try {
			short digit = input.nextShort();
			// for 1st (left to right) equation is:
			// digit % 2
			// for 2th equation is:
			// digit / 2 % 2 and so on go trough all 16
			for (int i = 15; i >= 0; i--) {
				System.out.print(Math.abs((digit / (int)(Math.pow(2, i))) % 2));
				// separate on every byte
				if (i % 8 == 0) {
					System.out.print(" ");
				}
				
			}
		// exit if something is wrong
		} catch (InputMismatchException e) {
			System.out.println("Wrong input!");
		}
		input.close();
	}

}

