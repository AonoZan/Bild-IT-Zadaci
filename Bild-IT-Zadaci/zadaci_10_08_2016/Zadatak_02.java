/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_10_08_2016;

public class Zadatak_02 {
	/**
	 * Program prints all primes twins that are less than 10000, 10 pairs on each line.
	 * <p><b>Example of twin primes:</b>
	 * <br>3 and 5
	 * <br>5 and 7
	 * <br>11 and 13
	 * @param args
	 */
	public static void main(String[] args) {
		// loop for all numbers and print only ones that are twin primes
		System.out.println("All twin primes less than 10000:");
		for (int i = 2, counter = 0; i < 10000; i++) {
			if (zadaci_03_08_2016.Zadatak_01.isPrime(i) && zadaci_03_08_2016.Zadatak_01.isPrime(i + 2)) {
				// print left and right prime justified correctly
				System.out.printf("%4d|%-4d ", i, (i + 2));
				// count and print new line after 10 twins
				counter++;
				if (counter % 10 == 0) System.out.println(" " + counter / 10);
			}
		}
	}
}
