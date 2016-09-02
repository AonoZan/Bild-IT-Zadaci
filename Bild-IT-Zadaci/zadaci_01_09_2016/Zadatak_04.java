
package zadaci_01_09_2016;

import java.util.ArrayList;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_04 {
	/** Method returns random integer in range.*/
	public static int randInt(int from, int to) {
		return from + (int)(Math.random() * (to - from));
	}
	/** Method fills array with random values in range */
	public static void genRand(ArrayList<Number> list, int amount, int from, int to) {
		// loop desired number times and add random number
		for (int i = 0; i < amount; i++) {
			list.add(randInt(0, 10));
		}
	}
	/** Method shuffles list. */
	public static void shuffle(ArrayList<Number> list) {
		// loop over size of the list
		for (int i = 0; i < list.size(); i++) {
			// generate random index and switch values
			int randIndex = randInt(0, list.size());
			Number tmp = list.get(i);
			list.set(i, list.get(randIndex));
			list.set(randIndex, tmp);
		}
	}
	// print list
	public static void printList(ArrayList<Number> list) {
		for (Number number : list) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
	/** Program generates random list and shuffles it. */
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<>();
		// generate list and print it
		System.out.print("Random list: ");
		genRand(list, 10, 0, 10);
		printList(list);
		// shuffle and print again
		System.out.print("Shuffled: ");
		shuffle(list);
		printList(list);
	}

}

