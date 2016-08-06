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
	 * <p><b>Example:</b>
	 * <br>345 != 543 (not palindrome)
	 * <br>373 == 373 (palindrome)
	 * <br>34843 == 34843 (palindrome)
	 * @param number any number
	 * @return true if number is palindrome or false if it's not
	 */
	public static boolean isPalindrome(int number) {
		// if one digit number return it
		if (number < 10 && number > -10) return true;
		// if number value is equal to reverse of it return true else return false
		return number == reverse(number) ? true : false;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome(-45654));
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}
}
