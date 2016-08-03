/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_03_08_2016;

public class Zadatak_02 {
	// Create variable that holds Scanner and method that closes it
	private static java.util.Scanner userInput = new java.util.Scanner(System.in);
	private static void closeUserInput() {userInput.close();}
	
	/**
	 * Method for cleaning list from specific value. 
	 * @param list is what will be cleaned
	 * @param regex every value that match this in list will be removed
	 * @return list without regex values
	 */
	public static double[] cleanList(double[] list, double regex) {
		// create default values
		StringBuilder cleanedList = new StringBuilder();
		int length = 0;
		// go trough every item in list and append it to sting if its not regex
		for (double i : list) {
			if (i != regex) {
				cleanedList.append(i + " ");
				length++;
			}
		}
		// make list size match length of how much items are counted
		list = new double[length];
		// go trough splited list, convert it to double and add it to list
		for (String s : cleanedList.toString().split(" ")) {
			list[list.length-length] = Double.valueOf(s);
			length--;
		}
		return list;
	}
	/**
	 * Method that reads only double or int values values from console.
	 * If something else is entered an exception is raised.
	 * @param number this is needed to tell Java that we need double value from user
	 * @return double value
	 * @throws Exception This is raised if user enters string or character
	 */
	public static double readFromConsole(double number) throws Exception{
		// gather input
		String consoleInput = userInput.nextLine().trim();
		// if only whitespaces are entered raise exception
		if (consoleInput.length() < 1) throw new Exception("Empty input.(whitespace)");
		// try to parse double from first word (splited string)
		try {
			number = Double.valueOf(consoleInput.split(" ")[0]);
		// if error occurs throw specific exception to tell what happened
		} catch (Exception e) {
			throw new Exception("Input is not a decimal number.");
		}
		return number;
	}
	/**
	 * Method to make easy entering lots of decimal values from console.
	 * List will be updated and new values will be added infinetely until 0 value is entered.
	 * @param list to be filled with values
	 * @return list that has user entered values
	 */
	public static double[] fillListFromConsoleInput(double[] list) {
		// set default values
		double inputNumber = 1;
		int counter = 0;
		// loop until 0 is entered
		while(inputNumber != 0) {
			// try to get right value from user
			try {
				System.out.print("Enter decimal value(0 to stop): ");
				inputNumber = readFromConsole(inputNumber);
				list[counter] = inputNumber;
				counter++;
				// if list gets filled double the space
				if (counter == list.length) {
					double[] userNumbersTmp = new double[counter * 2];
					for (int i = 0; i < counter; i++) {
						userNumbersTmp[i] = list[i];
					}
					list = userNumbersTmp;
				}
				System.out.println();
			// if error occurs print message
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		// return cleaned list from zeroes(empty values)
		return cleanList(list, 0);
	}
	/**
	 * Method for printing list of elements. Useful for debug.
	 * @param list of elements
	 * @throws Exception If argument is in some case null then throw exception.
	 */
	public static void printList(double[] list) throws Exception{
		// make sure list is not null
		if (list != null) {
			// print all elements except last one with comma separated
			for (int i = 0; i < list.length-1; i++) {
				System.out.printf("%.2f, ", list[i]);
			}
			// print last element, add dot sign and switch to new line
			System.out.printf("%.2f.", list[list.length-1]);
		// if it is throw exception with message
		} else {
			throw new Exception("List has no value. (null).");
		}
	}
	/**
	 * Method for finding lowest value in list.
	 * Whole list is searched and last value that is lowest or equal to every other lowest is returned.
	 * @param array list of double values
	 * @return 0 if list is empty or null, lower value if list contains values
	 */
	public static double min(double[] array) {
		// check if list contains anything and return 0 if it doesn't
		if (array == null || array.length < 1) {
			System.out.println("List is empty or null.(0 is returned)");
			return 0;
		// if list contains only one item return it immediately
		} else if (array.length == 1) return array[0];
		// set possible minimal value to first one in the list
		double min = array[0];
		// loop trough every item and update min if necessary
		for (double d : array) {
			if (min > d) min = d;
		}
		return min;
	}
	/**
	 * Main method that creates list of decimal values and fills it with values from console until 0 is inserted.
	 * And then prints lowest decimal value in the list.
	 * @param args
	 */
	public static void main(String[] args) {
		// create list and fill it with values that user provides
		double[] userNumbers = fillListFromConsoleInput(new double[1]);
//		// try to print list
//		try {
//			printList(userNumbers);
//			System.out.println();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		// print lowest decimal in list
		System.out.printf("Lowest value taken from console is %.2f.", min(userNumbers));
		// close Scanner
		closeUserInput();
	}
}
