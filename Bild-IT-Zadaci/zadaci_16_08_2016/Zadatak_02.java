
package zadaci_16_08_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/**
	 * Program asks for string and prints string length and first character.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user to enter string
		System.out.print("Enter string: ");
		String string = input.nextLine();
		// print length and first character
		System.out.printf("Length of string is %d and first characcter is %c.",
				string.length(),
				string.charAt(0));
		input.close();
	}

}

