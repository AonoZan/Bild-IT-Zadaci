
package zadaci_16_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**
	 * Method for getting length of int number.
	 * @param number
	 * @return
	 */
	public static int numberSize(int number) {
		int counter = 0;
		// count numbers and divide with 10 until it reaches 0
		while (number != 0) {
			counter++;
			number /= 10;
		}
		return counter;
	}
	/**
	 * Program prints pyramid of numbers.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user for one number as pyramid size
		int pyramidSize = 0;
		System.out.println("Input desired size for piramid.");
		while (true) {
			try {
				// ask for number until it's right value
				if (pyramidSize == 0) {
					System.out.printf("Enter size: ");
					pyramidSize = input.nextInt();
					// if user enters negative reset it and loop again
					if (pyramidSize <= 0) {
						pyramidSize = 0;
						continue;
					}
					break;
				}
			// for wrong input notify and ask again
			} catch (InputMismatchException e) {
				System.out.println("Please enter positive number.");
				input.nextLine();
			} catch (Exception e) {
				System.exit(0);
			}
		}
		// print pyramid
		// for every row
		for (int i = 1; i <= pyramidSize; i++) {
			// print enough empty spaces
			for (int j = 0; j < pyramidSize + numberSize(pyramidSize) - i; j++) {
					System.out.print("  ");
			}
			// print numbers
			// start from negative
			for (int j = i; j >= i * -1; j--) {
				// skip -1 and 0 for convenience
				if (j > 0 || j < -1) {
					System.out.print(Math.abs(j) + " ");
				}
			}
			// start new line
			System.out.println();
		}
		input.close();
	}

}

