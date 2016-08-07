/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_06_08_2016;

public class Zadatak_03 {
	/**
	 * Method for reversing number.
	 * @param number Any integer value.
	 * @return Number in reverse order eg: 345 >> 543
	 */
	public static int reverse(int number) {
		// if number is one digit return immediately
		if (number < 10 && number > -10) return number;
		// reverse number into new variable
		int reversedNumber = 0;
		while(number != 0) {
			reversedNumber = reversedNumber * 10 + number % 10;
			number /= 10;
		}
		return reversedNumber;
	}
	/**
	 * Method for checking if number is palindrome.
	 * Number is palindrome if reversed value of that number is the same as number.
	 * Negative number can't be palindrome.
	 * <p><b>Example:</b>
	 * <br>345 != 543 (not palindrome)
	 * <br>373 == 373 (palindrome)
	 * <br>34843 == 34843 (palindrome)
	 * @param number any number
	 * @see <a href="http://www.wikipedia.org/wiki/Palindromic_number">Palindromic number</a>
	 * @return true if number is palindrome or false if it's not
	 */
	public static boolean isPalindrome(int number) {
		// negative numbers are not palinfrome
		if (number < 1) return false;
		// if one digit number it is palindrome
		else if (number < 10 && number > 0) return true;
		// if number value is equal to reverse of it return true else return false
		return number == reverse(number) ? true : false;
	}
	/**
	 * Program asks user for one whole number and then tells if that number is palindrome or not.
	 * @param args
	 */
	public static void main(String[] args) {
		// create variable for number and ask user to enter value.
		int userNumber = 0;
		while(true) {
			try {
				System.out.print("Enter one whole number: ");
				userNumber = zadaci_01_08_2016.Zadatak_05.readFromConsole(userNumber);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
			}
		}
		// print message that tells if number is palindrome or not
		System.out.printf("Number %d %s palindrome",
				userNumber,
				isPalindrome(userNumber) ? "is" : "isn't");
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
