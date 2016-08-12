/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_12_08_2016;

public class Zadatak_02 {
	/**
	 * Program asks for two numbers and then prints lowest and greatest common divisors.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter two numbers(non zero).");
		// get two numbers from user
		int number1 = 0, number2 = 0;
		while (true) {
			try {
				// if first one on default get new value
				if (number1 == 0) {
					System.out.print("Enter first number: ");
					number1 = zadaci_01_08_2016.Zadatak_05.readFromConsole(number1);
					// if user enters default value ask again
					if (number1 <= 0) {
						number1 = 0;
						continue;
					}
				}
				// if second one on default get new value
				if (number2 == 0) {
					System.out.print("Enter second number: ");
					number2 = zadaci_01_08_2016.Zadatak_05.readFromConsole(number2);
					// if user enters default value ask again
					if (number2 <= 0) {
						number2 = 0;
						continue;
					}
				}
				// exit when done
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// switch values if first one bigger
		if (number1 > number2) {
			number1 += number2;
			number2 = number1 - number2;
			number1 -= number2;
		}
		// loop over and get lowest and biggest common divider
		int lowestDivider = 1, greatestDivider = 1;
		for (int i = 2; i <= number1; i++) {
			// check only those numbers that are divisable
			if (number1 % i == 0 && number2 % i == 0) {
				// set lowest first time only
				if (lowestDivider == 1) lowestDivider = i;
				greatestDivider = i;
			}
		}
		System.out.printf("Greatest common divider for %d %d is %d and lowest %d.\n",
				number1, number2, greatestDivider, lowestDivider);
	}

}
