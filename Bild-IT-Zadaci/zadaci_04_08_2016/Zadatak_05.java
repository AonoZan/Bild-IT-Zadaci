/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_04_08_2016;

public class Zadatak_05 {
	/**
	 * Method for calculating sum of all values in list.
	 * Method can handle sum of values that don't exceed Long.MAX_VALUE(9.223.372.036.854.775.807).
	 * @param list of any number of values
	 * @return 0 if null is passed as argument or sum of values in list as long
	 */
	public static long sum(int[] list) {
		// if argument is null return 0
		if (list == null) {
			System.out.println("Can't sumarize list.(null argument)");
			return 0;
		}
		// calculate and return sum
		long sum = 0;
		for (int i : list) sum += i;
		return sum;
	}
	/**
	 * Method asks user for values and fills them in list until 0 is entered.
	 * Maximum length of list is 100 items. After list is filled average is calculated and
	 * list is checked for count of values that are below average or above or equal.
	 * @param args
	 */
	public static void main(String[] args) {
		// create list and variable that will store user input
		int[] list = new int[100];
		int userInput = 0;
		// loop trough whole list
		System.out.println("Enter numbers(0 breaks input, max input values 100)");
		for (int i = 0; i < list.length; i++) {
			try {
				// prompt user for correct integer value
				System.out.printf("Enter %d value: ", (i + 1));
				userInput = zadaci_01_08_2016.Zadatak_05.readFromConsole(userInput);
				// if user enters 0 break
				if (userInput == 0) break;
				// or add item to the list
				list[i] = userInput;
			// print error message and reset counter
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
				i--;
			}
		}
		// clean list from empty items
		list = zadaci_01_08_2016.Zadatak_05.cleanList(list, 0);
		// calculate average from sum of all items and count how many that are below average
		int average = (int)(sum(list) / list.length), belowAverage = 0;
		for (int i : list) {
			if (i < average) belowAverage++;
		}
		System.out.printf("List status:"
				+ "\n\tBelow awerage in list count: %d"
				+ "\n\tAbove or equal to average: %d",
				belowAverage, list.length - belowAverage);
	}
}
