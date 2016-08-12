/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_12_08_2016;

public class Zadatak_01 {
	/**
	 * Program prints random generated car license in format LLL-DDDD.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("New car registration license: ");
		for (int i = 0; i < 3; i++) {
			System.out.print((char)(65 + Math.random() * 26));	// print three random characters
		}
		System.out.print("-");									// separator
		for (int i = 0; i < 4; i++) {
			System.out.print((int)(Math.random() * 10));		// three random digits
		}
		System.out.println();
	}
}
