
package zadaci_24_08_2016;

import java.math.BigDecimal;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	public static boolean isPrime(BigDecimal n) {
		// if number is 2 return true
		if (n.compareTo(new BigDecimal(2)) == 0) {
			return true;
		}
		// check if number is equal or less than 1 and return false
//		else if (n.compareTo(BigDecimal.ONE) <= 0) {
//			return false;
//		}
		// check if it's divisible with 2 and return false
		if (n.remainder(new BigDecimal(2)).compareTo(BigDecimal.ZERO) == 0) {
			return false;
		}
		// start from odd number
		BigDecimal divider = new BigDecimal(3);
		// loop until multiple of divider is less or equal than number
		while (divider.multiply(divider).compareTo(n) <= 0) {
			// if number is divisible with divider it's not prime
			if (n.remainder(divider).compareTo(BigDecimal.ZERO) == 0) {
				return false;
			}
			// set divider to next odd number
			divider = divider.add(new BigDecimal(2));
		}
		return true;
	}
	/**
	 * Returns number using mersenne equation number.
	 * @see <a href="https://github.com/LuizGsa21/intro-to-java-10th-edition/tree/master/src">
	 * See this guy repository which helped me with BigDecimal</a>
	 * 
	 * @param n
	 * @return
	 */
	public static BigDecimal getMersenne(int n) {
		return new BigDecimal(2).pow(n).subtract(BigDecimal.ONE);
	}
	/**
	 * Program prints all mersenne prime numbers (<= 100)
	 * @param args
	 */
	public static void main(String[] args) {
		// create mercenne variable and loop to 100 iterations
		BigDecimal mersenne;
		for (int i = 2; i <= 100; i++) {
			// check if iteration is prime
			if (isPrime(new BigDecimal(i))) {
				// get mersenne number from prime
				mersenne = getMersenne(i);
				// check if mersenne is prime and if yes print it
				if (isPrime(mersenne)) {
					System.out.printf("%3d  %s\n",
							i,
							mersenne);
				}
			}
		}
	}
}

