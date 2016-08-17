
package zadaci_16_08_2016;

import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 �
 */
public class Zadatak_03 {
	/**
	 * Method for checking if SSN number is valid.
	 * For number to be valid it has to me in format DDD-DD-DDDD.
	 * D stands for digit.
	 * @param number
	 */
	public static boolean isValidSSN(String number) {
		// length of number is not valid
		if (number.length() < 11) return false;
		// loop trough whole number
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (i == 3 || i == 6) {   // if character on 4th place or 7th place
				if (ch != '-') {        // isn't -
					return false;         // SSN is not valid
				}
			} else if (!Character.isDigit(ch)) {// or if character is not digit
				return false;
			}
		}
		// SSN is valid
		return true;
	}
	/**
	 * Program asks for Social Security Number and checks if it's valid one.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user for number
		System.out.println("SSN format = DDD-DD-DDDD");
		System.out.println("SSN format");
		System.out.print("Enter SSN number: ");
		// get number and check if it's valid
		String ssn = input.nextLine();
		if (!isValidSSN(ssn)) {
			System.out.println("SSN is not valid.");
		}
		input.close();
	}
}
