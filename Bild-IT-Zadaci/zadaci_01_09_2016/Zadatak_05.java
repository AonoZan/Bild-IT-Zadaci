
package zadaci_01_09_2016;

import java.util.ArrayList;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/** Method sorts array list of Number's. */
	public static void sort(ArrayList<Number> list) {
		// constant for number one
		final int ONE = 1;
		// loop until last number
		for (int i = 0; i < list.size() - ONE; i++) {
			// boolean finished if finish early
			boolean finished = true;
			// loop to last sorted
			for (int j = 0; j < list.size() - ONE - i; j++) {
				// if this one bigger than next one switch values
				if (list.get(j).intValue() > list.get(j + ONE).intValue()) {
					Number tmp = list.get(j);
					list.set(j, list.get(j + ONE));
					list.set(j + ONE, tmp);
					// not finished yet
					finished = false;
				}
			}
			// if finished break
			if (finished) {
				break;
			}
			
		}
	}
	/** Program generates list and sorts it. */
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<>();
		// generate list and print it
		System.out.print("Random list: ");
		Zadatak_04.genRand(list, 10, 0, 10);
		Zadatak_04.printList(list);
		// sort and print again
		System.out.print("Sorted:      ");
		sort(list);
		Zadatak_04.printList(list);
	}

}

