/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_13_08_2016;

public class Zadatak_01 {
	/**
	 * Program asks for value of service in money and tip percentage.
	 * Total money to pay is then calculated and printed.
	 * @param args
	 */
	public static void main(String[] args) {
		// prompt user to enter money value and warn that negatives are not alowed
		System.out.println("Enter total money debt and tip percentage.\n(0 or negative are not alowed)");
		double total = 0, tip = 0;
		while (true) {
			try {
				// if total has wrong value ask for new one
				if (total <= 0) {
					System.out.print("Total: ");
					total = zadaci_03_08_2016.Zadatak_02.readFromConsole(total);
					// skip itteration if wrong value entered
					if (total <= 0) continue;
				}
				// if tip has wrong value ask for new one
				if (tip <= 0) {
					System.out.print("Tip percentage: ");
					tip = zadaci_03_08_2016.Zadatak_02.readFromConsole(tip);
					// skip itteration if wrong value entered
					if (tip <= 0) continue;
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// calculate total and tip and print it
		tip = (total / 100) * tip;
		total += tip;
		System.out.printf(""
				+ "Total amount to pay: %.2f\n"
				+ "Tip value: %.2f\n",
				total,
				tip);
	}

}
