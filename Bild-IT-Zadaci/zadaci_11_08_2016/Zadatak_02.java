/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_11_08_2016;

public class Zadatak_02 {
	/**
	 * Program prints all primes in range 8 on each line.
	 * @param aargs
	 */
	public static void main(String[] aargs) {
		// print all primes between 2 and 1000
		for (int i = 2, counter = 0; i <= 1000; i++) {
			if (zadaci_03_08_2016.Zadatak_01.isPrime(i)) {	// if it's prime
				System.out.print(String.format("%3d ", i));	// print it aligned
				counter++;									// count
				if (counter % 8 == 0) System.out.println();	// and print new line every 8-th count
			}
		}
	}
}
