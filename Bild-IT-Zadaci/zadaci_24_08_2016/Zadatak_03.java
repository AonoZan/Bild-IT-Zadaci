
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
		// progress counter
		int counter = 0;//*****
		// start from 
		BigDecimal start = new BigDecimal(3);
		while (start.multiply(start).compareTo(n) <= 0) {
			if (n.remainder(start).compareTo(BigDecimal.ZERO) == 0) {
				return false;
			}
			start = start.add(new BigDecimal(2));
			if (counter % 100000 == 0) {//*****
				System.out.print(".");//*****
				counter = 0;//*****
			}//*****
			counter++;//*****
		}
		return true;
	}
	/**
	 * Program finds five prime numbers greater than long max value.
	 * Because it take too long to compute lower values can be tested.
	 * Everything with //***** can be commented because its only
	 * for showing that program is doing something.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// few test starting points and Long.MAX_VALUE starting point
//		BigDecimal n = new BigDecimal(12);
		BigDecimal n = new BigDecimal(79846462100000L);
//		BigDecimal n = new BigDecimal(Long.MAX_VALUE);
		
		// loop until 5 primes are found
		System.out.println("Five primes greater than: " + n);
		for (int i = 1; i <= 5;) {
			// progress bar counter
			int progress = 0;//*****
			while(true) {
				// if number is prime print it, count and break to loop again
				if (isPrime(n)) {
					System.out.println(n);
					i++;
					break;
				}
				// if it's not move to the next number
				n = n.add(BigDecimal.ONE);
				
				// print progress bar every 10th number
				if (progress % 10 == 0) {//*****
					System.out.print("|");//*****
					progress = 0;//*****
				}//*****
				progress++;//*****
			}
			// move to the next after prime is found
			n = n.add(BigDecimal.ONE);
		}
	}
}
