
package zadaci_30_08_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/** Method converts binary string in to integer. */
	public static int binToDec(String binary) {
		// check if all char are 1 or 0
		for (char ch : binary.toCharArray()) {
			if (ch != '0' && ch != '1') {
				// if not 1 or 0 throw exception
				throw new NumberFormatException("Number passed to binToDec() cant be parsed.");
			}
		}
		// return integer parsed
		return Integer.parseInt(binary, 2);
	}
	/**
	 * Program asks for binary strings and converts them in to decimal numbers.
	 * When user makes mistake program exits.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userInput;
		int binary;
		// loop until break (exception is raised)
		while (true) {
			try {
				// prompt for string
				System.out.print("Enter binary string: ");
				userInput = input.nextLine();
				// convert and print string
				binary = binToDec(userInput);
				System.out.println("Binary representation is: " + binary);
			} catch (NumberFormatException e) {
				// in case user makes mistake exit
				System.out.println(e.getMessage());
				break;
			}
		}
		input.close();
	}

}

