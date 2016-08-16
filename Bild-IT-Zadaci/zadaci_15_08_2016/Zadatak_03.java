
package zadaci_15_08_2016;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**
	 * Program sums next series of numbers:
	 * <br>1/3 + 3/5 + 5/7 + 7/9 + 9/11 + 11/13 ..... + 95/97 + 97/99
	 * @param args
	 */
	public static void main(String[] args) {
		// constant for range in loop
		final int RANGE_MIN = 1;
		final int RANGE_MAX = 98;
		// var for increment of divider and var for total sum
		final double INCREMENT = 2.0;
		double sum = 0;
		// loop in range
		for (int i = RANGE_MIN; i < RANGE_MAX; i++) {
			// add to sum
			sum += i / (i + INCREMENT);
		}
		System.out.println(sum);
	}

}
