
package zadaci_07_09_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	// constant for substring
	public final static int ONE = 1;
	public final static int ZERO = 0;
	/** Method counts character occurrence in a string using recursion */
	public static int count(String str, char a) {
		// if string empty return zero
		if (str.length() == ZERO) return ZERO;
		// count is zero b default
		int count = ZERO;
		// if last char matches argument count is one
		if (str.charAt(str.length() - ONE) == a) {
			count = ONE;
		}
		// return count and substring of all characters except last one
		return count(str.substring(ZERO, str.length() - ONE), a) + count;
	}
	/** Program asks for string and character to count character occurrences in string. */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// create number and prompt user for values
		System.out.print("Enter string and char value: ");
		String str = input.next();
		char ch = input.next().charAt(ZERO);
		input.nextLine();
		// print count of characters in string
		System.out.print("Count of characters in string is: " + count(str, ch));
		
		input.close();
	}
}

