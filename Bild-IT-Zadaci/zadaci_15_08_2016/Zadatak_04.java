
package zadaci_15_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/**
	 * Method sums all digits from number.
	 * <br>For example if 123 is passed 6 is returned.
	 * <br>1 + 2 + 3 = 6
	 * 
	 * @param n
	 * @return
	 */
	public static int sumDigits(long n) {
		// create variable for sum
		int sum = 0;
		// loop until number is 0
		while (n != 0) {
			// add last digit to sum and remove it from number
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	/**
	 * Program tests sumDigits() method with number 123456789.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(sumDigits(123456789));
	}

}

