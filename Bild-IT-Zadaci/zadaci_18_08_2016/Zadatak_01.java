
package zadaci_18_08_2016;
/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_01 {
	/**
	 * Program generates 100 random numbers
	 * and counts how many of each appeared.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// create constant for final and variable to store random number
		final int AMOUNT = 100;
		int number = 0;
		// store each number occurrence
		int[] counts  = new int[10];
		// loop of desired amount of times
		// and each time generate number and count it
		for (int i = 0; i < AMOUNT; i++) {
			number = (int)(Math.random() * 10);
			counts[number]++;
		}
		// loop ove counters and print them
		for (int i = 0; i < counts.length; i++) {
			System.out.printf("Number %d appeared %d %s.\n",
					i,
					counts[i],
					counts[i] > 1 ? "time's" : "time");
		}
	}

}

