/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_04_08_2016;

public class Zadatak_05 {
	public static int sum(int[] list) {
		// if argument is null return 0
		if (list == null) {
			System.out.println("Can't sumarize list.(null argument)");
			return 0;
		}
		// calculate and return sum
		int sum = 0;
		for (int i : list) sum += i;
		return sum;
	}
	public static void main(String[] args) {
		int[] list = new int[100];
		int userInput = 0;
		System.out.println("Enter numbers(0 breaks input, max input values 100)");
		for (int i = 0; i < list.length; i++) {
			try {
				System.out.printf("Enter %d value: ", (i + 1));
				userInput = zadaci_01_08_2016.Zadatak_05.readFromConsole(userInput);
				if (userInput == 0) break;
				list[i] = userInput;
				
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
				i--;
			}
		}
		list = zadaci_01_08_2016.Zadatak_05.cleanList(list, 0);
		int average = sum(list) / list.length, belowAverage = 0;
		for (int i : list) {
			if (i < average) belowAverage++;
		}
		System.out.printf("List status:"
				+ "\n\tBelow awerage in list count: %d"
				+ "\n\tAbove or equal to average: %d",
				belowAverage, list.length - belowAverage);
	}
}
