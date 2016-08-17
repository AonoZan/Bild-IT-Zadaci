
package zadaci_17_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user to enter ascii code
		System.out.println("Enter an ASCII code in range 0 to 127."
				+ "\n(-1 to exit)");
		int ascii = 0;
		// loop until break
		while (true) {
			try {
				// get the code
				System.out.print("Enter the code: ");
				ascii = input.nextInt();
				// if valid print the code and continue
				if (ascii >= 0 && ascii <= 127) {
					System.out.printf("Character is : '%c'\n", ascii);
					continue;
				}
				// else exit
				System.out.println("Exit.");
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter number.");
				input.nextLine();
			}
		}
		input.close();
	}

}

