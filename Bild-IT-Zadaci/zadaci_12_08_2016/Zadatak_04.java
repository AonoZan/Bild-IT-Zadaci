/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_12_08_2016;

public class Zadatak_04 {
	public static int[] sort(int a, int b, int c) {
		int[] sorted = new int[3];
		if (a <= b && a <= c) {
			sorted[0] = a;
			if (b < c) {
				sorted[1] = b;
				sorted[2] = c;
			} else {
				sorted[1] = c;
				sorted[2] = b;
			}
		} else if (b <= a && b <= c) {
			sorted[0] = b;
		} else {
			sorted[0] = c;
		}
		return sorted;
	}
	public static void main(String[] args) {
		System.out.println("Enter three numbers.");
		int number1 = 0, number2 = 0, number3 = 0;
		while (true) {
			try {
				System.out.print("Enter first number: ");
				number1 = zadaci_01_08_2016.Zadatak_05.readFromConsole(number1);
				System.out.print("Enter second number: ");
				number2 = zadaci_01_08_2016.Zadatak_05.readFromConsole(number1);
				System.out.print("Enter third number: ");
				number3 = zadaci_01_08_2016.Zadatak_05.readFromConsole(number1);
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
			}
		}
	}

}
