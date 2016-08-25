
package zadaci_24_08_2016;

import java.math.BigDecimal;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_02 {
	/**
	 * Program finds first ten square numbers greater than long.MAX_VALUE.
	 * Square number is number in format n¡2.
	 * 
	 * @see <a href="https://github.com/LuizGsa21/intro-to-java-10th-edition/tree/master/src">
	 * See this guy repository which helped me with BigDecimal</a>
	 */
	public static void main(String[] args) {
		// maximum long value, searching for anything above
		final BigDecimal MAX = new BigDecimal(Long.MAX_VALUE);
		// get long max value square root as long for starting point
		BigDecimal startNumber = new BigDecimal((long)(Math.sqrt(Long.MAX_VALUE)));
		BigDecimal squareNumber;
		// loop until ten number is found
		for (int i = 1; i <= 10;) {
			// multiply starting number to get squared n^2
			squareNumber = startNumber.multiply(startNumber);
			// if number is bigger than long max print it and count
			if (squareNumber.compareTo(MAX) > 0) {
				System.out.printf("%2d  %20s\n"
						,i
						,squareNumber);
				i++;
			}
			// add one to the starting number
			startNumber = startNumber.add(BigDecimal.ONE);
		}
    }
}

