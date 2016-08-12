/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_12_08_2016;

public class Zadatak_04 {
	/**
	 * Method for sorting three integers. 
	 * @param a
	 * @param b
	 * @param c
	 * @return List of three values lowest to greatest.
	 */
	public static int[] sort(int a, int b, int c) {
		// create list to store values
		int[] sorted = new int[3];
		if (a <= b && a <= c) {			// if first number is lowest
			sorted[0] = a;
			if (b < c) {				// if second number is lower than third
				sorted[1] = b;
				sorted[2] = c;
			} else {					// else third is lower
				sorted[1] = c;
				sorted[2] = b;
			}
		} else if (b <= a && b <= c) {	// if second number is lowest
			sorted[0] = b;
			if (a < c) {				// if first number is lower than third
				sorted[1] = a;
				sorted[2] = c;
			} else {					// else third is lower
				sorted[1] = c;
				sorted[2] = a;
			}
		} else {						// else third is lowest
			sorted[0] = c;
			if (a < b) {				// if first is lower than second
				sorted[1] = a;
				sorted[2] = b;
			} else {					// else second is lower
				sorted[1] = b;
				sorted[2] = a;
			}
		}
		return sorted;
	}
	/**
	 * Program asks user for three integers and then print's those lowest to greatest on console
	 * @param args
	 */
	public static void main(String[] args) {
		// prompt user for three number and ask for values
		System.out.println("Enter three numbers.");
		int number1 = 0, number2 = 0, number3 = 0;
		while (true) {
			// try to get values and if user make mistake ask again
			try {
				System.out.print("Enter first number: ");
				number1 = zadaci_01_08_2016.Zadatak_05.readFromConsole(number1);
				System.out.print("Enter second number: ");
				number2 = zadaci_01_08_2016.Zadatak_05.readFromConsole(number1);
				System.out.print("Enter third number: ");
				number3 = zadaci_01_08_2016.Zadatak_05.readFromConsole(number1);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
			}
		}
		// sort numbers in list and print it
		int[] sorted = sort(number1, number2, number3);
		System.out.printf("Sorted numbers: %d, %d, %d.",
				sorted[0],
				sorted[1],
				sorted[2]);
		zadaci_01_08_2016.Zadatak_02.closeUserInput();
	}

}
