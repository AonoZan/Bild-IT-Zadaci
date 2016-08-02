/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_02_08_2016;

public class Zadatak_05 {
	/**
	 * Method for simulating coin throwing. Use argument for number of simulations.
	 * Argument can't be less than 1, if yes then default value is used and one simulation is performed.
	 * Method returns list with counters of times coin landed on head or toes
	 * @param howManyTimes use this to tell how much simulations will be performed
	 * @return int list with first item set to haow much coin landed on head and second for toes
	 */
	public static int[] throwCoin(int howManyTimes) {
		// make sure argument is correct
		if (howManyTimes < 1) howManyTimes = 1;
		// create list with default values
		int[] headToes = new int[]{0, 0};
		// loop simulation using argument
		for (int i = 0; i < howManyTimes; i++) {
			System.out.print("Throwing coin... ");
			// create random number and if that number is one coin landed on head
			if ((int)(Math.random() * 2) == 1) {
				System.out.print("got head!");
				headToes[0]++;
			// otherwise coin probbably landed on toes
			}else {
				System.out.print("got toes!");
				headToes[1]++;
			}
			System.out.println();
		}
		return headToes;
	}
	/**
	 * Simple test that use method printMatrix(). Number of simulations are 20.
	 * @param args
	 */
	public static void main(String[] args) {
		// create count for simulations and simulate throwing of coin
		int numberOfSimulations = 20;
		int[] headToes = throwCoin(numberOfSimulations);
		// print message with final results
		System.out.printf("\nSimulation is ended and number of times\ncoin ended on head or toes are:"
				+ "\n\tHead - %d"
				+ "\n\tToes - %d",
				headToes[0], headToes[1]);
	}
}
