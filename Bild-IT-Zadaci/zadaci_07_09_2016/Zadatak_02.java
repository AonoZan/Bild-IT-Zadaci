
package zadaci_07_09_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	// constant for substring
	public final static int ONE = 1;

	/** Method prints String value in reverse using recursion. (abc = bca) */
	public static void reverseDisplay(String value) {
		// if string length is 0 return 
		// else print last char and using recursion do else for all except last one
		if (value.length() == 0) return;
		else {
			System.out.print(value.charAt(value.length() - ONE));
			reverseDisplay(value.substring(ONE - ONE, value.length() - ONE));
		}
	}
	/** Program asks user for one number and then prints it in reverse. */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create number and prompt user for value
		System.out.print("Enter string value: ");
		String value = input.nextLine();
		// print number in reverse
		System.out.print("Value in reverse: ");
		reverseDisplay(value);
		
		input.close();
	}
}

