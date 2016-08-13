/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_13_08_2016;

public class Zadatak_05 {
	/**
	 * Program asks for weight and price of two packages and prnts whicever has better price/weight.
	 * @param args
	 */
	public static void main(String[] args) {
		// create variables and prompt user to enter values
		double pack1Weight = 0, pack2Weight = 0;
		double pack1Price = 0, pack2Price = 0;
		System.out.println("Enter weight and price for two packets.\n(0 and negative are not alowed)");
		while (true) {
			// try to get values and if user enters 0 or negative ask again for that value
			try {
				if (pack1Weight <= 0) {
					System.out.print("Enter first package weight: ");
					pack1Weight = zadaci_03_08_2016.Zadatak_02.readFromConsole(pack1Weight);
					if (pack1Weight <= 0) continue;
				}
				if (pack1Price <= 0) {
					System.out.print("Enter first package price: ");
					pack1Price = zadaci_03_08_2016.Zadatak_02.readFromConsole(pack1Weight);
					if (pack1Price <= 0) continue;
				}
				if (pack2Weight <= 0) {
					System.out.print("Enter second package weight: ");
					pack2Weight = zadaci_03_08_2016.Zadatak_02.readFromConsole(pack1Weight);
					if (pack2Weight <= 0) continue;
				}
				if (pack2Price <= 0) {
					System.out.print("Enter second package price: ");
					pack2Price = zadaci_03_08_2016.Zadatak_02.readFromConsole(pack1Weight);
					if (pack2Price <= 0) continue;
				}
				break;
			// if user enters wrong character print message
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// compare price and weight and print message
		if ((pack1Weight / pack1Price) > (pack2Weight / pack2Price)) {
			System.out.println("First package has better price.");
		} else {
			System.out.println("Second package has better price.");
		}
	}
}
