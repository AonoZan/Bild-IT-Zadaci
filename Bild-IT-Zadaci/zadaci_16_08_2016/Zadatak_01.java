
package zadaci_16_08_2016;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**
	 * Method takes number as input and returns reversed value of that number.
	 * <br>For example input = 123 output = 321
	 * 
	 * @param number
	 * @return
	 */
	public static int reverse(int number) {
		// if number is one digit return immediately
		if (number < 10 && number > -10) return number;
		// create variable for reversed value and reverse number
		int reversed = 0;
		while (number != 0) {
			// multiply by 10 and add last digit from number
			reversed = (reversed * 10) + (number % 10);
			// destroy last digit from number
			number /= 10;
		}
		return reversed;
	}
	/**
	 * Method checks if number is palindrome.
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isPalindrome(int number) {
		// negative numbers are not palindrome
		if (number < 0) return false;
		// if reversed value of the number is same return true
		return number == reverse(number) ? true : false;
	}
	/**
	 * Program asks user to enter one number 
	 * and then checks if that number is palindrome.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// prompt user to enter one number
		int number = 0;
		System.out.println("Enter one positive number"
				+ "\nto check if it's palindrome.");
		while (true) {
			// try to get valid number
			try {
				// ask for number as long as it's on default value
				if (number <= 0) {
					System.out.print("Enter number: ");
					number = input.nextInt();
					// if user enters negative number ask again 
					if (number <= 0) {
						number = 0;
						continue;
					}
				}
				break;
			// if user enters wrong value display error and clear console
			} catch (InputMismatchException e){
				System.out.println("Please enter integer.");
				input.nextLine();
			} catch (Exception e) {
				System.exit(0);
			}
		}
		// print message if number is palindrome or not
		System.out.printf("Number %d %s palindrom.",
				number,
				isPalindrome(number) ? "is" : "isn't");
		input.close();
	}
}

