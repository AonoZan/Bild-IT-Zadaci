
package zadaci_16_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
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
		return true;
	}
	public static void main(String[] args) {

	}

}

