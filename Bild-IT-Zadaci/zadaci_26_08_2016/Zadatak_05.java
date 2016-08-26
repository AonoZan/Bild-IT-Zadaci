
package zadaci_26_08_2016;

import java.util.ArrayList;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class Zadatak_05 {
	/**Method shuffles values in an array list of integers.*/
	public static void shuffle(ArrayList<Integer> list) {
		// return if wrong argument
		if (list == null) return;
		// create temporary integer and index
		Integer tmpInt;
		int index;
		// loop oveer list
		for (int i = 0; i < list.size(); i++) {
			// get random index and item on that index
			index = (int)(Math.random() * list.size());
			tmpInt = list.get(index);
			// switch values inside list
			list.set(index, list.get(i));
			list.set(i, tmpInt);
		}
	}
	public static void main(String[] args) {
		// create list and add values
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		// print original
		System.out.println("Original list:");
		for (Integer integer : list) {
			System.out.print(integer.intValue() + " ");
		}
		// shuffle and print again
		shuffle(list);
		System.out.println("\nShuffled list:");
		for (Integer integer : list) {
			System.out.print(integer.intValue() + " ");
		}
	}

}

