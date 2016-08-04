/**@autor AonoZan Dejan Petrovic 2016 ©
 */
package zadaci_02_08_2016;
import java.util.ArrayList;

public class Zadatak_01 {
	/**
	 * Method for printing list of elements. Useful for debug.
	 * @param list of elements
	 * @param separators is string list that contains separators
	 * to print between values and at the end(need to be two values, or leave as null for default)
	 * @param alignment is used to align values with string format
	 * @param newLine is value that says when to break in new line. 0 for only one value per line
	 * @throws Exception If argument is in some case null then throw exception.
	 */
	public static void printList(int[] list, String[] separators, int alignment, int newLine) throws Exception{
		// if invalid argument fix it
		if (alignment < 1) alignment = 1;
		if (newLine < 1) newLine = 1;
		if (separators == null || separators.length < 2) separators = new String[]{", ", ".\n"};
		// make sure list is not null
		if (list != null) {
			// print all elements except last one with separators
			for (int i = 0; i < list.length-1; i++) {
				if (i % newLine == 0 && i != 0) System.out.println();
				System.out.printf("%"+alignment+"d"+ separators[0], list[i]);
			}
			// go to new line only if there is reminder
			if (list.length-1 % newLine == 0 || list.length % newLine == 1) System.out.println();
			// print last element, add separator and switch to new line
			System.out.printf("%"+alignment+"d"+separators[1], list[list.length-1]);
		// if it is throw exception with message
		} else {
			throw new Exception("List has no value. (null).");
		}
	}
	/**
	 * Method for printing list of elements. Useful for debug.
	 * @param list of elements
	 * @param separators is string list that contains separators
	 * to print between values and at the end(need to be two values, or leave as null for default)
	 * @param alignment is used to align values with string format
	 * @param newLine is value that says when to break in new line. 0 for only one value per line
	 * @throws Exception If argument is in some case null then throw exception.
	 */
	public static void printList(ArrayList<Integer> list, String[] separators, int alignment, int newLine) throws Exception{
		// if invalid argument fix it
		if (alignment < 1) alignment = 1;
		if (newLine < 1) newLine = 1;
		if (separators == null || separators.length < 2) separators = new String[]{", ", ".\n"};
		// make sure list is not null
		if (list != null) {
			// print all elements except last one with comma separated
			for (int i = 0; i < list.size()-1; i++) {
				if (i % newLine == 0 && i != 0) System.out.println();
				System.out.printf("%"+alignment+"d"+ separators[0], list.get(i));
			}
			// go to new line only if there is reminder
			if (list.size()-1 % newLine == 0 || list.size() % newLine == 1) System.out.println();
			// print last element, add dot sighn and switch to new line
			System.out.printf("%"+alignment+"d"+separators[1], list.get(list.size()-1));
		// if it is throw exception with message
		} else {
			throw new Exception("List has no value. (null).");
		}
	}
	public static void main(String[] args) throws Exception {
		// create new array list for storing all leap aears and
		// year counter start and stop
		ArrayList<Integer> yearList = new ArrayList<>();
		int yearStart = 101;
		int yearStop = 2100;
		// loop between start and stop year counteg and add every leap year to list
		for (int i = yearStart; i <= yearStop; i++) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) yearList.add(i);
		}
		// try to print all years
		try {
			printList(yearList, new String[]{" ", "\n"}, 4, 10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// print total
		System.out.printf("\nLeap years from %d to %d: %d\n", yearStart, yearStop, yearList.size());
//		printList(Zadatak_04.generateRandom(0, 9, 230), null, 2, 5);
	}
}
