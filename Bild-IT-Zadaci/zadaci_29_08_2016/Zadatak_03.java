
package zadaci_29_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**Program asks simple mathematical question.*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create two random numbers
		int randNum1 = (int)(Math.random() * 100);
		int randNum2 = (int)(Math.random() * 100);
		// create variable for sum and boolean for loop
		int sum;
		boolean needAnswer = true;
		// loop as long as answer is needed
		while (needAnswer) {
			try {
				// ask for answer
				System.out.printf("Enter sum of %d + %d: ", randNum1, randNum2);
				sum = input.nextInt();
				// if correct answer congrats else ask again
				if (sum == (randNum1 + randNum2)) {
					System.out.println("\nThats correct answer.");
					needAnswer = false;
					continue;
				} else {
					System.out.println("\nThat's not correct...\n");
				}
			} catch (InputMismatchException e) {
				// for wrong input print message and clear console
				System.out.println("Please enter integer.");
				input.nextLine();
			}
		}
		input.close();
	}

}

