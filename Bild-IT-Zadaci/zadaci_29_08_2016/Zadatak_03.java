
package zadaci_29_08_2016;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int randNum1 = (int)(Math.random() * 100);
		int randNum2 = (int)(Math.random() * 100);
		int sum;
		boolean needAnswer = true;
		while (needAnswer) {
			try {
				System.out.printf("Enter sum of %d + %d: ", randNum1, randNum2);
				sum = input.nextInt();
				if (sum == (randNum1 + randNum2)) {
					System.out.println("\nThats correct answer.");
					needAnswer = false;
					continue;
				} else {
					System.out.println("\nThat's not correct...\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter integer.");
				input.nextLine();
			}
		}
		input.close();
	}

}

