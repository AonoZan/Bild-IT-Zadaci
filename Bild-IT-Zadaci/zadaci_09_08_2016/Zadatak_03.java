/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_09_08_2016;

public class Zadatak_03 {
	/**
	 * Program prints all numbers that are divisable with 5 and 6, 10 on each line in range 100 - 1000.
	 * @param args
	 */
	public static void main(String[] args) {
		// print message and loop trough numbers
		System.out.println("Numbers between 100 and 1000 divisable with 5 ans 6.");
		for (int i = 100, counter = 0; i <= 1000; i++) {
			// print only those numbers that are divisable with 5 and 6
			if (i % 5 == 0 && i % 6 == 0) {
				System.out.print(i + " ");
				// count them and break line after each 10 numbers
				counter++;
				if (counter % 10 == 0) System.out.println();
			}
		}
	}
}
