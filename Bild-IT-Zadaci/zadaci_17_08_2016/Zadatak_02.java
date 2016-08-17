
package zadaci_17_08_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/**
	 * Program asks user for ASCII character and then prints code of that character.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user to enter ascii character
		System.out.println("Enter an ASCII ccharacter to get code.");
		char ascii = '\u0000';
		// loop until break
		while (true) {
			try {
				// get the code
				System.out.print("Enter character: ");
				ascii = input.nextLine().charAt(0);
				// if valid print the code and continue
				System.out.printf("Code for %c is : %d\n", ascii, (int)(ascii));
				continue;
			// else exit
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("Exit.");
				break;
			}
		}
		input.close();
	}
}

