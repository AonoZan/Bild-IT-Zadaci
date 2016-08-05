/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_01_08_2016;

public class Zadatak_05 {
	/**
	 * Method for cleaning list from specific value. 
	 * @param list is what will be cleaned
	 * @param regex every value that match this in list will be removed
	 * @return
	 */
	public static int[] cleanList(int[] list, int regex) {
		// check if list can be cleaned
		if (list == null) {
			System.out.println("Can't clean list(null argument).");
			return null;
		} else if (list.length == 1) return list;
		// create default values
		StringBuilder cleanedList = new StringBuilder();
		int length = 0;
		// go trough every item in list and append it to sting if its not regex
		for (int i : list) {
			if (i != regex) {
				cleanedList.append(i + " ");
				length++;
			}
		}
		// if all item are cleaned return null
		if (cleanedList.length() < 1) {
			System.out.println("All items cleaned from list.");
			return null;
		}
		// make list size match length of how much items are counted
		list = new int[length];
		// go trough splited list, convert it to int and add it to list
		for (String s : cleanedList.toString().split(" ")) {
			list[list.length-length] = Integer.valueOf(s);
			length--;
		}
		return list;
	}
	/**
	 * Method that reads only int values from console.
	 * If something else is entered an exception is raised.
	 * @param number this is needed to tell Java that we need int value from user
	 * @return int value
	 * @throws Exception This is raised if user enters string or character
	 */
	public static int readFromConsole(int number) throws Exception{
		// gather input
		String consoleInput = Zadatak_02.userInput.nextLine().trim();
		// if only whitespaces are entered raise exception
		if (consoleInput.length() < 1) throw new Exception("Empty input.(whitespace)");
		// try to parse int from first word (splited string)
		try {
			number = Integer.parseInt(consoleInput.split(" ")[0]);
		// if error occurs throw specific exception to tell what happened
		} catch (Exception e) {
			throw new Exception("Input is not a number.");
		}
		return number;
	}
	/**
	 * Method to make easy entering lots of integer values from console.
	 * List will be updated and new values will be added infinetely until 0 value is entered.
	 * @param list to be filled with values
	 * @return list that has user entered values
	 */
	public static int[] fillListFromConsoleInput(int[] list) {
		// chack if passed list has value
		if (list == null) {
			System.out.println("Cant fill list that has no values or is null.(null is returned)");
			return null;
		}
		// set default values
		int inputNumber = 1, counter = 0;
		// loop until 0 is entered
		while(inputNumber != 0 && counter < list.length) {
			// try to get right value from user
			try {
				System.out.print("Enter " + counter + " value: ");
				inputNumber = readFromConsole(inputNumber);
				list[counter] = inputNumber;
				counter++;
			// if error occurs print message
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Try again.");
			}
		}
		// return cleaned list from 0
		return list;
	}
	/**
	 * Method for printing status message of occurence of largest number in list.
	 * If list contains one element it will be handled immediately as well if list is null.
	 * @param list of integers
	 */
	public static void printLargest(int[] list) {
		if (list == null) {
			System.out.println("Can't print largest(argument is null).");
			return;
		}
		int[] sortedList;
		String fixWord = "";
		try {
			// if list contains only one element there is no need to go further
			if (list.length == 1) {
				System.out.printf("Only one element in list: %d\n", list[0]);
				return;
			}
			// try to sort list
			sortedList = Zadatak_04.sort(list);
//			// print list for debug purpose
//			Zadatak_04.printList(sortedList);
		// if error occurs print message and return
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		// go from next-to last element to first one
		for (int i = sortedList.length-2; i >= 0; i--) {
			// if you hit diferent value or you reach end of the list
			if (sortedList[i] != sortedList[i+1] || i == 0) {
				// set appropriate fixWord
				if (sortedList.length - i != 0) fixWord = "'s";
				// print status and break 
				System.out.printf("Largest number taken from console is %d and it occured %d time%s.",
						sortedList[i+1], sortedList.length - i - Math.min(sortedList[i+1] - sortedList[i], 1), fixWord);
				break;
			}
		}
	}
	/**
	 * Main method that creates list and fills it with values from console until 0 is inserted.
	 * And then prints largest number in list as well as how many times that number occured.
	 * @param args
	 */
	public static void main(String[] args) {
		// prompt user for list of numbers
		System.out.println("Enter list of numbers:");
		// create list and fill it with values that user provides
		int[] userNumbers = fillListFromConsoleInput(new int[100]);
		userNumbers = cleanList(userNumbers, 0);
//		// try to print list
//		try {
//			Zadatak_04.printList(userNumbers);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		// print status of largest in list and how much of those in list
		printLargest(userNumbers);
		// close Scanner
		Zadatak_02.closeUserInput();
	}
}
