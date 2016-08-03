/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_01_08_2016;

public class Zadatak_04 {
	/**
	 * Method generates random numbers and fills list. 
	 * @param from any random value bigger than this number
	 * @param to any random walue less than this number
	 * @param amount of how big list should be
	 * @return List that contains random nummbers or null if from and to arguments are same value
	 * @throws Exception If value parameter is invalid
	 */
	public static int[] generateRandom(int from, int to, int amount) throws Exception{
		int[] integers;
		// if amount is invalid throw exception othervise create list with "amount" length
		if (amount <= 0) {
			throw new Exception("Cant generate list of random values.\nAmount value for int list can't be less than 1.");
		} else {
			integers = new int[amount];
		}
		// if arguments have same value return 0 immediately
		if (from == to) return null;
		// or if first argument is bigger than second switch them
		else if (from > to) {
			to += from;
			from = to - from;
			to -= from;
		}
		// loop through list and assign random number for each value
		for (int i = 0; i < integers.length; i++) {
			integers[i] = from + (int)(Math.random() * (to - from + 1)); 
		}
		return integers;
	}
	/**
	 * Method for sorting list of integers. 
	 * @param list that needs to be sorted
	 * @return New sorted list
	 * @throws Exception If list is null.
	 */
	public static int[] sort(int[] list) throws Exception{
		// if list is null throw an exception with message
		if (list == null) {
			throw new Exception("Can't sort list. List has no value(null).");
		}
		// loop from first element to next-to last one
		for (int i = 0; i < list.length-1; i++) {
			// set boolean value so that we can exit when we are sure we finished
			boolean finished = true;
			// loop from first one to last one sorted
			for (int j = 0; j < list.length-i-1; j++) {
				// if current element is bigger than next one switch them and
				// set boolean that we are still not sure if we sorted everything
				if (list[j] > list[j+1]) {
					int tmp = list[j];
					list[j] = list[j+1];
					list[j+1] = tmp;
					finished = false;
				}
			}
			// if finished early break
			if(finished) break;
		}
		return list;
	}
	/**
	 * Method for printing list of elements. Useful for debug.
	 * @param list of elements
	 * @throws Exception If argument is in some case null then throw exception.
	 */
	public static void printList(int[] list) throws Exception{
		// make sure list is not null
		if (list != null) {
			// print all elements except last one with comma separated
			for (int i = 0; i < list.length-1; i++) {
				System.out.printf("%d, ", list[i]);
			}
			// print last element, add dot sighn and switch to new line
			System.out.println(list[list.length-1] + ".");
		// if it is throw exception with message
		} else {
			throw new Exception("List has no value. (null).");
		}
	}
	/**
	 * Method for counting how much some value occurs in list.
	 * Method first tries to sort list and then counts all occurences with newly sorted list.
	 * @param list of elements
	 */
	public static void printOccurenceCount(int[] list){
		// try to sort list and if error occurs print message and return
		int[] sortedList;
		try {
			sortedList = sort(list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		// set default values
		int counter = 1;
		String fixWord = "";
		boolean print = false;
		// loop through list from second element to last one
		for (int i = 1; i < sortedList.length; i++) {
			// if current element is different from prewious one print occurence of last one
			if (sortedList[i] != sortedList[i-1]){
				print = true;
			// else if it's end of list print list but add one more for counter
			} else if (i == sortedList.length-1) {
				print = true;
				counter++;
			// else just count one more occurence
			} else {
				counter++;
			}
			
			// set fixWord to correct value, print message and reset values
			if (print) {
				if (counter > 1) fixWord = "'s";
				else fixWord = "";
				System.out.printf("%d occurs %d time%s.\n", sortedList[i-1], counter, fixWord);
				counter = 1;
				print = false;
			}
		}
	}
	/**
	 * Main method that generates some random list and then prints with initial
	 * values, sorted values and count of occurences of every unique values in list
	 * @param args
	 * @throws Exception If list cant be created, sorted or printed.
	 */
	public static void main(String[] args) throws Exception {
//		// try to print list
//		try {
//			printList(generateRandom(0, 9, 100));
////			printList(null);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		
//		System.out.println("\n-------------------------------\n");
//		// try to generate list
//		int[] randomIntegers = {0};
//		try {
//			randomIntegers = generateRandom(0, 9, 100);
////			randomIntegers = generateRandom(0, 9, 0);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.exit(0);
//		}
//		
//		System.out.println("\n-------------------------------\n");
		// create list with random values
		int[] occurenceList = generateRandom(0, 9, 100);
		// print it
		printList(occurenceList);
		// print it sorted
		printList(sort(occurenceList));
		// print how many occurences in list
		printOccurenceCount(occurenceList);
		// try to mess things up
//		printOccurenceCount(null);
		
	}
}
