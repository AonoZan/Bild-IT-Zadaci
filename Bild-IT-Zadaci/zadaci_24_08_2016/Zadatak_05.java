
package zadaci_24_08_2016;

import java.math.BigDecimal;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**
	 * Program prints 10 numbers greater than long.MAX_VALUE
	 * that are divisible both with 5 and 6.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// constant for comparison
		final BigDecimal FIVE = new BigDecimal(5);
		final BigDecimal SIX = new BigDecimal(6);
		// starting number is Long.MAX_VALUE
		BigDecimal number = new BigDecimal(Long.MAX_VALUE);
		// loop until 10 numbers is found
		for (int i = 1; i <= 10;) {
			// if number is divisible by 5 and 6 print it and count it
			if (number.remainder(FIVE).compareTo(BigDecimal.ZERO) == 0
					|| number.remainder(SIX).compareTo(BigDecimal.ZERO) == 0) {
				System.out.printf("%2d  %-15s\n", i, number);
				i++;
			}
			// move to next number
			number = number.add(BigDecimal.ONE);
		}
	}
}

