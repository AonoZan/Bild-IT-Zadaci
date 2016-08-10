/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_10_08_2016;

public class Zadatak_03 {
	/**
	 * Program prints all possible combinations of two numbers in range.
	 * Range here used is 1 - 7.
	 * @param args
	 */
	public static void main(String[] args) {
		int combinations = 0;
		for (int rangeFirst = 1, rangeLast = 7; rangeFirst < rangeLast; rangeFirst++) {			// go trough range first to last number
			for (int currentNumber = rangeFirst; currentNumber < rangeLast; currentNumber++) {	// go from current range number to last number
				System.out.println(rangeFirst + "_" + currentNumber);							// print current range number and current number
				combinations++;																	// count combination
			}
		}
		System.out.println(combinations);
	}
}
