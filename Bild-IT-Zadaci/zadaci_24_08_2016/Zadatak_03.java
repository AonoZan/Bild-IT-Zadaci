
package zadaci_24_08_2016;

import java.math.BigDecimal;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_03 {
	/**
	 * Method checks if BigDecimal is prime or not.
	 * @param n
	 * @return true for prime false if it's not
	 */
	public static boolean isPrime(BigDecimal n) {
//		// if number is 2 return true if less than or equal one false
//		if (n.compareTo(new BigDecimal(2)) == 0) {
//			return true;
//		} else if (n.compareTo(BigDecimal.ONE) <= 0) {
//			return false;
//		}
		// check if it's divisible with 2 and return false
		if (n.remainder(new BigDecimal(2)).compareTo(BigDecimal.ZERO) == 0) {
			return false;
		}
		// start from 
		BigDecimal start = new BigDecimal(3);
		 while (start.multiply(start).compareTo(n) <= 0) {
			 if (n.remainder(start).compareTo(BigDecimal.ZERO) == 0) {
				 return false;
			 }
			 start = start.add(new BigDecimal(2));
			 
		 }
		return true;
	}
	/**
	 * Program finds five prime numbers greater than long max value.
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal n = new BigDecimal(4579);
		for (int i = 1; i <= 500;) {
			if (isPrime(n)) {
				System.out.println(n);
				i++;
			}
			n = n.add(BigDecimal.ONE);
		}
	}
	// Karp's Tricks, this can be implemented without a loop in only two lines, giving 32 digits precision
	private static BigDecimal sqrt(BigDecimal value) {
		BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
		return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
	}
}
